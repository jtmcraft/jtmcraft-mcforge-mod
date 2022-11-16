package net.fasilsmp.ratcage.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class XorGateTests {
    private XorGate gate;

    @BeforeEach
    public void runBeforeEachUnitTest() {
        gate = new XorGate();
    }

    @Test
    public void testGate() {
        assertFalse(gate.apply(0, 0));
        assertTrue(gate.apply(0, 1));
        assertTrue(gate.apply(1, 0));
        assertFalse(gate.apply(1, 1));
    }
}
