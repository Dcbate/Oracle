package leetcode.summaryranges;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SummaryRangesTest {

    @Test
    public void testSummaryRanges() {
        // Test case 1: Simple continuous range
        List<String> result = SummaryRanges.summaryRanges(new int[]{0, 1, 2, 4, 5, 7});
        assertEquals(List.of("0 -> 2", "4 -> 5", "7"), result);

        // Test case 2: Single element in the array
        result = SummaryRanges.summaryRanges(new int[]{3});
        assertEquals(List.of("3"), result);

        // Test case 3: Non-continuous elements
        result = SummaryRanges.summaryRanges(new int[]{1, 3, 5, 7});
        assertEquals(List.of("1", "3", "5", "7"), result);

        // Test case 4: Array with one long continuous range
        result = SummaryRanges.summaryRanges(new int[]{1, 2, 3, 4, 5});
        assertEquals(List.of("1 -> 5"), result);

        // Test case 5: Empty array (edge case)
        result = SummaryRanges.summaryRanges(new int[]{});
        assertTrue(result.isEmpty());

        // Test case 6: Array with negative numbers and continuous ranges
        result = SummaryRanges.summaryRanges(new int[]{-3, -2, -1, 1, 2, 3});
        assertEquals(List.of("-3 -> -1", "1 -> 3"), result);

        // Test case 7: Array with both single elements and ranges
        result = SummaryRanges.summaryRanges(new int[]{0, 1, 2, 4, 6, 7, 9});
        assertEquals(List.of("0 -> 2", "4", "6 -> 7", "9"), result);
    }
}