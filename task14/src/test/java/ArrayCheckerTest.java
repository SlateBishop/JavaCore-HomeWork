import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayCheckerTest {

    private ArrayChecker arrayChecker;
    private int[] test1 = {1, 1, 2, 2};
    private int[] test2 = {1, 1, 3, 2, 2};

    @Before
    public void init() {
        arrayChecker = new ArrayChecker();
    }

    @Test
    public void testArrayChecker1() {
        assertTrue(arrayChecker.arrayCheck(test1, 1, 2));
    }

    @Test
    public void testArrayChecker2() {
        assertFalse(arrayChecker.arrayCheck(test2, 1, 2));
    }

    @Test
    public void testArrayChecker3() {
        assertFalse(arrayChecker.arrayCheck(test1, 3, 4));
    }

    @Test
    public void testArrayChecker4() {
        assertFalse(arrayChecker.arrayCheck(null, 3, 4));
    }


}