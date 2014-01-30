import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.awt.geom.*;
public class DEatfe extends Applet implements Runnable{
Rectangle2D r;
int ptr;
int dir;
Thread t;
int a;
boolean rng;
Point2D p;
public void init(){
r=new Rectangle2D.Float((int)(Math.random()*getWidth()),(int)(Math.random()*getHeight()),5,5);
p=new Point2D.Float((int)(Math.random()*getWidth()),(int)(Math.random()*getHeight()));
ptr=0;
a=50;
rng=true;
t=new Thread(this);
t.start();
}
void process(){
while(r.getX()+a+5>=getWidth()||r.getX()+a<0||r.getY()+a+5>getHeight()||r.getY()+a<0){
a=(int)Math.pow(-1,(int)(Math.random()*3))*(int)(Math.random()*100);}

}
public void paint(Graphics g1){
Graphics2D g=(Graphics2D)g1;
g.fill(r);
}
public void run(){
while(rng){
if(ptr==a){process();ptr=0;}
if(a<0){ptr--;r=new Rectangle2D.Float((int)r.getX()-1,(int)r.getY()-1,5,5);}
else if(a>0){ptr++;r=new Rectangle2D.Float((int)r.getX()+1,(int)r.getY()+1,5,5);}
repaint();
try{t.sleep(1);}
catch(Exception e){}
}
}
public void destroy(){
rng=false;
t=null;
}
}