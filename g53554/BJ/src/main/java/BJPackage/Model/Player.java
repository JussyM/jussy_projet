package BJPackage.Model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public final static int MAX_SCORE = 21;
    private final List<Card> hand;
    private int mise;
    private int score;
    private State state;

    /**
     * @return
     */
    public int getScore() {
        return score;
    }

    /**
     * @return
     */
    public int getMise() {
        return mise;
    }

    /**
     *
     */
    public Player() {
        hand = new ArrayList<>();
        this.mise = 0;
        this.score = 0;
        this.state = State.NEUTRE;

    }

    public Player(Player player) {
        this.hand = player.getHand();
        this.mise = player.getMise();
        this.score = player.getScore();
        this.state = player.getState();

    }

    /**
     * @return
     */
    public State getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * @return
     */
    @Override
    public String toString() {
        return "Principal player";
    }

    public void insertMise(int mise) {
        this.mise = mise;
    }

    /**
     * @param card
     */
    public void addCart(Card card) {
        hand.add(card);
    }

    /**
     * @return
     */
    public List<Card> getHand() {
        return hand;
    }

    /**
     *
     */
    public void calculScore() {
        this.score = playerScore();

    }

    /**
     * @return
     */
    public int playerScore() {
        if (strike()) return MAX_SCORE;
        return getHand().stream().mapToInt(x -> x.getValue().getValue()).sum();
    }

    /**
     * @return
     */
    private boolean strike() {
        return this.getHand().contains(new Card(Color.SPADE, Value.ACE)) &&
                (this.getHand().contains(new Card(Color.SPADE, Value.KING)) ||
                        (this.getHand().contains(new Card(Color.SPADE, Value.QUEEN)) ||
                                (this.getHand().contains(new Card(Color.SPADE, Value.TEN)) ||
                                        (this.getHand().contains(new Card(Color.SPADE, Value.JACK))))));
    }

    public boolean beat(Player player) {
        return (this.getScore() > this.getScore() && this.getScore() <= Player.MAX_SCORE) ||
                (this.getScore() <= Player.MAX_SCORE && this.getScore() > Player.MAX_SCORE);
    }
    public boolean isOutOfBound(){
        return getScore()>=Player.MAX_SCORE;
    }


}
