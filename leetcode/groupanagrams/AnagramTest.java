package leetcode.groupanagrams;

import org.junit.Test;

import static leetcode.groupanagrams.GroupAnagrams.solution;
import static org.junit.Assert.*;
import java.util.*;


public class AnagramTest {

    @Test
    public void testWithAnagrams() {
        String[] input = {"act", "pots", "tops", "cat", "stop", "hat"};
        List<List<String>> expectedOutput = Arrays.asList(
                Arrays.asList("act", "cat"),
                Arrays.asList("pots", "tops", "stop"),
                Arrays.asList("hat")
        );
        List<List<String>> result = solution(input);
        assertTrue(compareLists(result, expectedOutput));
    }

    // Test Case 2: Testing with a single element
    @Test
    public void testWithSingleElement() {
        String[] input = {"x"};
        List<List<String>> expectedOutput = Arrays.asList(
                Arrays.asList("x")
        );
        List<List<String>> result = solution(input);
        assertTrue(compareLists(result, expectedOutput));
    }

    // Test Case 3: Testing with empty string
    @Test
    public void testWithEmptyString() {
        String[] input = {""};
        List<List<String>> expectedOutput = Arrays.asList(
                Arrays.asList("")
        );
        List<List<String>> result = solution(input);
        assertTrue(compareLists(result, expectedOutput));
    }

    // Helper function to compare two lists of lists, ensuring that each inner list has the same elements.
    private boolean compareLists(List<List<String>> result, List<List<String>> expectedOutput) {
        if (result.size() != expectedOutput.size()) {
            return false;
        }

        for (List<String> list : result) {
            Collections.sort(list);
        }

        for (List<String> list : expectedOutput) {
            Collections.sort(list);
        }

        return new HashSet<>(result).equals(new HashSet<>(expectedOutput));
    }
}