import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {
    @Test
    public void TestOffBy4() {
        OffByN offby4 = new OffByN(4);
        assertTrue(offby4.equalChars('a', 'e'));
        assertTrue(offby4.equalChars('e', 'a'));
        assertFalse(offby4.equalChars('b', 'g'));
        assertFalse(offby4.equalChars('g', 'h'));
    }

    @Test 
    public void TestOffBy1() {
        OffByN offby1 = new OffByN(1);
        assertTrue(offby4.equalChars('a', 'b'));
        assertTrue(offby4.equalChars('&', '%'));
        assertFalse(offby4.equalChars('b', 'g'));
        assertFalse(offby4.equalChars('g', 'm'));
    }

    @Test 
    public void TestOffBy0() {
        OffByN offby0 = new OffByN(0);
        assertTrue(offby4.equalChars('a', 'a'));
        assertFalse(offby4.equalChars('g', 'm'));
    }
}
