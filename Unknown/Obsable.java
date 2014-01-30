import java.applet.*;
import java.awt.*;
import java.util.*;

// define a class that stores a secret number
class Obsable extends Observable {
    private int secretNumber;
    private Random generator;

    public Obsable(int seed) {
        // create a random number generator that will
        // make the "secret numbers"
        generator = new Random(seed);
    }

    public void GenerateNumber() {
        // generate a new secret number
        secretNumber = generator.nextInt();
        // indicate to Observable that the instance has changed
        setChanged();
        // notify all of the observers and pass the new number
        notifyObservers(new Integer(secretNumber));
    }
}

