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
    public void TestOffByOne {
        CharacterComparator cc = new OffByN(4);
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
