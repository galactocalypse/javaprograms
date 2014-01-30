import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.awt.geom.*;
public class Blah2 extends Applet implements Runnable{
Thread t;
Bars b[];
boolean rng;
public void init(){
setBackground(new Color(200,0,0));
b=new Bars[15];
for(int i=0;i<b.length;i++)
b[i]=new Bars(15,0);
rng=true;
t=new Thread(this);
t.start();
}
public void paint(Graphics g){
for(int j=0;j<b.length;j++){
for(int i=0;i<b[j].ptr;i++){
g.setColor(new Color(25*(i/2),0,0));
g.fillRect(10+(i*12),j*30,10,20);
}
}
}
public void run(){
while(rng){
for(int i=0;i<b.length;i++)
b[i].process();
Image img=createImage(getWidth(),getHeight());
paint(img.getGraphics());
getGraphics().drawImage(img,0,0,this);
try{t.sleep(0);
}
catch(Exception e){}
}
}
public void destroy(){
t=null;
rng=false;
}
}