//import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayCuterTest { //extends TestCase {

    private ArrayCuter arrayCuter;
    private int[] test1 = {1, 2, 3, 4, 5};
    private int[] test2 = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5};

    @Before
    public void init() {
        arrayCuter = new ArrayCuter();
    }

    @Test
    /*
    Тест падает с NullPointerException, не понимаю почему.
    В интернете нашел случаи, где у людей это случалось в методе, когда они к длине массива аппелировали,
    который имел значение null или т.п. Но я изначально прописал в начале метода проверку, что если массив null,
    то необходимо сразу вернуть null.
    Самостоятельно не смог разобраться с ошибкой, прошу подсказать.
    Проверил в основном классе, там корректно выдает null
            System.out.println(Arrays.toString(arrayCuter.cutArray(null, 3)));
     */
    public void testNull() {
        assertNull(arrayCuter.cutArray(null, 0));
    }

    @Test
    public void testNull2() {
        assertNull(arrayCuter.cutArray(test1, 5));
    }

    @Test
    public void testCutArray1() {
        assertArrayEquals(test1, arrayCuter.cutArray(test1, 0));
    }

    @Test
    public void testCutArray2() {
        int[] testExpection = {4, 5};
        assertArrayEquals(testExpection, arrayCuter.cutArray(test2, 3));
    }


}