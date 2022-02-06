package be.he2b.atlr5.skyjo.server.secondaryServers;

import be.he2b.atlr5.skyjo.playerMsg.*;
import be.he2b.atlr5.skyjo.skyjoPlayer.*;
import be.he2b.atlr5.skyjo.model.*;
import be.he2b.atlr5.skyjo.otherMsg.OtherMsg;
import be.he2b.atlr5.skyjo.server.motherServer.PrimaryServer;
import be.he2b.atlr5.skyjo.serverMsg.SrvMsgType;
import java.io.IOException;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SecondaryServer {

    private static final int MAX_PLAYERS = 8;
    private static final int MIN_PLAYERS = 2;
    private PlayerThread firstPlayerConnected;
    private PlayerThread sndPlayerConnected;
    private Facade game;
    private final int srvID;
    private boolean full;
    private final GameMembers members;
    private final List<PlayerThread> playerThreads;
    private int memberID;
    private boolean gameStarted;
    private final PrimaryServer server;
    private boolean notify;
    private List<Player> tempThread;

    /**
     * @param srvID the id given by the main Server to identify him
     * @param server
     * @brief Construct the skyjo second server is the middle server that handle
     * a game with all his players
     */
    public SecondaryServer(int srvID, PrimaryServer server) {
        this.srvID = srvID;
        this.full = false;
        this.members = new GameMembers();
        this.playerThreads = new ArrayList<>();
        tempThread = new ArrayList<>();
        gameStarted = false;
        this.server = server;
        this.notify = false;

    }

    /**
     * card object hit by the game
     *
     * @return Card Object
     */
    public Card makeHit() {
        return this.game.hit();
    }

    /**
     * getter of full boolean to know if the server is can still receive client
     * or not
     *
     * @return boolean true if the server can't receive and false if he can
     */
    public boolean isFull() {
        return full;
    }

    /**
     * Create a new user and add it to the members of the game
     *
     * @param name the name of the client connected
     * @param type userType if it's the first client connected the type will be
     * admin and if not the type will be other
     */
    private void addUser(String name, UserType type) {
        memberID++;
        members.addUser(new User(name, memberID, type));

    }

    /**
     * the method to call when a new client is connected and need to join a game
     * session
     *
     * @param clientSocket the socket of the client connected
     */
    public void receivedData(Socket clientSocket) {
        this.playerThreads.add(new PlayerThread(this, clientSocket));
        this.playerThreads.stream().
                filter(x -> x.getState() == Thread.State.NEW).
                forEach(Thread::start);

    }

    /**
     * return true if theirs no user in the member object and false if not
     *
     * @return boolean true/false
     */
    private boolean noMembers() {
        return members.noUsers();
    }

    /**
     * getter for the game
     *
     * @return Model ( game )
     */
    public Facade getGame() {
        return game;
    }

    /**
     * return true if game is over or not
     *
     * @return boolean true/false
     */
    public boolean gameIsOver() {
        return this.game.isOver();
    }

    /**
     * return the state of the gameStarted attribute
     *
     * @return boolean true/false
     */
    public boolean isGameStarted() {
        return gameStarted;
    }

    /**
     * method use to create user and send msg to the client when it's created
     * for them to know their status
     *
     * @param name the name of the user
     */
    public void createUser(String name) {
        if (!name.isEmpty()) {
            if (noMembers()) {
                firstPlayerConnected = getCurrentPlayerThread();
                addUser(name, UserType.ADMIN);
                firstPlayerConnected.setUser(members.findAUser(1));
                firstPlayerConnected.setNoObjectToSend(SrvMsgType.USER_CREATED);
                firstPlayerConnected.sendToClient(null);
            } else {
                if (playerThreads.size() == MAX_PLAYERS) {
                    full = true;
                } else {
                    if (isNotValid(name)) {
                        var playerThread = getCurrentPlayerThread();
                        playerThread.setNoObjectToSend(SrvMsgType.INVALID_NAME);
                        playerThread.sendToClient(null);
                    } else {
                        if (twoClientOnly()) {
                            notifyAllPlayerOnlineStatus();
                            sendMsgToFirstAndSndPlayerConnected(name);
                        } else {
                            if (gameStarted) {
                                addNewUser(name);

                            } else {
                                if (notify) {
                                    addUserWithOutGameCreated(name);
                                } else {
                                    PlayerThread admin = getAdmin();
                                    if (admin != null) {
                                        notify = true;
                                        admin.setNoObjectToSend(SrvMsgType.ALL_PLAYER_ONLINE);
                                        admin.sendToClient(null);
                                        sendMsgToFirstAndSndPlayerConnected(name);
                                    }

                                }

                            }

                        }

                    }
                }

            }
        } else {
            var playerThread = getCurrentPlayerThread();
            playerThread.setNoObjectToSend(SrvMsgType.INVALID_NAME);
            playerThread.sendToClient(null);

        }
    }

    private boolean twoClientOnly() {
        return playerThreads.size() == MIN_PLAYERS;
    }

    /**
     * Send a message to the Admin user to notify him when a new player is
     * online
     */
    private void notifyAllPlayerOnlineStatus() {
        if (firstPlayerConnected != null) {
            notify = true;
            firstPlayerConnected.setNoObjectToSend(SrvMsgType.ALL_PLAYER_ONLINE);
            firstPlayerConnected.sendToClient(null);
        }
    }

    private void addUserWithOutGameCreated(String name) {
        addUser(name, UserType.OTHER);
        var currentThread = getCurrentPlayerThread();
        currentThread.setUser(members.findAUser(memberID));
        tempThread.add(new Player(new PlayerDetails(currentThread.get_id(), currentThread.get_Name())));
        currentThread.setNoObjectToSend(SrvMsgType.USER_CREATED);
        currentThread.sendToClient(null);

    }

    /**
     * get the admin thread
     *
     * @return admin Player Thread
     */
    private PlayerThread getAdmin() {
        return playerThreads.stream().
                filter(x -> {
                    return x.getUser() != null
                            && x.getUser().getType() == UserType.ADMIN;
                }).
                toList().get(0);

    }

    /**
     * Send a user created type message to the user that is newly created and
     * send to the admin user that the user is ready and can start the game
     *
     * @param name name given by the new player connected
     */
    private void sendMsgToFirstAndSndPlayerConnected(String name) {
        addUser(name, UserType.OTHER);
        sndPlayerConnected = getCurrentPlayerThread();
        sndPlayerConnected.setUser(members.findAUser(memberID));
        sndPlayerConnected.setNoObjectToSend(SrvMsgType.USER_CREATED);
        sndPlayerConnected.sendToClient(null);
        firstPlayerConnected.setNoObjectToSend(SrvMsgType.USER_READY);
        firstPlayerConnected.sendToClient(null);

    }

    /**
     * return the playerThread that is running to apply some modification
     *
     * @return PlayerThread Object
     */
    private PlayerThread getCurrentPlayerThread() {
        return playerThreads.stream().filter(x -> x.getId()
                == Thread.currentThread().
                        getId()).toList().get(0);
    }

    /**
     * return true if the name given is already in the members
     *
     * @param name of the player newly connected
     * @return true if match false if not
     */
    private boolean isNotValid(String name) {
        return members.getUsers().stream().
                anyMatch(x -> x.getName().contains(name));

    }

    /**
     * Create a new object of game and send to all players online
     */
    public void creatGame() {
        this.game = new Game(new PlayerDetails(firstPlayerConnected.get_id(),
                firstPlayerConnected.get_Name()),
                new PlayerDetails(sndPlayerConnected.get_id(),
                        sndPlayerConnected.get_Name()));
        if (tempThread.isEmpty()) {
            this.game.revealCard();
        } else {

            this.game.addNewPlayers(tempThread);
            this.game.updatePlayers();
        }

        gameStarted = true;
        playerThreads.forEach(player -> {
            player.setPlaying(true);
            player.sendToClient(this.game);
        });
    }

    /**
     * Apply the discard action according to the card received
     *
     * @param card send by the player
     */
    public synchronized void applyDiscardAction(Card card) {
        try {
            this.game.setCardCurrentPlayer(card);
            this.game.updateGame(PlayerChoice.DISCARD);
        } catch (IllegalStateException e) {
            System.out.println("Error");
        }
    }

    /**
     * update the score of the game
     */
    public synchronized void updateScore() {
        this.game.updateScore();
    }

    /**
     * switch the players
     */
    public synchronized void switchPlayers() {
        this.game.switchPlayer();
    }

    /**
     * send the game to all the players for further update
     */
    public void notifyEveryBodyGameUpdate() {
        this.playerThreads.
                forEach(playerThread -> playerThread.sendToClient(this.game));
    }

    /**
     * return a player information ask by a player
     *
     * @param name of the player
     * @return Player
     */
    public synchronized Player playerAskFor(String name) {
        return this.game.getPlayerWithName(name);
    }

    /**
     * apply the pitched action
     *
     * @param msg the message received by the player
     */
    public synchronized void applyPitchedAction(UserMsg msg) {
        var cardReceived = (Card) msg.getContent();
        var pickOption = msg.getPlayerPickOption();
        try {
            PlayerChoice choice = null;
            switch (pickOption) {
                case 1 ->
                    choice = PlayerChoice.PICK_KEEP;
                case -1 ->
                    choice = PlayerChoice.PICK_DROP;
            }
            game.setCardCurrentPlayer(cardReceived);
            game.updateGame(choice);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    /**
     * Show information about thread and message received
     *
     * @param thread the thread running
     * @param type the Message type send by the player
     */
    public void showStatus(PlayerThread thread, MsgType type) {
        System.out.println("-----------SHOW GAME MANAGER STATE---------------");
        System.out.println("ID gestionnaire du jeu en cours: " + srvID);
        System.out.println("Jeu en cours ?: " + gameStarted);
        System.out.println("Nombre de joueur: " + playerThreads.size());
        System.out.println("Type de message:" + type);
        System.out.println("Nom du thread courant : "+ thread.getName());
        if (thread.getUser() != null) {
            System.out.println("Nom du joueur :" + thread.get_Name());
            System.out.println("ID joueur : " + thread.get_id());
        }
        System.out.println("-------------------------------------------------------\n");

    }

    /**
     * This function handle the way a client is disconnected
     *
     * @param thread the current thread that stop
     */
    public void handleUserDisconnected(PlayerThread thread) {
        if (!thread.userIsNUll()) {
            System.out.println("User Disconnected | Name : " + thread.
                    get_Name() + "| ID: " + thread.get_id() + " |");
            members.removeUser(thread.get_id());
            if (game != null) {
                if (!gameIsOver()) {
                    if (game.getCurrentPlayer().getPlayerID() == thread.get_id()) {
                        game.switchPlayer();
                    }
                    this.game.removePlayer(thread.get_id());
                    playerThreads.stream().
                            filter(x -> x.getId() != thread.getId()).
                            forEach(x -> x.sendToClient(this.game));
                }

            }

        }
        try {
            thread.closeConnexion();
            this.playerThreads.remove(thread);
        } catch (IOException ex) {
            Logger.getLogger(SecondaryServer.class.
                    getName()).log(Level.SEVERE, null, ex);
        }
        if (this.playerThreads.isEmpty()) {
            this.server.stopMotherServer();
        }

    }

    /**
     * This function close all the connection of all the thread connected and
     * ask the mother server to stop
     */
    public void closedSession() {
        playerThreads.forEach((PlayerThread x) -> {
            try {
                x.closeConnexion();
            } catch (IOException ex) {
                Logger.getLogger(SecondaryServer.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        });
        this.server.stopMotherServer();
    }

    /**
     * add a new user to the game
     *
     * @param name user name
     */
    private void addNewUser(String name) {
        synchronized (this) {
            addUser(name, UserType.OTHER);
            var user = members.findAUser(memberID);
            this.game.
                    addNewPlayer(new Player(new PlayerDetails(user.
                            getID(), user.getName())));
            var playerThread = getCurrentPlayerThread();
            playerThread.setUser(user);
            playerThreads.stream().
                    filter(x -> {
                        return x.getUser() != null && x.get_id()
                                != playerThread.get_id() && x.isPlaying();
                    }).
                    forEach(x -> x.sendToClient(this.game));
            playerThread.sendToClient(new OtherMsg(user, this.game));

        }

    }
}
