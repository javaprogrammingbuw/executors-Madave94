package executors;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;
import java.util.concurrent.*;

public class Task2 {

    public static void main (String[] args) {
        OperatingSystemMXBean bean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        final int TOTALTIME = 10;
        int i = 0;

        Callable<Integer> callable = () -> {
            int WAITING_TIME = 2;
            System.out.println(bean.getProcessCpuLoad());
            System.out.println(bean.getSystemCpuLoad());
            System.out.println("Waiting... ");
            TimeUnit.SECONDS.sleep(WAITING_TIME);
            return WAITING_TIME;
        };

        while (i < TOTALTIME) {
            Future<Integer> number =executorService.submit(callable);
            try {
                i = i + number.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
        System.out.println("Executor was shutdown.");

    }


}
