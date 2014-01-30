import java.awt.*;
import java.awt.geom.*;
public class PtrRes{
Point2D p;
Point2D rsp;
double initang;
double r;
public PtrRes(Point2D rsp,double r,double initang){
this.rsp=rsp;
this.r=r;
this.initang=initang;
rotate(0);
}
public void rotate(int deg){
initang=initang+deg;
p=new Point2D.Double(rsp.getX()+(r*Math.cos(Math.toRadians(initang))),rsp.getY()+(r*Math.sin(Math.toRadians(initang))));
}
}