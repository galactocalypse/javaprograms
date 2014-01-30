import java.awt.*;
import java.applet.*;
import java.awt.geom.*;
public class Circall extends Applet implements Runnable{
int flag,f2,dir;
Thread t;
boolean rng;
public void init(){
t=new Thread(this);
rng=true;
f2=0;
dir=0;
t.start();
}
public void paint(Graphics g){
flag=0;
for(int i=0;i<256-f2;i++){
if(flag==0){
g.setColor(new Color(i+f2,0,0));
}
else {
g.setColor(Color.white);
flag--;}
g.fillArc(i,i,512-(2*i),512-(2*i)-f2,0,360-f2);
if(i%(30+f2)==0){
flag=2;
}
}
g.setColor(Color.white);
for(int i=0;i<360;i+=18){
for(double a=0;a<1;a+=0.1){
double x=255*Math.cos(Math.toRadians(i+a));
double y=255*Math.sin(Math.toRadians(i+a));
g.drawLine(255,255,255+(int)x,255+(int)y);
}
    }
}
public void run(){
while(rng){
f2=f2+(5*(int)Math.pow(-1,dir));
Image img=createImage(getWidth(),getHeight());
paint(img.getGraphics());
getGraphics().drawImage(img,0,0,this);
if(f2==150||f2==0)
dir=1-dir;

try{
t.sleep(500);}
catch(Exception e){}
}
}
}