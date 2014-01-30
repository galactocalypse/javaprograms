import java.awt.*;
import java.applet.*;
import java.awt.geom.*;
import java.awt.event.*;
public class Class1 extends Applet implements Runnable{
int x,y,a,b,p,n;
Point2D pts[];
Thread t;
boolean rng;
public void init(){
x=0;
n=4;
y=0;
a=20;
b=100;
p=0;
pts=new Point2D[8];
rng=true;
t=new Thread(this);
t.start();
}
public void paint(Graphics g1){
Graphics2D g=(Graphics2D)g1;
p=(p+1)%360;
for(int i=0;i<pts.length;i++){
x=(int)(b*Math.cos(Math.toRadians(p+(360*(i%n)/n))));
y=(int)(a*Math.sin(Math.toRadians(p+(360*(i%n)/n))));
if(i<4)
pts[i]=new Point2D.Float(200+x,50+y);
else
pts[i]=new Point2D.Float(200+x,(int)(100*Math.pow(2,0.5))+50+y);
}
g.drawLine((int)pts[0].getX(),(int)pts[0].getY(),(int)pts[1].getX(),(int)pts[1].getY());
g.drawLine((int)pts[0].getX(),(int)pts[0].getY(),(int)pts[3].getX(),(int)pts[3].getY());
g.drawLine((int)pts[0].getX(),(int)pts[0].getY(),(int)pts[4].getX(),(int)pts[4].getY());
g.drawLine((int)pts[4].getX(),(int)pts[4].getY(),(int)pts[5].getX(),(int)pts[5].getY());
g.drawLine((int)pts[4].getX(),(int)pts[4].getY(),(int)pts[7].getX(),(int)pts[7].getY());
g.drawLine((int)pts[2].getX(),(int)pts[2].getY(),(int)pts[1].getX(),(int)pts[1].getY());
g.drawLine((int)pts[2].getX(),(int)pts[2].getY(),(int)pts[3].getX(),(int)pts[3].getY());
g.drawLine((int)pts[2].getX(),(int)pts[2].getY(),(int)pts[6].getX(),(int)pts[6].getY());
g.drawLine((int)pts[6].getX(),(int)pts[6].getY(),(int)pts[5].getX(),(int)pts[5].getY());
g.drawLine((int)pts[6].getX(),(int)pts[6].getY(),(int)pts[7].getX(),(int)pts[7].getY());
g.drawLine((int)pts[1].getX(),(int)pts[1].getY(),(int)pts[5].getX(),(int)pts[5].getY());
g.drawLine((int)pts[3].getX(),(int)pts[3].getY(),(int)pts[7].getX(),(int)pts[7].getY());
}
public void run(){
while(rng){
Image img=createImage(getWidth(),getHeight());
paint(img.getGraphics());
getGraphics().drawImage(img,0,0,this);
try{
t.sleep(10);
}
catch(Exception e){}
}
}
public void destroy(){
rng=false;
t=null;
}
}