import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class Demo2 extends Applet implements MouseListener{
int ox,oy,x,y;
public void init(){
ox=oy=250;
addMouseListener(this);
}
public void paint(Graphics g){
g.drawLine(ox,oy,x,y);
}
public void mousePressed(MouseEvent e){

}
public void mouseReleased(MouseEvent e){x=e.getX();
y=e.getY();
repaint();}
public void mouseClicked(MouseEvent e){}
public void mouseEntered(MouseEvent e){}
public void mouseExited(MouseEvent e){}
}