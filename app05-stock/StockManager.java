import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (Jose Gomes) 
 * @version (09/11/2020)
 */
public class StockManager
{
    // A list of the products.
    public ArrayList<Product> stock;
    public int lowStock = 2; 
    private Product product;
    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        stock.add(item);
    }
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, String name, int amount)
    {   
        Product product = findProduct(id);
        if(product != null)
        {
        product.increaseQuantity(amount);
        System.out.println("Product Delivered:" + product); 
        }
        else
        {
            System.out.println("PRODUCT ID:" + id + " NOT FOUND");
        }
    }
    
    /**
     * Rename a product
     */
    public void renameProduct(String name,int id)
    {
        Product product = findProduct(id);
        
        if(product != null)
        {         
            product.setName(name);
        }
        else
        {
            System.out.println("Product not found");
        }
    }
    
    /**
     * Sell one given product.
     */
    public void sellProduct(int id, int quantity)
    {
        Product product = findProduct(id);
        if(product != null)
        {
            if(quantity > product.getQuantity())
                quantity = product.getQuantity();
        
            printDetails(id);
            for(int count = 0; count <= quantity; count++)
            {
               product.sellOne(); 
            }      
            printDetails(id);
        }
    }
    
    /**
     * Show details of a given product.
     */
    public void printDetails(int id)
    {
        Product product = findProduct(id);
        if(product != null)
        {
            System.out.println(product.toString());
        }
    }
    
    /**
     * Find a product in stock
     */
    public Product findProduct(int id)
    {
        for(Product product : stock)
        {
            if(product.getID() == id)
            {
             System.out.println("Product: " + product);
             return product;    
            }
        }
        return null;
    }

    /**
     * Print details of the given product. If found,
     * its name and stock quantity will be shown.
     * @param id The ID of the product to look for.
     */
    public void printProduct(int id)
    {
        Product product = findProduct(id);
        
        if(product != null) 
        {
            System.out.println(product.toString());
        }
    }
    
    /**
     * Print out each product in the stock
     * in the order they are in the stock list
     */
    public void printStock()
    {
        printHeading();
        
        for(Product product : stock)
        {
            System.out.println(product);
        }

        System.out.println();
    }
    
    /**
     * Design feature 
     */
    public void printHeading()
    {
        System.out.println();
        System.out.println("Gomes Stock List");
        System.out.println("================");
        System.out.println();
    }
    
    /**
     * Search products by name
     */
    public void printCertainProducts(String nameI)
    {
        for(Product product : stock)
        {
         if(nameI.startsWith(product.getName()))
         {
             System.out.println(product);
            }
        }
        
    }
    
    /**
     *  Display products with less than two units available
     */
    public void printLowStock()
    {   
        System.out.println("Low Stock Products:");
        for(Product product : stock)
        {
            if(product.quantity <= lowStock)
            System.out.println(product);
        }
    }
    
    /**
     * Restock products with less than three units available
     */
    public void reStock(int id, int quantity)
    {
        Product product = findProduct(id);
        if(product != null && product.quantity < 3)
        {
            product.increaseQuantity(quantity);
            System.out.println("Product Delivered:" + product); 
            printStock();
        }
        else if(product != null && product.quantity > 3)
        {
            System.out.println(product +" has plenty of stock");
        }
        else
        {
            System.out.println("PRODUCT ID:" + id + " NOT FOUND");
        }    
    }
    
    /**
    * Remove one product by id 
    */
        public void removeProduct(int id)
        {
        Product product = findProduct(id);
        if(product != null)
        {
            stock.remove(id-101);  //find another solution
            System.out.println(product + " was removed"); 
            printStock();
        }
        else
        {
            System.out.println("PRODUCT ID:" + id + " NOT FOUND");
        } 
        }
}
