import java.awt.*;
import java.applet.*;
import java.awt.geom.*;
public class Demo extends Applet{
Ellipse2D drop;
Line2D ray;
Point2D obs,sun;

public void init(){
drop=new Ellipse2D.Double(350,100,50,50);
sun=new Point2D.Double(10,10);
obs=new Point2D.Double(250,300);
ray=new Line2D.Double(obs,sun);
}
public void paint(Graphics g1){
Graphics2D g=(Graphics2D)g1;
g.draw(drop);
g.draw(ray);
g.setColor(Color.red);
Point2D d=getPt(ray,obs,-100);
g.drawRect((int)d.getX(),(int)d.getY(),2,2);
}
double getInc(Line2D l){
return getInc(l.getX1(),l.getY1(),l.getX2(),l.getY2());
}
double getInc(double x,double y,double x1,double y1){
return Math.atan((y-y1)/(x-x1));
}
Point2D getPt(Line2D l,Point2D p1,double dist){
double deg=getInc(l);
double x=p1.getX()+(dist*Math.cos(deg)),y=p1.getY()+(dist*Math.sin(deg));
return new Point2D.Double(x,y);
}
double dist(Point2D p1,Point2D p2){
return Math.sqrt(Math.pow(p1.getX()-p2.getX(),2)+Math.pow(p1.getY()-p2.getY(),2));
}
}