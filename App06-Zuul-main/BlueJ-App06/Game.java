
/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * 
 * @modified Jose Gomes
 * @version 24/01/2021
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    Items i = new Items();
    Player p = new Player();

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, theater, pub, lab, office, gym, nursery, reception; 

        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        //new rooms
        gym = new Room("in the gym");
        nursery = new Room("in the nursury");
        reception = new Room("in the reception"); //

        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);
        theater.setExit("north", gym);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);
        office.setExit("south", reception);

        reception.setExit("north", office);

        gym.setExit("south", theater);
        gym.setExit("east", nursery);

        nursery.setExit("west", gym);

        currentRoom = outside;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;

        while (! finished) 
        {
            Command command = parser.getCommand();
            finished = processCommand(command);

            if(p.energy == 0)
                finished = true;
            else if(currentRoom.getShortDescription() == "outside the main entrance of the university" && i.item1 == true && i.item2 == true)
                finished = true;
        }

        //game ending decision (victory, defeat, quit)
        if(p.energy == 0)
        {    
            System.out.println("You look exhausted, can't keep going like that! You lost...");
        }
        else if(currentRoom.getShortDescription() == "outside the main entrance of the university" && i.item1 == true && i.item2 == true)
        {  
            System.out.println("Congratulations you won!");
        }
        else
        {
            System.out.println("Thank you for playing.  Good bye.");
        }
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) 
        {
            case UNKNOWN:
            System.out.println("I don't know what you mean...");
            break;

            case HELP:
            printHelp();
            break;

            case GO:
            goRoom(command);
            break;

            //my commands except QUIT
            case PICK:
            pickItem();
            break;
            //drink the energetic drink
            case DRINK:
            drink();
            break;
            //show inventory
            case SHOW:
            showInventory();
            break;
            //show objective
            case GOAL:
            remindGoal();
            break;

            case QUIT:
            wantToQuit = quit(command);
            break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) 
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            //remove energy from the player everytime he switches rooms
            p.energy -= 10;
            System.out.println("Energy: " + p.energy);

            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    /** 
     * Try to pick up an item in a room, if theres none print an error message.
     */
    private void pickItem()
    {     
        if(currentRoom.getShortDescription() == "in the campus pub" && i.picked3 == false)
        {    
            i.item3 = true;
            i.picked3 = true;
            System.out.println("You picked an energetic drink");
        }
        else if(currentRoom.getShortDescription() == "in the reception" && i.picked2 == false)
        {
            i.item2 = true;
            i.picked2 = true;
            System.out.println("You picked a flashlight");
        }
        else if(currentRoom.getShortDescription() == "in the nursury" && i.picked1 == false)
        {
            i.item1 = true;
            i.picked1 = true;
            System.out.println("You picked a knife");
        }
        else
            System.out.println("There is no items in the room!");
    }

    /** 
     * Display player's inventory.
     */
    private void showInventory()
    {
        System.out.println("--------Inventory--------");
        if(i.item1 == true && i.item2 == false && i.item3 == false)
        {
            System.out.println("(X) Knife");
        }
        else if(i.item2 == true && i.item1 == false && i.item3 == false)
        {
            System.out.println("(X) Flashlight");
        }
        else if(i.item3 == true && i.item2 == false && i.item1 == false)
        {
            System.out.println("(X) Energetic Drink");
        }
        else if(i.item1 && i.item2 == true && i.item3 == false)
        {
            System.out.println("(X) Knife");
            System.out.println("(X) Flashlight");
        }
        else if(i.item2 && i.item3 == true && i.item1 == false)
        {
            System.out.println("(X) Flashlight");
            System.out.println("(X) Energetic Drink");
        }
        else if(i.item1 && i.item3 == true && i.item2 == false)
        {
            System.out.println("(X) Knife");
            System.out.println("(X) Energetic Drink");
        }
        else if(i.item1 == true && i.item2 == true && i.item3 == true)
        {
            System.out.println("(X) Knife");
            System.out.println("(X) Flashlight");
            System.out.println("(X) Energetic Drink");
            System.out.println("You have every item. Run outside!");
        }
        else
        {
            System.out.println("You dont have any items");
        }
        System.out.println("-------------------------");
    }

    /** 
     * Remind the player of his objective.
     */
    private void remindGoal()
    {
        System.out.println("Pick up all three items and get back outside!");
    }

    /** 
     * Boost the players energy by 50.
     */
    private void drink()
    {      
        if(i.item3 == true && i.used == false)
        {
            p.energy += 50;
            i.item3 = false;
            i.used = true;
            System.out.println("Energy: " + p.energy);
        }
        else if(i.used == true && i.item3 == false)                           
        {
            System.out.println("You already drank one energetic drink!");    
        }
        else if(i.item3 == false && i.used == false)
        {
            System.out.println("You do not have any drinks!");
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
