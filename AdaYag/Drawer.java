import java.awt.geom.*;
import java.awt.*;
import java.applet.*;

public class Drawer extends Applet implements Runnable{
PointHandler p;
int a,b,angle;
Thread t;
boolean rng;
public void paintIt(Graphics2D g,Point2D p1[],Point2D p2[]){
for(int i=0;i<4;i++){
g.draw(new Line2D.Float(p1[i],p1[(i+1)%4]));
g.draw(new Line2D.Float(p2[i],p2[(i+1)%4]));
g.draw(new Line2D.Float(p1[i],p2[i]));
}
}
public void init(){
a=100;
b=20;
angle=0;
p=new PointHandler();
rng=true;
t=new Thread(this);
t.start();
}
public void run(){
while(rng){
Image img=createImage(getWidth(),getHeight());
paintIt((Graphics2D)img.getGraphics(),p.getPoints(a,b,angle),p.getSecondSet(a,b,angle));
getGraphics().drawImage(img,250,250,this);
angle=(angle+1)%360;
try{t.sleep(50);}catch(Exception e){}
}
}
}