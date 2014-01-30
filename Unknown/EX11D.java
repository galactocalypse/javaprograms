import java.awt.*;
import java.io.*;
import java.util.*;

public class EX11D
{

    public static void main(String[] args)
    {
        // create a new instance
        Properties props1 = new Properties();

        // put three properties into it
        props1.put("prop1", "put one");
        props1.put("prop2", "put two");
        props1.put("prop3", "put three");

        // retrieve each of the three properties
        String prop1 = props1.getProperty("prop1", "one");
        String prop2 = props1.getProperty("prop2", "two");
        String prop3 = props1.getProperty("prop3");

        // save the properties to a file
        try 
        {
            props1.save(new FileOutputStream("test.ini"), "My header");
        }
        catch (IOException e) {
            return;
        }

        // create a new instance and read the file in from the file
        Properties props2 = new Properties();
        try
        {
            FileInputStream inStr = new FileInputStream("test.ini");
            props2.load(inStr);
        }
        catch (IOException e) {
            return;
        }

        // retrieve a property from the second instance
        String prop = props2.getProperty("prop2", "two");
    }
}