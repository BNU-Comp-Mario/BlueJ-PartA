import java.util.Arrays;
import java.util.List;
import java.lang.Math;

/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Jose Gomes
 * @version 30/11/2020
 */
public class StockApp
{
    // Use to get user input
    private InputReader input;
    private StockManager manager;
    private StockDemo demo;
    private Product product;
    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        input = new InputReader();
        this.manager = new StockManager();  
        this.demo= new StockDemo(manager);
    }

    /**
     * 
     */
    public void run()
    {
        printHeading();
        getMenuChoice();
    }
    
    /**
     * 
     */
    public void getMenuChoice()
    {
        boolean finished = false;
        
        while(!finished)  
        {
            printMenuChoices();
           
            String choice = input.getInput();
            
            if(choice == "Quit")
            {
            finished = true;
            }
            
            executeMenuChoice(choice);
        }
    }
    
    public void executeMenuChoice(String choice) 
    {
        if(choice.equals("PrintAll")) //choice
        {
            manager.printStock();         
        }
        else if(choice.equals("Add"))
        {
            System.out.println("Please input new name");
            String name = input.getInput();
            
            System.out.println("Please input the ID");
            int id = Integer.parseInt(input.getInput());
            
            int quantity = 0;   
            
            Product product = manager.findProduct(id);

            if(name.isEmpty())
            {
                System.out.println("Error: you need to enter a name");
            }
            else if(product != null)
            {
                System.out.println("Error: this product ID already exists");
            }
            else
            {
            manager.addProduct(new Product(id,name,quantity));
            System.out.println("Product added: " + id + " " + name + " " + quantity);
            }
        }
        else if(choice.equals("Deliver"))
        {
            System.out.println("Please input the product id");
            int id = Integer.parseInt(input.getInput());
            
            System.out.println("How many units to deliver");
            int quantity = Integer.parseInt(input.getInput());
            
            String name = "item";             
            if (id >= 0)
            {
                manager.delivery(id,name,quantity);
            }
            else
            {
                System.out.println("ERROR: you entered a negative value");
            }
        }
        else if(choice.equals("Remove"))
        {
            System.out.println("Please input the product id");
            int id = Integer.parseInt(input.getInput());
            
            manager.removeProduct(id);
        }
        else if(choice.equals("Sell"))
        {
            System.out.println("Please input the product id");
            int id = Integer.parseInt(input.getInput());
            
            System.out.println("How many units to sell");
            int quantity = Integer.parseInt(input.getInput());
            
            manager.sellProduct(id,quantity);
        }
        else if(choice.equals("Search"))
        {
            System.out.println("Please input the id from the item you want to search");
            int id = Integer.parseInt(input.getInput());
            
            manager.findProduct(id);
        }
        else if(choice.equals("LowStock"))
        {
            manager.printLowStock();
        }
        else if(choice.equals("ReStock"))
        {
            System.out.println("Please input the id of the item you want to restock");
            int id = Integer.parseInt(input.getInput());
            
            System.out.println("Please input the quantity of the item you want to restock");
            int quantity = Integer.parseInt(input.getInput());
            
            manager.reStock(id,quantity);
        }
        else if(choice.equals("Quit"))
        {
            System.exit(0);
        }
        else
        {
            System.out.println("Invalid Input");
        }
    }
    
   
    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    PrintAll:   Print all products");
        System.out.println("    Add:        Add a new product");
        System.out.println("    Deliver:    Deliver a quantity of product");
        System.out.println("    Remove:     Remove an old product");
        System.out.println("    Sell:       Sell a quantity of product");
        System.out.println("    Search:     Search and print a list of products based on part of the product name");
        System.out.println("    LowStock:   Print a list of products whose stock levels are low");
        System.out.println("    ReStock:    Re-Stock all the low stock items up to a set minimum level");
        System.out.println("    Quit:       Quit the program");
        System.out.println();        
    }
    
    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println("******************************");
        System.out.println(" Stock Management Application ");
        System.out.println("    App05: by Jose Gomes");
        System.out.println("******************************");
    }
}
