import java.awt.*;
import java.applet.*;
public class Temp extends Applet implements Runnable{
Thread t;
boolean rng;
public void init(){
rng=true;
t=new Thread(this);
t.start();
}
public void paint(Graphics g){}
public void run(){
while(rng){
Image img=createImage(getWidth(),getHeight());
paint(img.getGraphics());
getGraphics().drawImage(img,0,0,this);
try{
t.sleep(100);
}
catch(Exception e){}
}
}
public void destroy(){
rng=false;
t=null;
}
}