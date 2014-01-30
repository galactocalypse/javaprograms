import java.applet.*;
import java.awt.*;
import java.util.*;

public class EX11A extends Applet
{
    TextArea results = new TextArea(10, 20);

    public void init()
    {

        add(new Button("Start"));
        add(results);

        resize(320, 240);
    }

    public boolean action(Event evt, Object obj)
    {
        boolean result=false;

        if("Start".equals(obj)) {
            BitSetTest();
            result = true;
        }
        return result;
    }

    void BitSetTest()
    {
        // create a BitSet and set items 1 and 4
        BitSet bits1 = new BitSet(10);
        bits1.set(1);
        bits1.set(4);

        // create a BitSet and set items 4 and 5
        BitSet bits2 = new BitSet(10);
        bits2.set(4);
        bits2.set(5);

        // display the contents of these two BitSets
        results.appendText("Bits 1=" + bits1.toString() + "\r\n");
        results.appendText("Bits 2=" + bits2.toString() + "\r\n");

        // test for equality of the two BitSets
        if(bits1.equals(bits2))
            results.appendText("bits1 == bits2\r\n");
        else
            results.appendText("bits1 != bits2\r\n");

        // create a clone and then test for equality
        BitSet clonedBits = (BitSet)bits1.clone();
        if(bits1.equals(clonedBits))
            results.appendText("bits1 == clonedBits\r\n");
        else
            results.appendText("bits1 != clonedBits\r\n");

        // logically AND the first two BitSets 
        bits1.or(bits2);
        results.appendText("ORing bits1 and bits2\r\n");
        // and display the resulting BitSet
        results.appendText("bits1=" + bits1.toString() + "\r\n");
    }
}
