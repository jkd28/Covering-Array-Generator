import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PairwiseTest {
    @Test
    public void testValidInput(){
        String[] valid = {"this", "is", "valid", "input"};
        assertTrue(Pairwise.validInput(valid));
    }

    @Test
    public void testInvalidInput(){
        String[] invalid = {"NOTVALID"};
        assertFalse(Pairwise.validInput(invalid));
    }

    @Test
    public void testNoInput(){
        assertFalse(Pairwise.validInput(null));
    }

    @Test
    public void testTruncationLongWords(){
        String[] longWords = {
            "Thisisaprettylongword",
            "Thisoneisalsoprettylong",
            "wowthesearereallylong",
            "thisshoulddefinitelybetruncated"
        };

        String[] expected = {
            "Thisisapre",
            "Thisoneisa",
            "wowthesear",
            "thisshould"
        };
        assertArrayEquals(expected, Pairwise.truncate(longWords));
    }

    @Test
    public void testTruncationShortWords(){
        String[] shortWords = {
            "short",
            "wow",
            "muchsmall",
            "suchshort"
        };

        String[] expected = {
            "short",
            "wow",
            "muchsmall",
            "suchshort"
        };
        assertArrayEquals(expected, Pairwise.truncate(shortWords));
    }

    @Test
    public void testTruncateNull(){
        String[] returned = Pairwise.truncate(null);
        assertEquals(0, returned.length);
    }

    @Test
    public void testTruthTableGeneratorNull(){
        assertNull(Pairwise.getTruthTable(0));
        assertNull(Pairwise.getTruthTable(-3));
    }

    @Test
    public void testTruthTableGenerator(){
        boolean[][] truth = Pairwise.getTruthTable(2);
        // Test some location againts the formula for truthTable value generation
        assertEquals(truth[2][1], (2 / (int)Math.pow(2, 1)) % 2 == 0);
    }
}
