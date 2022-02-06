package JeuCarte;

public class MemoryUtil {

    /**
     * Affiche l'état actuel des cartes.
     * Une carte ramassées est indiquée par sa valeur.
     * Un "?" indique une carte pas encore ramassée.
     * @param cards les cartes.
     * @param collectedCards indique quelles cartes ont été ramassées.
     */
    public static void displayCards(int[] cards, boolean[] collectedCards) {
        System.out.print("Les cartes: ");
        for(int i=0; i<collectedCards.length; i++) {
            System.out.print( (collectedCards[i] ? cards[i] : "?") + " "); 
        }
        System.out.println();
    }
}