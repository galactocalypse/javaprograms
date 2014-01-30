import java.awt.*;
import java.awt.geom.*;
import java.applet.*;
public class Demotte extends Applet implements Runnable{
int deg,dist,dev1,dev2;
Thread t;
boolean rng;
Point2D p1;
int colind;
Color cols[];
boolean chgcol;
public  void init(){
p1=new Point2D.Float(100,100);
rng=true;
deg=dist=0;
colind=0;
cols=new Color[10];
for(int i=0;i<10;i++){
cols[i]=new Color((int)(Math.random()*255),(int)(Math.random()*25),(int)(Math.random()*155));
}
dev1=(int)(Math.random()*getWidth());
dev2=(int)(Math.random()*getHeight());
t=new Thread(this);
t.start();
}
public void paint(Graphics g){
g.setColor(cols[colind]);
if(dist<50)
g.drawRect((int)(p1.getX()-((dist)*Math.cos((Math.PI*deg)/180))),(int)(p1.getY()+((dist)*Math.sin((Math.PI*deg)/180))),1,1);
else if(dist<100)g.drawRect(((int)(dev1+p1.getX()+((dist-50)*Math.cos((Math.PI*deg)/180))))%getWidth(),((int)(p1.getY()+((dist-50)*Math.sin((Math.PI*deg)/180))+dev2))%getHeight(),1,1);
}
public void run(){
while(rng){

deg=(deg+1)%360;
if(deg%30==0&&dist<100)dist+=1;
else if(dist==100){dist=0;p1=new Point2D.Float(50+(int)(Math.random()*getWidth()),50+(int)(Math.random()*getHeight()-100));}
if(dist%25==0)colind=(colind+1)%10;
paint(getGraphics());
try{
t.sleep(10);
}
catch(Exception e){}
}
}
public void destroy(){
t=null;
rng=false;
}
}