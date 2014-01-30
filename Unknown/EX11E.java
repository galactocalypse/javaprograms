import java.applet.*;
import java.awt.*;
import java.util.*;
public class EX11E extends Applet implements Observer
{
    Integer secretNumber;
    Obsable obs;
    TextField tf;

    public EX11E() 
    {
        // create a new instance of the observable class
        obs = new Obsable(12);
        // indicate that "this" is an observer
        obs.addObserver(this);

        // create a read-only TextField
        tf = new TextField(10);
        tf.setEditable(false);
    }

    public void init() {
        add(new Label("Secret Number:"));
        add(tf);
        add(new Button("Change"));
        resize(320, 240);
    }

    // this method is invoked when the observable object
    // notifies its observers
    public void update(Observable o, Object arg) {
        // store the secret number and display it
        secretNumber = (Integer)arg;
        tf.setText(String.valueOf(secretNumber));
    }

    public boolean action(Event evt, Object obj)
    {
        boolean result=false;

        if("Change".equals(obj)) {
            obs.GenerateNumber();
            result = true;
        }
        return result;
    }
}