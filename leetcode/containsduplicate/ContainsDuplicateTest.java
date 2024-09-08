package leetcode.twosum;

import leetcode.containsduplicate.ContainsDuplicate;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashSet;

public class ContainsDuplicateTest {

    @Test
    public void testContainsDuplicate() {
        ContainsDuplicate solution = new ContainsDuplicate();

        // Test case 1: No duplicates
        boolean result = solution.containsDuplicate(new int[]{1, 2, 3, 4});
        assertFalse(result);

        // Test case 2: Contains duplicates
        result = solution.containsDuplicate(new int[]{1, 2, 3, 1});
        assertTrue(result);

        // Test case 3: Array with all identical elements
        result = solution.containsDuplicate(new int[]{5, 5, 5, 5});
        assertTrue(result);

        // Test case 4: Empty array
        result = solution.containsDuplicate(new int[]{});
        assertFalse(result);

        // Test case 5: Array with a single element
        result = solution.containsDuplicate(new int[]{42});
        assertFalse(result);
    }
}