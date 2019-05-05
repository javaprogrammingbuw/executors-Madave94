package executors;

import java.util.concurrent.*;

public class Task1 {

    /*
     * Create a method which computes the sum of all elements in a 2D integer array.
     * For better Performance use at least 2 Threads or Runnables in parallel. (Hint:
     * Have a look on how the join()-Method is working)
     *
     */

    private int sum;

    public int quickSum(int[] arr) {
        this.sum = 0;

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Callable<Integer> c1 = new SimpleSumCallable( partArray(arr, 0, arr.length/2) );
        Callable<Integer> c2 = new SimpleSumCallable( partArray(arr, arr.length/2+1, arr.length-1 ) );
        Future<Integer> result1 = executorService.submit( c1 );
        Future<Integer> result2 = executorService.submit( c2 );

        try {
            sum = result1.get() + result2.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return sum;
    }

    int[] partArray(int[] arr, int start, int end) {
        int[] newArr = new int[end-start+1];

        for (int i=0; i<newArr.length; i++) {
            newArr[i] = arr[start+i];
        }

        return newArr;
    }

    class SimpleSumCallable implements Callable {

        int[] arr;

        SimpleSumCallable(int[] arr) {
            this.arr = arr;
        }

        @Override
        public Object call() throws Exception {
            int sum = 0;
            for (int i=0; i<arr.length; i++) {
                sum += arr[i];
            }
            return sum;
        }
    }
}
