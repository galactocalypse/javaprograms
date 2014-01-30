import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class Demo3 extends Applet implements MouseMotionListener{
int ox,oy,x,y;
public void init(){
ox=oy=250;
addMouseMotionListener(this);
}
public void paint(Graphics g){
g.drawLine(ox,oy,x,y);
}
public void mouseMoved(MouseEvent e){x=e.getX();
y=e.getY();
repaint();}
public void mouseDragged(MouseEvent e){}
}