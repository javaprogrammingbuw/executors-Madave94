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

        Callable<Integer> c = new SimpleSumCallable( arr );
        Future<Integer> result1 = executorService.submit( c );

        try {
            sum = result1.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return sum;
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
