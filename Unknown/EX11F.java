import java.applet.*;
import java.awt.*;
import java.util.*;

public class EX11F extends Applet
{
    TextArea results = new TextArea(10, 75);

    public void init()
    {
        resize(500, 240);
        add(results);

        // create a new Vector to hold 10 elements
        // and to increase by 4 each time it's necessary
        Vector v1 = new Vector(10, 4);

        // add elements, both Integer and String, to the Vector
        v1.addElement(new Integer(1));
        v1.addElement(new Integer(2));
        v1.addElement(new Integer(3));
        v1.addElement("Four");
        v1.addElement(new Integer(5));

        // display the entire Vector
        results.appendText(v1.toString() + "\r\n");

        // see if the Vector contains this Integer
        if (v1.contains(new Integer(2)))
            results.appendText("It contains 2\r\n");

        // see if the Vector contains this String
        if (v1.contains("Four"))
            results.appendText("It contains Four\r\n");

        // Display the capacity of the Vector
        int capacity = v1.capacity();
        results.appendText("Can hold " +
                String.valueOf(capacity) + "\r\n");

        // Display the element at index number 3
        results.appendText("ElementAt 3 = " +
                (String)v1.elementAt(3) + "\r\n");

        // clear out the Vector
        v1.removeAllElements();

        // add the names of Pink Floyd's first five albums
        v1.addElement("Piper At The Gates of Dawn");
        v1.addElement("Saucerful of Secrets");
        v1.addElement("Ummagumma");
        v1.addElement("Meddle");
        v1.addElement("The Dark Side of the Moon");

        // use an enumeration to display each of the album titles
        for (Enumeration enum1 = v1.elements();
                enum1.hasMoreElements(); )
            results.appendText((String)enum1.nextElement()+"\r\n");
    }

}