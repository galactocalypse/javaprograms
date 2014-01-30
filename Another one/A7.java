import java.awt.*;
import java.applet.*;
public class A7 extends Applet implements Runnable{
Thread t;
int deg;
boolean rng;
public void init(){
rng=true;
t=new Thread(this);
t.start();
}
public void paint(Graphics g){
int cx=getWidth()/2;
int cy=getHeight()/2;
int r=(cx<cy?cx:cy);
g.drawOval(0,0,getWidth()-2,getHeight()-2);
for(int j=0;j<3;j++){
for(int i=0;i<4;i++){
int rx=(int)(cx+(r*Math.cos((Math.PI*(deg+(j*30)+(i*90))/180))));
int ry=(int)(cy+(r*Math.sin((Math.PI*(deg+(j*30)+(i*90))/180))));
g.drawLine(rx,ry,(int)(cx+(r*Math.cos((Math.PI*(deg+(j*30)+((i+1)*90))/180)))),(int)(cy+(r*Math.sin((Math.PI*(deg+(j*30)+((i+1)*90))/180)))));
}
}
}
public void run(){
while(rng){
deg=(deg+1)%360;
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