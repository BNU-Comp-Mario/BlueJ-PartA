
/**
 * This class creates an instance of the Game
 * class and then calls on its run method.
 *
 * @author Jose Gomes
 * @version 24/01/2021
 */
public class Program
{
    private static Game game;

    /**
     * This class creates and runs an instance of
     * the Game class
     */
    public static void main()
    {
        game = new Game();
        game.play();
    }
}
