package hw3;
import java.util.PriorityQueue;
interface StockMarket {
    /** Добавить акцию */
    void add(Stock stock);
    /** Удалить акцию */
    void remove(Stock stock);
    /** Самая дорогая акция */
    Stock mostValuableStock();
}
class StockMarketImpl implements StockMarket {
    public static StockMarket StockMarketImplnew;
    private PriorityQueue<Stock> stockQueue;

    public StockMarketImpl() {
        stockQueue = new PriorityQueue<>((s1, s2) -> Double.compare(s2.getPrice(), s1.getPrice()));
    }

    @Override
    public void add(Stock stock) {
        stockQueue.add(stock);
    }

    @Override
    public void remove(Stock stock) {
        stockQueue.remove(stock);
    }

    @Override
    public Stock mostValuableStock() {
        return stockQueue.peek();
    }
}

class Stock {
    private String name;
    private double price;

    public Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
public class Task6 {
}
