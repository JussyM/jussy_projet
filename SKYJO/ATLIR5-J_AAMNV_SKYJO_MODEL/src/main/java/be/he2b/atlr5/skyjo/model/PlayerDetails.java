package be.he2b.atlr5.skyjo.model;

import java.io.Serializable;

/**
 * store the player information ( name and ID)
 *
 * @author
 */
public class PlayerDetails implements Serializable {

    private final int playerID;
    private final String playerName;

    /**
     * Constructor for playerDetails
     * @param playerID the player ID
     * @param playerName the player name
     */
    public PlayerDetails(int playerID, String playerName) {
        this.playerID = playerID;
        this.playerName = playerName;
    }

    /**
     * getter of player id
     * @return ID
     */
    public int getPlayerID() {
        return playerID;
    }

    /** 
     * getter of the player name
     * @return player name
     */
    public String getPlayerName() {
        return playerName;
    }
}
