package JeuCarte;

import java.util.Arrays;
import java.util.Random;

/**
 * Diverses méthodes utiles pour les tableau.
 */
public class ArrayUtil {

    /**
     * Mélange le tableau.
     *
     * @param array le tableau à mélanger.
     */
    public static void shuffle(int[] array) {
        int index, temp;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            swap(array, i, index);
        }
    }

    /**
     * Échange le contenu de deux cases de tableau. Échange dans le tableau
     * <code>array</code> le contenu des cases en positions <code>pos1</code> et
     * <code>pos2</code>. Ces 2 positions sont supposées correctes.
     *
     * @param array le tableau dont on échange 2 cases.
     * @param pos1 la position de la première case à échanger.
     * @param pos2 la position de la seconde case à échanger.
     */
    public static void swap(int[] array, int pos1, int pos2) {
        int savedValue = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = savedValue;
    }

    public static void main(String[] args) {
        int[] ta = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        shuffle(ta);
        System.out.println(Arrays.toString(ta));
    }
}
