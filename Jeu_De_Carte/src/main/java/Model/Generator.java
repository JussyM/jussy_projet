package Model;

import Model.Cards.Card;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Generator {

    private String word;
    private Card []card;
    private final int level;

    /**
     *
     * @param level
     */
    public Generator(int level) {
        this.level = level;
    }

    /**
     *
     * @return
     */
    public String getWord() {
        return word;
    }

    /**
     *
     * @return
     */
    public Card[] getCard() {
        return card;
    }

    /**
     *
     * @param level
     * @throws IOException
     */
    public void wordGenerator(int level) throws IOException {
        List<String> wordChoosen = wordAvailable();
        var nbOfChar = level + 2 + level;
        var randomIndex = randomWordIndex(wordChoosen.size() - 1, 0);
        word = wordChoosen.get(randomIndex);
        while (word.toCharArray().length != nbOfChar) {
            randomIndex = randomWordIndex(wordChoosen.size() - 1, 0);
            word = wordChoosen.get(randomIndex);
        }

    }

    public void cardGenerator(int level) {

    }

    /**
     *
     * @return @throws IOException
     */
    private List<String> wordAvailable() throws IOException {
        List<String> words = new ArrayList<>();

        BufferedReader fileReaderWithBuffer = null;

        String wordFromFile;

        try {

            fileReaderWithBuffer = new BufferedReader(new FileReader("/home"
                    + "/jj/Loupita/ressource/dictionnaire.txt"));

        } catch (FileNotFoundException e) {

            System.out.println(e.getMessage());

        }

        while ((wordFromFile = fileReaderWithBuffer.readLine()) != null) {

            words.add(wordFromFile);

        }

        return words;
    }

    /**
     *
     * @param max
     * @param min
     * @return
     */
    private int randomWordIndex(int max, int min) {
        return (int) (Math.random() * (max - min + 1) + min);
    }
}
