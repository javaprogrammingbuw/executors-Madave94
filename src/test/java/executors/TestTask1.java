package executors;

import org.junit.Test;

//import static org.junit.Assert.assertArrayEquals;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;

public class TestTask1  {

    @Test
    public void testSmallArray() throws InterruptedException, ExecutionException {
        int[] arr = {1,5,10,7,8,4,12,9,5,6};
        int result = new Task1().quickSum(arr);
        assertEquals(67, result);
    }

    @Test
    public void testLargeArray() throws InterruptedException, ExecutionException{
        int[] arr = {1555, -32143214, 3412412, -75985, 483254, 243198, -13034,
                1240, 12304, -825064, 34214, 98703, -209476, 42945, 42848, -428484,
                -1248341, 431242, 757550, 1019850, 421045876, -428944, -13209986,
                382184,  -4298429, 12494, 4102248, 14204, -1298502, 14209845,
                1243444, -129421, -312321321, -5392, -658359, 31412, -42142, -72178421,
                42142, -9757494, 31232321, 6964853, 142052, 1423942, 419421904, 1404194,
                1555, -32143214, 3412412, -75985, 483254, 243198, -13034, 1240, 12304,
                -825064, 34214, 98703, -209476, 42945, 42848, -428484, -1248341, 431242,
                757550, 1019850, 421045876, -428944, -13209986, 382184,  -4298429,
                12494, 4102248, 14204, -1298502, 14209845, 1243444, -129421,
                -312321321, -5392, -658359, 31412, -42142, -72178421, 42142, -9757494,
                31232321, 6964853, 142052, 1423942, 419421904, 1404194, 1555, -32143214,
                3412412, -75985, 483254, 243198, -13034, 1240, 12304, -825064, 34214, 98703,
                -209476, 42945, 42848, -428484, -1248341, 431242, 757550, 1019850, 421045876,
                -428944, -13209986, 382184,  -4298429, 12494, 4102248, 14204, -1298502,
                14209845, 1243444, -129421, -312321321, -5392, -658359, 31412, -42142, -72178421,
                42142, -9757494, 31232321, 6964853, 142052, 1423942, 419421904, 1404194,
                1555, -32143214, 3412412, -75985, 483254, 243198, -13034, 1240, 12304, -825064,
                34214, 98703, -209476, 42945, 42848, -428484, -1248341, 431242, 757550, 1019850,
                421045876, -428944, -13209986, 382184,  -4298429, 12494, 4102248, 14204,
                -1298502, 14209845, 1243444, -129421, -312321321, -5392, -658359, 31412, -42142,
                -72178421, 42142, -9757494, 31232321, 6964853, 142052, 1423942, 419421904, 1404194};
        int result = new Task1().quickSum(arr);
        assertEquals(1835929684, result);
    }

    /*
    @Test
    public void testPartArray1() {
        int[] arr = {1,5,10,7,8,4,12,9,5,6};
        int[] result = new SimpleSumThread(arr, 0, arr.length-1).partArray();
        int[] expected = arr;
        assertArrayEquals(expected, result);
    }

    @Test
    public void testPartArray2() {
        int[] arr = {1,5,10,7,8,4,12,9,5,6};
        int[] result = new SimpleSumThread(arr, 0, 4).partArray();
        int[] expected = {1,5,10,7,8};
        assertArrayEquals(expected, result);
    }
    @Test
    public void testPartArray3() {
        int[] arr = {1,5,10,7,8,4,12,9,5,6};
        int[] result = new SimpleSumThread(arr, 5, 9).partArray();
        int[] expected = {4,12,9,5,6};
        assertArrayEquals(expected, result);
    }

    @Test
    public void testSumArray() {
        int[] arr = {1,5,10,7,8,4,12,9,5,6};
        int result = new SimpleSumThread(arr, 0, arr.length-1).sumArray();
        assertEquals(67, result);
    }
    */
}
