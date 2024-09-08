package leetcode.validpalindrome;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidPalindromeTest {

    @Test
    public void testIsPalindrome() {
        // Test case 1: Simple palindrome
        assertTrue(ValidPalindrome.isPalindrome("A man a plan a canal Panama"));

        // Test case 2: Palindrome with numbers
        assertTrue(ValidPalindrome.isPalindrome("12321"));

        // Test case 3: Non-palindrome
        assertFalse(ValidPalindrome.isPalindrome("hello"));

        // Test case 4: Empty string
        assertTrue(ValidPalindrome.isPalindrome(""));

        // Test case 5: Single character (should be a palindrome)
        assertTrue(ValidPalindrome.isPalindrome("a"));

        // Test case 6: Palindrome with special characters
        assertTrue(ValidPalindrome.isPalindrome("Madam, I'm Adam!"));

        // Test case 7: Non-palindrome with special characters
        assertFalse(ValidPalindrome.isPalindrome("This is not a palindrome!"));

        // Test case 8: Palindrome with uppercase letters
        assertTrue(ValidPalindrome.isPalindrome("No lemon, no melon"));
    }

}