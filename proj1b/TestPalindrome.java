import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("ghost");
        String actual = "";
        for (int i = 0; i < "ghost".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("ghost", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("goog"));
        assertFalse(palindrome.isPalindrome("agds"));
        assertFalse(palindrome.isPalindrome("horsA"));
    }

    @Test
    public void testOffByOne() {
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("", cc));
        assertTrue(palindrome.isPalindrome("a", cc));
        assertTrue(palindrome.isPalindrome("flake", cc));
        assertFalse(palindrome.isPalindrome("aabaa", cc));
        assertFalse(palindrome.isPalindrome("noon", cc));
    }

    @Test
    public void testOffBy5() {
        CharacterComparator cc = new OffByN(5);
        assertTrue(palindrome.isPalindrome("", cc));
        assertTrue(palindrome.isPalindrome("a", cc));
        assertTrue(palindrome.isPalindrome("bing", cc));
        assertFalse(palindrome.isPalindrome("aabaa", cc));
        assertFalse(palindrome.isPalindrome("noon", cc));
    }
}
