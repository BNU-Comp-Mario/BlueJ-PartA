import java.util.ArrayList;
/**
 * Assign the course modules 
 *
 * @author (Jose Gomes)
 * @version (06/11/2020)
 */
public class Course
{
    // the collection of modules
    ArrayList<String> module = new ArrayList<String>(); 
    /**
     * Create the four mandatory modules
     */
    public void createModules()
    {
        Module m = new Module();
    module.add("CO452/ProgrammingConcepts : " + m.programmingMark);
    module.add("CO456/WebDevelopment : " + m.webdevelopmentMark);
    module.add("CO450/ComputerArchitectures : " + m.computerMark);
    module.add("CO454/Digitech : " + m.digitechMark);
    //quick alert
    System.out.println("The following modules were created:");
    for (int i = 0; i < module.size(); i++) {
      System.out.println(module.get(i));}
    }
}
