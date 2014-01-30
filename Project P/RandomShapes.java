import java.awt.*;
import java.applet.*;
import java.awt.geom.*;
public class RandomShapes extends Applet implements Runnable{
Thread t;
boolean rng;
Point2D p[];
public void init(){
t=new Thread(this);
rng=true;
t.start();
}
public void paint(Graphics g1){
Graphics2D g=(Graphics2D)g1;
for(int i=0;i<p.length;i++){
g.draw(new Line2D.Float(p[(i)%p.length],p[(i+1)%p.length]));
}
}
public void run(){
while(rng){
p=new Point2D[2+(int)(Math.random()*5)];
for(int i=0;i<p.length;i++){
p[i]=new Point2D.Float((int)(Math.random()*getWidth()),(int)(Math.random()*getHeight()));
}
repaint();
try{t.sleep(1000);
}
catch(Exception e){}
}
}
}
