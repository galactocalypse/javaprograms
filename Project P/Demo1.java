import java.awt.*;
import java.applet.*;
public class Demo1 extends Applet implements Runnable{
Thread t;
boolean rng;
int ox,oy,r;
int deg;
public void init(){
t=new Thread(this);
rng=true;
deg=0;
ox=oy=250;
r=100;
t.start();
}
public void paint(Graphics g){
if(deg<180)g.setColor(Color.green);
else g.setColor(Color.red);
int x1=ox+(int)(Math.cos(Math.toRadians(deg))*r);
int y1=oy+(int)(Math.sin(Math.toRadians(deg))*r);
int x2=ox-(int)(Math.cos(Math.toRadians(deg))*r);
int y2=oy-(int)(Math.sin(Math.toRadians(deg))*r);
g.drawLine(x1,y1,x2,y2);
}
public void run(){
while(rng){
deg=(deg+1)%360;
paint(getGraphics());
try{
t.sleep(10);
}
catch(InterruptedException e){}
}
}
public void destroy(){
t=null;
rng=false;
}
}