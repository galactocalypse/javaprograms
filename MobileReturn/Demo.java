import java.awt.*;
import java.applet.*;
public class Demo extends Applet{
public void paint(Graphics g){/*
g.setXORMode(Color.red);
g.fillRect(100,100,100,100);
g.setColor(Color.yellow);
g.drawRect(120,120,100,100);
g.setXORMode(null);
g.drawRect(120,120,100,100);
g.setColor(Color.black);
*/
g.drawString(""+g.getClip().toString(),200,200);
}
}