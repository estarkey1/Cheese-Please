import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CheesePleaseTest {
    private CheesePlease game;

    @BeforeEach
    public void setUp() {
        game = new CheesePlease();
    }

    @Test
    public void testStealthStrategy() {
        StealthStrategy stealth = new StealthStrategy();
        assertEquals(3, stealth.getTurnCost());
    }

    @Test
    public void testRunStrategy() {
        RunStrategy run = new RunStrategy();
        assertEquals(1, run.getTurnCost());
    }

    @Test
    public void testWaitStrategy() {
        WaitStrategy wait = new WaitStrategy();
        assertEquals(1, wait.getTurnCost());
    }

    @Test
    public void testInvalidMovementChoice() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            MovementStrategyFactory.getStrategy(4);
        });
        assertEquals("Invalid choice", exception.getMessage());
    }
}
