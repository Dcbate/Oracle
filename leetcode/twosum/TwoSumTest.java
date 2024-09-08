package leetcode.twosum;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;

public class TwoSumTest {

    @Test
    public void testTwoSum() {
        TwoSum solution = new TwoSum();

        // Test case 1
        int[] result = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        assertArrayEquals(new int[]{0, 1}, result);

        // Test case 2
        result = solution.twoSum(new int[]{3, 2, 4}, 6);
        assertArrayEquals(new int[]{1, 2}, result);

        // Test case 3
        result = solution.twoSum(new int[]{3, 3}, 6);
        assertArrayEquals(new int[]{0, 1}, result);
    }

    @Test
    public void testTwoSumWithMap() {
        TwoSum solution = new TwoSum();

        // Test case 1
        int[] result = solution.twoSumWithMap(new int[]{2, 7, 11, 15}, 9);
        assertArrayEquals(new int[]{0, 1}, result);

        // Test case 2
        result = solution.twoSumWithMap(new int[]{3, 2, 4}, 6);
        assertArrayEquals(new int[]{1, 2}, result);

        // Test case 3
        result = solution.twoSumWithMap(new int[]{3, 3}, 6);
        assertArrayEquals(new int[]{0, 1}, result);

        // Test case 4: Large array
        result = solution.twoSumWithMap(new int[]{3, 3, 34, 324, 23, 423, 43, 4234, 32, 4325, 45, 3, 5, 6, 7, 6574563, 67, 8, 76867865, 634, 6435, 34, 567, 45, 645, 63, 34, 6564, 64, 634535, 5, 5, 4, 23675, 23, 4553523, 4, 5, 2342344, 23, 5, 4324234, 5, 5645, 65, 6, 456, 34, 52345, 3, 45234, 23, 42, 34}, 76);
        assertArrayEquals(new int[]{2, 52}, result); // Assuming these are the correct indices
    }

    @Test
    public void testNoSolution() {
        TwoSum solution = new TwoSum();

        // Test case where no solution exists
        int[] result = solution.twoSumWithMap(new int[]{1, 2, 3}, 10);
        assertArrayEquals(new int[]{0, 0}, result);

        result = solution.twoSum(new int[]{1, 2, 3}, 10);
        assertArrayEquals(new int[]{0, 0}, result);
    }
}
