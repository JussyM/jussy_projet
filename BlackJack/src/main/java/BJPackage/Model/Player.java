package BJPackage.Model;

import java.util.ArrayList;
import java.util.List;

public class Player {
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
        if (strike()) return 21;
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


}
