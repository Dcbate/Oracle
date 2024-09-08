package leetcode.singlenumber;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SingleNumberTest {

    @Test
    public void testSingleNumber() {
        // Test case 1: Single number is 4
        assertEquals(4, SingleNumber.singleNumber(new int[]{1, 1, 4, 3, 3, 2, 2, 5, 5}));

        // Test case 2: Single number is 7
        assertEquals(7, SingleNumber.singleNumber(new int[]{2, 2, 3, 3, 7}));

        // Test case 3: Single number is 10
        assertEquals(10, SingleNumber.singleNumber(new int[]{10}));

        // Test case 4: Single number is negative
        assertEquals(-1, SingleNumber.singleNumber(new int[]{-1, 2, 2, 3, 3}));

        // Test case 5: Larger set with single number in the middle
        assertEquals(9, SingleNumber.singleNumber(new int[]{1, 1, 2, 2, 3, 3, 9, 4, 4}));

        // Test case 6: Single number is at the end of the array
        assertEquals(99, SingleNumber.singleNumber(new int[]{44, 44, 99}));
    }
}