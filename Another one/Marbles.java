import java.awt.*;
import java.awt.geom.*;
import java.applet.*;
import java.awt.event.*;
public class Marbles extends Applet implements MouseListener,MouseMotionListener{
Ellipse2D ball;
double x1,y1;
double dist;
double x,y;
boolean sel;
double angle;
public void init(){
x1=(Math.random()*getWidth())-30;
y1=(Math.random()*getHeight())-30;
ball=new Ellipse2D.Float((int)x1,(int)y1,30,30);
dist=0;
sel=false;
}
public void paint(Graphics g1){
Graphics2D g=(Graphics2D)g1;
g.fill(ball);
}
public void mousePressed(MouseEvent e){
if(ball.contains(new Point2D.Float(e.getX(),getY())))sel=true;
else sel=false;}
public void mouseClicked(MouseEvent e){}
public void mouseReleased(MouseEvent e){
x=e.getX();
y=e.getY();
double xd=(ball.getX()+15)-x,yd=ball.getY()-y;
angle=Math.atan(yd/xd)*180/Math.PI;

}
public void mouseEntered(MouseEvent e){}
public void mouseExited(MouseEvent e){}
public void mouseMoved(MouseEvent e){}
public void mouseDragged(MouseEvent e){}
}