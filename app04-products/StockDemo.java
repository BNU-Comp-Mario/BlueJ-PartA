import java.util.Random;
/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 * 
 * @modified (Jose Gomes)
 * @version (09/11/2020)
 */
public class StockDemo
{
    // The stock manager.
    private StockManager manager;
    // Generates random stock figures
    private Random randomGenerator;
    
    /**
     * Create a StockManager and populate it with at least
     * 10 sample products.
     */
    public StockDemo(StockManager manager)
    {
        this.manager = manager;
        randomGenerator = new Random();
        manager.addProduct(new Product(101, "Samsung Galaxy S20"));
        manager.addProduct(new Product(102, "Apple iPhone 12"));
        manager.addProduct(new Product(103, "Google Pixel 4A"));
        manager.addProduct(new Product(104, "Huawei Mate 40 Pro"));
        manager.addProduct(new Product(105, "Xiaomi Mi10"));
        manager.addProduct(new Product(106, "iPhone XS"));
        manager.addProduct(new Product(107, "Samgung Galaxy Note20"));
        manager.addProduct(new Product(108, "iPhone 11"));
        manager.addProduct(new Product(109, "Huawei P40 Lite"));
        manager.addProduct(new Product(110, "Nokia 3310"));
    }
    
    /**
     * Provide a demonstration of how the StockManager meets all
     * the user requirements by making a delivery of each product 
     * re-stocking it by various amounts and then selling each
     * product by various amounts. Make sure all the requirements
     * have been demonstrated.
     */
    public void runDemo()
    {
        // Show details of all of the products before delivery.
        
        manager.printStock();

        demoDeliverProducts();
        manager.printStock();        

        demoSellProducts();
        manager.printStock();
    }
    
    /**
     * Provide a very simples demonstration of how a StockManager
     * might be used. Details of one product are shown, the
     * product is restocked, and then the details are shown again.
     */
    private void demoDeliverProducts()
    {
        int quantity = 0;
        
        for(int id = 101; id < 110; id++)
        {
         quantity = randomGenerator.nextInt(8);
         manager.delivery(id, quantity);
        }
    }

    private void demoSellProducts()
    {
        int quantity = 0;
        for(int id = 101; id <= 110; id++)
        {
            quantity = randomGenerator.nextInt(4);
            manager.sellProduct(id, quantity);
        }
    }    
}
