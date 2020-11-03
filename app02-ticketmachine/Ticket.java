
/**
 * All available tickets with respective destination and cost.
 *
 * @author (Jose Gomes)
 * @version (03/11/2020)
 */
public class Ticket
{
    public static final String AYLESBURY_TICKET = ("Destination:Aylesbury Cost:220£");
    public static final String AMERSHAM_TICKET = ("Destination:Amersham Cost:300£");
    public static final String HIGHWYCOMBE_TICKET = ("Destination:HighWycombe Cost:330£");
    
     /**
     * Display all available tickets
     */
    public void printAllTickets()
    {
    System.out.println("All available tickets:");
    System.out.println("#1:" + AYLESBURY_TICKET);
    System.out.println("#2:" + AMERSHAM_TICKET);
    System.out.println("#3:" + HIGHWYCOMBE_TICKET);
    }
}
