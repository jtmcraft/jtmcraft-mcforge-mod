package net.fasilsmp.ratcage.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SimpleLatchTests {
    private Latch latch;
    private boolean powered;
    private boolean input;

    @BeforeEach
    public void runBeforeEachTest() {
        latch = new SimpleLatch();
    }

    @Test
    public void givenPoweredAndInputAreTrue_ThenReturnFalse() {
        powered = true;
        input = true;

        assertFalse(latch.apply(powered, input));
    }

    @Test
    public void givenPoweredAndNotInputAreTrue_ThenReturnNull() {
        powered = true;
        input = false;

        assertNull(latch.apply(powered, input));
    }

    @Test
    public void givenNotPoweredAndInputAreTrue_ThenReturnTrue() {
        powered = false;
        input = true;

        assertTrue(latch.apply(powered, input));
    }

    @Test
    public void givenNotPoweredAndNotInputAreTrue_ThenReturnNull() {
        powered = false;
        input = false;

        assertNull(latch.apply(powered, input));
    }
}
