import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HangmanTest {

    @BeforeEach
    void setUp() {
        final Hangman app = new Hangman();
        app.init();

        ArrayList<Character> wrong = new ArrayList<Character>();

        app.setWord("platinum");
        app.setCharactersNeeded(app.getWord().length());
        wrong.add('e');
        wrong.add('c');
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getWordBank() {
    }

    @Test
    void getCharactersNeeded() {
        Hangman app = new Hangman();

        app.init();

        assertEquals(8, app.getCharactersNeeded());
    }
}