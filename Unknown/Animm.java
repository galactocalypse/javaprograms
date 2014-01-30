import java.awt.*;
import java.applet.*;
import java.awt.geom.*;
import java.awt.event.*;
public class Animm extends Applet implements Runnable{
int j;
Thread t;

boolean rng;
public void init(){
rng=true;
j=0;
t=new Thread(this);
t.start();
}
public void paint(Graphics g){
for(int i=0;i<60;i++){
g.drawLine((2*118)-(i*4),0,236-(i*4),(5*i)-j);
}
for(int i=0;i<60;i++){
g.drawLine(getWidth()-((2*118)-(i*4)),0,getWidth()-(236-(i*4)),(5*i)-j);
}
for(int i=0;i<60;i++){
g.drawLine((2*118)-(i*4),getHeight(),236-(i*4),getHeight()-((5*i)-j));
}
for(int i=0;i<60;i++){
g.drawLine(getWidth()-((2*118)-(i*4)),getHeight(),getWidth()-(236-(i*4)),getHeight()-((5*i)-j));
}
}
public void run(){
while(rng&&j<=120){
j++;
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
t=null;rng=false;
}

}