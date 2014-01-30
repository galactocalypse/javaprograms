import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class Demoe extends Applet implements KeyListener{
public void init(){
addKeyListener(this);
}
public void keyPressed(KeyEvent e){}
public void keyReleased(KeyEvent e){}
public void keyTyped(KeyEvent e){
Graphics g=getGraphics();
g.clearRect(0,0,(int)getWidth(),(int)getHeight());
g.drawString(""+e.getKeyChar(),100,100);
g.drawString(""+e.getKeyCode(),100,120);
g.drawString(""+e.isActionKey(),100,140);
g.drawString(""+e.getKeyLocation(),100,160);
g.drawString(""+e.paramString(),100,180);
}
}
