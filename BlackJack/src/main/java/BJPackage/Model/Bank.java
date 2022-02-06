package BJPackage.Model;


public class Bank extends Player {
    /**
     * Bank player constructor
     */
    public Bank() {
        super();
    }

    /**
     *  calculate the score of the bank
     */
    @Override
    public void calculScore() {
        super.calculScore();

    }

    /**
     * return the bank object to string
     * @return bank
     */
    @Override
    public String toString() {
        return "Bank player";
    }
}
