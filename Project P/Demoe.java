import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.awt.geom.*;
public class Demoe extends Applet implements Runnable{
Thread th;
boolean rng;
Wave w[];
int t;
public void run(){
while(rng){
t=t+1;
paint(getGraphics());
if(t>=getWidth()-120)break;
try{
th.sleep(50);
}
catch(Exception e){}
}
}
public void paint(Graphics g){
for(int i=0;i<w.length;i++){
g.setColor(new Color(0,0,i*(255/w.length)));
g.fillOval(10+t,100+w[i].getY(t)+w[i].pd,20,20);
}
}
public void init(){
w=new Wave[1];
for(int i=0;i<w.length;i++){
w[i]=new Wave(i+1,(int)(i*30*Math.pow(-1,(int)(Math.random()*10))),50+(3*i));
}
t=0;
th=new Thread(this);
rng=true;
th.start();
}
public void destroy(){
th=null;
rng=false;
}
}