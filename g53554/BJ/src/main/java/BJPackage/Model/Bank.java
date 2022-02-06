package BJPackage.Model;


public class Bank extends Player {
    public final static int MAX_SCORE = 17;
    public final static int BANK_BET = 500;

    /**
     * Bank player constructor
     */
    public Bank() {
        super();
    }

    /**
     * calculate the score of the bank
     */
    @Override
    public void calculScore() {
        super.calculScore();

    }
    public void pic(Deck deck) {
        while (getScore() < Bank.MAX_SCORE) {
            addCart(deck.hit());
            calculScore();
        }
    }
    public Bank(Bank bank){
        super(bank);
    }

    /**
     * return the bank object to string
     *
     * @return bank
     */
    @Override
    public String toString() {
        return "Bank player";
    }

}
