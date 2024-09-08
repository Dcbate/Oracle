package leetcode.validparentheses;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidParenthesesTest {

    @Test
    public void testIsValid() {
        ValidParentheses solution = new ValidParentheses();

        // Test case 1: Simple valid parentheses
        assertTrue(solution.isValid("()"));

        // Test case 2: Valid combination of different types
        assertTrue(solution.isValid("()[]{}"));

        // Test case 3: Nested valid parentheses
        assertTrue(solution.isValid("{[()]}"));

        // Test case 4: Single closing parenthesis, invalid
        assertFalse(solution.isValid("("));

        // Test case 5: Mismatched parentheses, invalid
        assertFalse(solution.isValid("([)]"));

        // Test case 6: Unbalanced parentheses, invalid
        assertFalse(solution.isValid("((()"));

        // Test case 7: Empty string, should be valid
        assertTrue(solution.isValid(""));

        // Test case 8: Valid long string of balanced parentheses
        assertTrue(solution.isValid("(([[{{}}]]))"));

        // Test case 9: Extra closing bracket at the end, invalid
        assertFalse(solution.isValid("()[]{}]"));
    }
}