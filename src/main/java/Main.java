import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;

public class Main {

    final static int shopCount = 9;

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask <int[]>[] myShopsResult = new FutureTask[shopCount];

        for (int i = 0; i < shopCount; i++) {
            createShop(myShopsResult, i);
        }

        LongAdder report = new LongAdder();
        for (int i = 0; i < shopCount; i++) {
            getShopsResults(myShopsResult[i], report);
        }
        System.out.println("Результат: " + report.sum());
    }

    private static void getShopsResults(FutureTask<int[]> futureTask, LongAdder report) throws InterruptedException, ExecutionException {
        int[] shopResult = futureTask.get();
        for (int j = 0; j < shopResult.length; j++) {
            report.add(shopResult[j]);
        }
    }

    private static void createShop(FutureTask<int[]>[] myShopsResult, int i) {
        final Shop shop1 = new Shop(Integer.toString(i + 1));
        myShopsResult[i] = new FutureTask<>(shop1);
        new Thread(myShopsResult[i]).start();
    }
}
