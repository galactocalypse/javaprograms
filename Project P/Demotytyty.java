import java.awt.*;
import java.applet.*;
public class Demotytyty extends Applet{
public void paint(Graphics g){
int a=5,b=2,x=0,y=10,c=5;
double m=3/5;
Point p1=null;
for(x=10;x<getWidth()-20;x++){
p1=new Point(x-1,y);
y=(int)((-c-(a*x))/b);
g.drawLine(x,y,(int)p1.getX(),(int)p1.getY());
}
}
}