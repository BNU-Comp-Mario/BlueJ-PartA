
/**
 * Class Items - items in an adventure game.
 * 
 * These are the items that are hidden in some rooms.
 *
 * @author Jose Gomes
 * @version 24/01/2021
 */
public class Items
{
    // instance variables 
    boolean item1 = false; //knife
    boolean item2 = false; //flashlight
    boolean item3 = false; //energetic drink
    
    boolean used = false; 
    
    boolean picked1 = false; //knife
    boolean picked2 = false; //flashlight
    boolean picked3 = false; //energetic drink

    /**
     * Construct all variables
     */
    public Items()
    {
        // initialise instance variables
        this.item1 = item1; 
        this.item2 = item2;
        this.item3 = item3;
        
        this.used = used;
        
        this.picked1 = picked1;
        this.picked2 = picked2;
        this.picked3 = picked3;
    }
}
