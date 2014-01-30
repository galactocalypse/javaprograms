import java.awt.*;
import java.applet.*;
public class Just extends Applet implements Runnable{
int x;
boolean rng;
Thread t;
Image img;
Graphics h;
public void init(){
x=0;setSize(600,600);
rng=true;
img=createImage(getWidth(),getHeight());
h=img.getGraphics();

t=new Thread(this);
t.start();
}
public void paint(Graphics g){
for(int i=-x;i<getWidth();i+=15){
for(int j=0;j<getHeight();j+=15){
paintbox(g,i,j,((i+j+x)/30)%2);
}
}
}
public void paintbox(Graphics g,int x,int y,int type){
for(int i=x;i<x+15;i++){
if(type==0)
g.setColor(new Color((int)(Math.abs((x+i)%255)),0,0));
else g.setColor(new Color(255-(int)(Math.abs((x+i)%255)),0,0));

g.drawLine(i,y,i,y+15);
}
}
public void run(){
while(rng){
x=15-x;
paint(h);
getGraphics().drawImage(img,0,0,this);
try{
t.sleep(500);
}
catch(Exception e){}
}
}
public void destroy(){
t=null;
rng=false;
}
}