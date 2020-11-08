import java.util.*;
import java.util.ArrayList;
/**
 * The Student class represents a student in a student administration system.
 * It holds the student details relevant in our context.
 * 
 * @author Michael Kölling and David Barnes
 * @version 2016.02.29
 * 
 * @modified Jose Gomes
 * @version 06/11/2020
 */
public class Student
{
    // the student's full name
    private String name;
    // the student ID
    private String id;
    // the amount of credits for study taken so far
    private int credits;   
    public int programmingMark1;
    public int webdevelopmentMark1;
    public int computerMark1;
    public int digitechMark1;
    public int finalMark;
    public String finalGrade;    
    /**
     * Create a new student with a given name and ID number.
     */
    public Student(String fullName, String studentID)
    {
        name = fullName;
        id = studentID;
        credits = 0;
    }
      
    /**
     * Enroll a student on a course
     */
    public void enrollStudent()
    {
        Course c = new Course();
        System.out.println(name + " " + id);
        c.createModules();
    }
    
    /**
     * Award a mark to a module
     */
    public void programmingMark(int mark)
    {
        programmingMark1 = mark;
    }
    
    /**
     * Award a mark to a module
     */
    public void webdevelopmentMark(int mark)
    {
        webdevelopmentMark1 = mark;
    }
    
    /**
     * Award a mark to a module
     */
    public void computerMark(int mark)
    {
         computerMark1 = mark;
    }
    
    /**
     * Award a mark to a module
     */
    public void digitechMark(int mark)
    {
        digitechMark1 = mark;
    }
    
    /**
     * Calculate final grade 
     */
    public void finalGrade()
    {
     finalMark = ((programmingMark1 + webdevelopmentMark1 + computerMark1 + digitechMark1)/4);
     
     if(finalMark <= 39)
     {
         System.out.println("Final Grade: F");
        }
        else if(finalMark >= 40 && finalMark <= 49)
        {
        System.out.println("Final Grade: D");
    }
        else if(finalMark >= 50 && finalMark <= 59)
        {
        System.out.println("Final Grade: C");
        }
        else if(finalMark >= 60 && finalMark <= 69)
        {
        System.out.println("Final Grade: B");
        }
        else if(finalMark >= 70 && finalMark <= 100)
        {
        System.out.println("Final Grade: A");
        }
    }
       
    /**
     * Return the full name of this student.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set a new name for this student.
     */
    public void changeName(String replacementName)
    {
        name = replacementName;
    }

    /**
     * Return the student ID of this student.
     */
    public String getStudentID()
    {
        return id;
    }

    /**
     * Add some credit points to the student's accumulated credits.
     */
    public void addCredits(int additionalPoints)
    {
        credits += additionalPoints;
    }
    
    /**
     * Return the number of credit points this student has accumulated.
     */
    public int getCredits()
    {
        return credits;
    }

    /**
     * Return the login name of this student. The login name is a combination
     * of the first four characters of the student's name and the first three
     * characters of the student's ID number.
     */
    public String getLoginName()
    {
        return name.substring(0,4) + id.substring(0,3);
    }
    
    /**
     * Print the student's name and ID number to the output terminal.
     */
    public void print()
    {
        System.out.println(name + ", Student ID: " + id + ", Credits: " + credits + ", Final Grade: " + finalMark);
    }
}
