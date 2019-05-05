package executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Task1 {

    /*
     * Create a method which computes the sum of all elements in a 2D integer array.
     * For better Performance use at least 2 Threads or Runnables in parallel. (Hint:
     * Have a look on how the join()-Method is working)
     *
     */

    public int quickSum(int[] arr) throws InterruptedException, ExecutionException {
        int sum = 0;

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        List<Callable<Integer>> callables = Arrays.asList(
                callable( partArray(arr, 0, arr.length/2) ),
                callable( partArray(arr, arr.length/2+1, arr.length-1 ) ) );

        List<Future<Integer>> futureList = executorService.invokeAll(callables);
        for (Future<Integer> result: futureList) sum = sum + result.get();

        return sum;
    }

    int[] partArray(int[] arr, int start, int end) {
        int[] newArr = new int[end-start+1];

        for (int i=0; i<newArr.length; i++) {
            newArr[i] = arr[start+i];
        }

        return newArr;
    }

    Callable<Integer> callable(int[] arr) {
        return () -> {
            int sum = 0;
            for (int i=0; i<arr.length; i++) {
                sum += arr[i];
            }
            return sum;
        };
    }

}
