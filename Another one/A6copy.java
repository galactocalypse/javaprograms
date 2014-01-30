import java.awt.*;
import java.applet.*;
public class A6copy extends Applet implements Runnable{
Thread t;
int deg;
int x,y,dist;
boolean rng;
public void init(){
rng=true;
deg=0;
dist=150;
x=y=200;
t=new Thread(this);
t.start();
}
public void paint(Graphics g){
g.drawOval(x-dist,y-dist,2*dist,2*dist);

for(int j=0;j<72;j+=3){
for(int i=0;i<dist;i++){
g.setColor(new Color((((i*(255/dist)+50)%200)+50),0,0));
g.drawRect(x+(int)((i)*Math.cos(-(deg+i+(j*5))*Math.PI/180)),y+(int)((i)*Math.sin(-(deg+i+(j*5))*Math.PI/180)),1,1);
g.drawRect(x-(int)((i)*Math.cos((deg+i+(j*5))*Math.PI/180)),y-(int)((i)*Math.sin((deg+i+(j*5))*Math.PI/180)),1,1);
}
}
}
public void run(){
while(rng){
deg=(deg-1)%(360);
//if(deg%15==0)dist-=1;
if(dist<=10)dist=200;
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
rng=false;
t=null;
}
}