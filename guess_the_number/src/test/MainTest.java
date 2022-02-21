
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void takeGuess() {
        Main.correctNum = 4;
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("true");
        expected.add("Low");
        assertEquals(expected, Main.takeGuess(4));
    }

    @Test
    void begin() {
    }

    @Test
    void main() {
    }
}