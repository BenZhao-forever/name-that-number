import static org.junit.jupiter.api.Assertions.*;

class namenumTest {

    @org.junit.jupiter.api.Test
    void isMatched() {
        assertThrows(IllegalArgumentException.class, () -> namenum.isMatched(null, "4734"));
        assertThrows(IllegalArgumentException.class, () -> namenum.isMatched("ABCD", null));
        assertTrue(namenum.isMatched("GREG", "4734"));
        assertFalse(namenum.isMatched("GREGE", "4734"));
        assertFalse(namenum.isMatched("GREG", "4735"));
    }
}