import java.awt.*;
import java.awt.geom.*;
import java.applet.*;
import java.awt.event.*;
public class VirtualTarot extends Applet implements KeyListener{
Rectangle2D pet;
public void init(){
pet=new Rectangle2D.Float(100,50,150,30);

}
public void paint(Graphics g){
g.drawString("adarsh"+KeyEvent.KeyPress(8),100,100);
}
public void keyPressed(KeyEvent e){}
public void keyReleased(KeyEvent e){}
public void keyTyped(KeyEvent e){
}
}