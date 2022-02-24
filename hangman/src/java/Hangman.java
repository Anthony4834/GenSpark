import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Scanner;

import static javafx.application.Platform.exit;

public class Hangman {

    private String word;
    private int charactersNeeded;
    private String boxes;
    private final String[] wordBank = {"word", "cat", "donut", "genspark", "iridocyclitis"};
    private ArrayList<Character> wrongGuesses;

    public Hangman() {
    }

    public void init() {
        p("Initializing..");

        setWord(getWordBank()[(int) Math.floor(Math.random() * 5)]);
        setCharactersNeeded(getWord().length());

        setBoxes(String.join("", Collections.nCopies(getCharactersNeeded(), "_")));
        setWrongGuesses(new ArrayList<Character>());

        p("H A N G M A N\n\n");
        begin();

    }
    private void begin() {
        p(buildHangMan(getWrongGuesses().size()));
        p("Guess a letter");

        try {
            Scanner input = new Scanner(System.in);
            char guess = input.nextLine().charAt(0);

            checkIfContains(word, guess, false);

            int gameStatus = checkGameStatus();

            switch(gameStatus) {
                case 0:
                    begin();
                    break;
                case -1:
                    p("Better luck next time!");
                    playAgain();
                    break;
                case 1:
                    p("You guessed it! Congrats!");
                    playAgain();
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            p("Try again..");
            begin();
        }

    }
    private void playAgain() {
        p("Play again? [Y/N]");
        Scanner again = new Scanner(System.in);
        char playingAgain = again.nextLine().toLowerCase().charAt(0);

        if(playingAgain == 'y')
            init();
    }
    private String buildHangMan(int wrongGuesses) {
        String output = "+---+\n";

        output = output + String.format("%s   |\n%s   |\n%s   |\n%s%s ===",
                wrongGuesses >= 1 ? "O" : " ",
                wrongGuesses >= 2 ? "|" : " ",
                wrongGuesses >= 3 ? "|" : " ",
                wrongGuesses >= 4 ? "/" : " ",
                wrongGuesses >= 5 ? " \\" : " ");
        return String.format("%s\n\n%s\n\nMissed Letters: %s", output, boxes, getWrongGuesses().toString());
    }
    private int checkGameStatus() {
        if(getWrongGuesses().size() >= 5) {
            p(buildHangMan(getWrongGuesses().size()));
            return -1;
        }
        if(checkIfContains(getBoxes(), '_', true) == -1)
            return 1;
        return 0;
    }
    private int checkIfContains(String s, char c, boolean test) {
        if(getWrongGuesses().contains(c) && test == false) {
            p("You have already guessed that letter..\n");
            return 0;
        }

        char[] arr = s.toCharArray();
        boolean found = false;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == c) {
                found = true;
                if (i == 0)
                    setBoxes(c + getBoxes().substring(i + 1));
                else
                    setBoxes(getBoxes().substring(0, i) + c + getBoxes().substring(i + 1));
            }
        }

        if(found == false) {
            if(!test)
                getWrongGuesses().add(c);
            return -1;
        } else
            return 0;
    }

    public String[] getWordBank() {
        return wordBank;
    }
    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCharactersNeeded() {
        return charactersNeeded;
    }

    public void setCharactersNeeded(int charactersNeeded) {
        this.charactersNeeded = charactersNeeded;
    }
    public String getBoxes() {
        return this.boxes;
    }
    public void setBoxes(String boxes) {
        this.boxes = boxes;
    }

    public ArrayList<Character> getWrongGuesses() {
        return wrongGuesses;
    }

    public void setWrongGuesses(ArrayList<Character> wrongGuesses) {
        this.wrongGuesses = wrongGuesses;
    }
    public static void p(String input) {
        System.out.println(input);
    }
}
