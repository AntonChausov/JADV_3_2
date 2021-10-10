import java.util.Random;
import java.util.concurrent.Callable;

public class Shop implements Callable {

    final int MAX_SALE_COUNT = 10;
    final int MAX_SALE_SUM = 10000;
    final int MIN_SALE_SUM = 100;
    private String shopName;

    public Shop(String shopName) {
        this.shopName = shopName;
    }

    @Override
    public int[] call() throws Exception {
        Random rnd = new Random();
        int saleCount = rnd.nextInt(MAX_SALE_COUNT);
        int[] sales = new int[saleCount];
        for (int i = 0; i < saleCount; i++) {
            sales[i] = rnd.nextInt(MAX_SALE_SUM - MIN_SALE_SUM) + MIN_SALE_SUM;
            System.out.println("Продажа в магазине \"" + shopName + "\" на сумму " + sales[i]);
        }
        return sales;
    }
}
