import java.awt.*;
import java.awt.event.*;
import java.applet.*;
public class Demo extends Applet implements Runnable{
Point p;
Thread t;
int maxr;
int flag;
boolean rng;
public void init(){
rng=true;
maxr=100;
flag=0;
t=new Thread(this);
setBackground(new Color(0,0,0));
p=new Point(maxr+50,maxr+50);
t.start();
}
public void paint(Graphics g){
int x=0,y=0;
g.setColor(Color.white);
g.drawOval((int)p.getX()-maxr,(int)p.getY()-maxr,2*maxr,2*maxr);
g.drawOval((int)p.getX()-maxr-1,(int)p.getY()-maxr-1,(2*maxr)+2,(2*maxr)+2);
g.drawOval((int)p.getX()-maxr-2,(int)p.getY()-maxr-2,(2*maxr)+4,(2*maxr)+4);
for(int i=0;i<360;i+=20){
for(int j=0;j<maxr;j++){
x=(int)(p.getX()+(j*Math.cos(Math.toRadians(i+j+(flag)))));
y=(int)(p.getY()+(j*Math.sin(Math.toRadians(i+j-(flag)))));
g.drawRect(x,y,1,1);
 x=(int)(p.getX()+(j*Math.cos(Math.toRadians(i+j-(flag%5)))));
y=(int)(p.getY()-(j*Math.sin(Math.toRadians(i+j+(flag%5)))));
g.drawRect(x,y,1,1);
}
}
}
public void run(){
while(rng){
flag=++flag%20;
Image img=createImage(getWidth(),getHeight());
paint(img.getGraphics());

getGraphics().drawImage(img,0,0,this);
try{
t.sleep(50);
}
catch(Exception e){}
}
}
public void destroy(){
rng=false;
t=null;
}
}