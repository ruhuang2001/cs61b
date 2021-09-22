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
        assertFalse
    }

    @Test
    public void testOffByOne() {
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("", cc));
        assertTrue(palindrome.isPalindrome("s", cc));
        assertFalse(palindrome.isPalindrome("aab", cc));
        assertFalse(palindrome.isPalindrome("aadv", cc));
    }

    @Test
    public void testOffBy4() {
        CharacterComparator cc = new OffByN(4);
        assertTrue(palindrome.isPalindrome("", cc));
        assertTrue(palindrome.isPalindrome("s", cc));
        assertFalse(palindrome.isPalindrome("aab", cc));
        assertFalse(palindrome.isPalindrome("aadv", cc));
    }
}
