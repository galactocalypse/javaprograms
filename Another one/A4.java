import java.awt.*;
import java.applet.*;
public class A4 extends Applet implements Runnable{
int y;
Thread t;
boolean rng;
public void init(){
rng=true;
y=0;
t=new Thread(this);
t.start();
}
public void paint(Graphics g){
g.setColor(Color.gray);
for(int i=0;i<getWidth();i+=5){
g.drawLine(i,0,i,getHeight());
g.drawLine(0,i,getWidth(),i);
}
g.setColor(Color.black);
for(int i=0;i<getWidth();i+=20){
for(int j=0;j<getHeight();j+=10){
g.fillRect(i+(int)(Math.random()*10),j+y,5,5);
g.drawRect(i+y,j+(int)(Math.random()*10),5,5);}
}
}
public void run(){
while(rng){
y=(y+1)%10;
Image img=createImage(getWidth(),getHeight());
paint(img.getGraphics());
getGraphics().drawImage(img,0,0,this);
try{t.sleep(10);
}
catch(Exception e){}
}
}
public void destroy(){
rng=false;
t=null;
}
}