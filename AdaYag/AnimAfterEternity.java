import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.awt.geom.*;
public class AnimAfterEternity extends Applet implements Runnable,MouseMotionListener{
double angle,a,b;
int x,y,period;
Color c;
Thread t;
int ox,oy;
boolean flag;
Point2D p1,p2,p3,p4;
boolean rng;
public void init(){
t=new Thread(this);
rng=true;
p1=p2=p3=p4=new Point2D.Float(0,0);
x=0;y=0;
a=100;
b=20;
ox=oy=250;
flag=true;
angle=0;
period=10;
c=getColor();
addMouseMotionListener(this);
t.start();
}
public Color getColor(){
int r=(int)(Math.random()*255);
int b=(int)(Math.random()*255);
int g=(int)(Math.random()*255);
return new Color(r,g,b);
}
public void paint(Graphics g1){
Graphics2D g=(Graphics2D)g1;
g.setColor(c);
g.draw(new Line2D.Float(p1,p2));
g.draw(new Line2D.Float(p1,p4));
g.draw(new Line2D.Float(p2,p3));
g.draw(new Line2D.Float(p3,p4));
}
public void run(){
while(rng){
if(flag){
Image img=createImage((int)getWidth(),(int)getHeight());
paint(img.getGraphics());
getGraphics().drawImage(img,0,0,this);
angle=(angle+1)%360;
x=(int)(a*Math.cos(Math.toRadians(angle)));
y=(int)(b*Math.sin(Math.toRadians(angle)));
p1=new Point2D.Float(ox+x,oy+y);

x=(int)(a*Math.cos(Math.toRadians((angle+90)%360)));
y=(int)(b*Math.sin(Math.toRadians((angle+90)%360)));
p2=new Point2D.Float(ox+x,oy+y);

x=(int)(a*Math.cos(Math.toRadians((angle+180)%360)));
y=(int)(b*Math.sin(Math.toRadians((angle+180)%360)));
p3=new Point2D.Float(ox+x,oy+y);

x=(int)(a*Math.cos(Math.toRadians((angle+270)%360)));
y=(int)(b*Math.sin(Math.toRadians((angle+270)%360)));
p4=new Point2D.Float(ox+x,oy+y);
    }
try{t.sleep(period);}catch(Exception e){}
}
}
public void mouseMoved(MouseEvent e){
int px=(int)e.getX()-ox;
int py=(int)e.getY()-oy;
double val=((px*px)/(a*a))+((py*py)/(b*b));
if(val<1){flag=false;c=getColor();}
else {flag=true;}
}
public void mouseDragged(MouseEvent e){}
}