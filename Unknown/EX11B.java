
 import java.applet.*;
import java.awt.*;
import java.util.*;

public class EX11B extends Applet
{
    TextArea results = new TextArea(10, 50);

    public void init()
    {
        add(results);

        Date today = new Date(); // today

        // display the current date in a couple of different formats
        results.appendText("Today is:" + today.toString() + "\r\n");
        results.appendText("Locale Time:" + today.toLocaleString() + "\r\n");
        results.appendText("GMT:" + today.toGMTString() + "\r\n");

        // store Bastille Day (July 14th) in an instance
        Date BastilleDay = new Date(96, 6, 14);    // 7-14-96

        // set Bastille Day to be in the current year
        BastilleDay.setYear(today.getYear());

        // see if we've already missed Bastille Day
        if (today.after(BastilleDay))
            results.appendText("You missed Bastille Day!\r\n");
        else
            results.appendText("Bastille Day is coming!\r\n");

        resize(320, 240);
    }
}