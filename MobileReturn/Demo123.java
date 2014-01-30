import java.awt.*;
import java.applet.*;

public class Demo123 extends Applet implements Runnable{
int x;
Thread t;
Image img;
Graphics h;
boolean rng;
public void init(){
t=new Thread(this);
rng=true;
x=0;
img=createImage(getWidth(),getHeight());
h=img.getGraphics();
t.start();
}
public void paint(Graphics g){
for(;x<=201;x+=40){
for(int i=0;i<40;i++){
if(i<20)
g.setColor((new Color(255-(i*255/20),255-(i*255/20),255-(i*255/20))));
else
g.setColor(new Color(((i-20)*255/20),((i-20)*255/20),((i-20)*255/20)));
g.drawRect(x+i,x+i,getWidth()-1-(2*(i+x)),getHeight()-1-(2*(i+x)));
}
}
}
public void run(){
while(rng){
if(x%2==0)x=1;
else x=0;
paint(h);
getGraphics().drawImage(img,0,0,this);
try{
t.sleep(200);
}
catch(Exception e){}
}
}
public void destroy(){
t=null;
rng=false;
}
}