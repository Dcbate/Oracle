package leetcode.plusone;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;

public class PlusOneTest {

    @Test
    public void testPlusOne() {
        // Test case 1: Normal case, no trailing nines
        assertArrayEquals(new int[]{4, 4, 0, 0}, PlusOne.plusOne(new int[]{4, 3, 9, 9}));

        // Test case 2: Array with no nines
        assertArrayEquals(new int[]{1, 2, 4}, PlusOne.plusOne(new int[]{1, 2, 3}));

        // Test case 3: Array with a single nine, should carry over
        assertArrayEquals(new int[]{1, 0}, PlusOne.plusOne(new int[]{9}));

        // Test case 4: Array with all trailing nines
        assertArrayEquals(new int[]{1, 0, 0, 0}, PlusOne.plusOne(new int[]{9, 9, 9}));

        // Test case 5: Empty array (edge case)
        assertArrayEquals(new int[]{1}, PlusOne.plusOne(new int[]{}));

        // Test case 6: Array with multiple digits where the last one is nine
        assertArrayEquals(new int[]{2, 0}, PlusOne.plusOne(new int[]{1, 9}));

        // Test case 7: Array with leading zeros
        assertArrayEquals(new int[]{0, 0, 2}, PlusOne.plusOne(new int[]{0, 0, 1}));
    }
}