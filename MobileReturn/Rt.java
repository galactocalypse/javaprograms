import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.awt.geom.*;
public class Rt extends Applet implements KeyListener{
Point2D p1,pa,pb;
int a,b;
public void init(){
p1=new Point2D.Double(250,250);
pa=new Point2D.Double(150,150);
pb=new Point2D.Double(350,350);
a=b=100;
addKeyListener(this);
}
public void paint(Graphics g1){
Graphics2D g=(Graphics2D)g1;
g.draw(new Line2D.Double(pa,p1));
g.draw(new Line2D.Double(pb,p1));
}
Point2D rotate(Point2D p,double x,double y,double deg){
double x1=p.getX();
double y1=p.getY();
double r=Math.sqrt(Math.pow(x1-x,2)+Math.pow(y1-y,2));
return new Point2D.Double(x+(r*Math.cos(Math.toRadians(deg))),y+(r*Math.sin(Math.toRadians(deg))));
}
public void keyPressed(KeyEvent e){}
public void keyReleased(KeyEvent e){}
public void keyTyped(KeyEvent e){
switch((""+e.getKeyChar()).toLowerCase().charAt(0)){
case 'a':
pb=rotate(p1,pb.getX(),pb.getY(),-1);
//pa=rotate(p1,pa.getX(),pa.getY(),2);
pa=new Point2D.Double((p1.getX()*2)-pb.getX(),(p1.getY()*2)-pb.getY());
break;
case 'd':
pb=rotate(p1,pb.getX(),pb.getY(),1);
pa=new Point2D.Double((p1.getX()*2)-pb.getX(),(p1.getY()*2)-pb.getY());
break;
}
repaint();
}
}