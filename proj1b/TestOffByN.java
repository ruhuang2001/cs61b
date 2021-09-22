import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    @Test
    public void testOffBy4() {
        OffByN offby4 = new OffByN(4);
        assertTrue(offby4.equalChars('a', 'e'));
        assertTrue(offby4.equalChars('e', 'a'));
        assertFalse(offby4.equalChars('b', 'g'));
        assertFalse(offby4.equalChars('g', 'h'));
    }

    @Test 
    public void testOffBy1() {
        OffByN offby1 = new OffByN(1);
        assertTrue(offby1.equalChars('a', 'b'));
        assertTrue(offby1.equalChars('&', '%'));
        assertFalse(offby1.equalChars('b', 'g'));
        assertFalse(offby1.equalChars('g', 'm'));
    }

    @Test 
    public void testOffBy0() {
        OffByN offby0 = new OffByN(0);
        assertTrue(offby0.equalChars('a', 'a'));
        assertFalse(offby0.equalChars('g', 'm'));
    }
}
