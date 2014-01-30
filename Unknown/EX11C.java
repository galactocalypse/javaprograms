
 import java.applet.*;
import java.awt.*;
import java.util.*;

public class EX11C extends Applet
{
    TextArea results = new TextArea(10, 75);

    public void init()
    {
        add(results);

        // create a new Hashtable
        Hashtable ht = new Hashtable();

        // add Pink Floyd's best albums
        ht.put("Pulse", new Integer(1995));
        ht.put("Dark Side of the Moon", new Integer(1973));
        ht.put("Wish You Were Here", new Integer(1975));
        ht.put("Animals", new Integer(1977));
        ht.put("Ummagumma", new Integer(1969));

        // display the Hashtable
        results.appendText("Initailly: "+ht.toString() + "\r\n");

        // test for any album from 1969
        if (ht.contains(new Integer(1969)))
            results.appendText("An album from 1969 exists\r\n");

        // test for the Animals album
        if (ht.containsKey("Animals"))
            results.appendText("Animals was found\r\n");

        // find out what year Wish You Were Here was released
        Integer year = (Integer)ht.get("Wish You Were Here");
        results.appendText("Wish You Were Here was released in " +
                year.toString() + "\r\n");

        // remove an album
        results.appendText("Removing Ummagumma\r\n");
        ht.remove("Ummagumma");

        // move through an enumeration of all keys in the table
        results.appendText("Remaining:\r\n");
        for (Enumeration enum1=ht.keys(); enum1.hasMoreElements() ;)
            results.appendText((String)enum1.nextElement()+"\r\n");

        // and resize the applet window
        resize(500, 240);
    }
}