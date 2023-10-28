package hw3;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
public class Task6Test {
    private StockMarket stockMarket;

    @BeforeEach
    void setUp() {
        stockMarket = new StockMarketImpl();
    }

    @Test
    void testAdd() {
        Stock stock1 = new Stock("Stock 1", 100.0);
        Stock stock2 = new Stock("Stock 2", 200.0);

        stockMarket.add(stock1);
        stockMarket.add(stock2);

        assertEquals(stock2, stockMarket.mostValuableStock());
    }

    @Test
    void testRemove() {
        Stock stock1 = new Stock("Stock 1", 100.0);
        Stock stock2 = new Stock("Stock 2", 200.0);

        stockMarket.add(stock1);
        stockMarket.add(stock2);

        stockMarket.remove(stock1);

        assertEquals(stock2, stockMarket.mostValuableStock());
    }

    @Test
    void testMostValuableStock() {
        Stock stock1 = new Stock("Stock 1", 100.0);
        Stock stock2 = new Stock("Stock 2", 200.0);

        assertNull(stockMarket.mostValuableStock());

        stockMarket.add(stock1);
        assertEquals(stock1, stockMarket.mostValuableStock());

        stockMarket.add(stock2);
        assertEquals(stock2, stockMarket.mostValuableStock());
    }
}
