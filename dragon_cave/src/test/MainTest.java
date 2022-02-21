import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void enter() {
        assertEquals(" He opens his jaws and...\nGobbles you down in one bite!\n\n\n", Main.enter(1));
    }

    @Test
    void main() {
    }
}