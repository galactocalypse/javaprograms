import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class A2 extends Applet implements Runnable,MouseMotionListener{
int i[],m;
Thread t;
boolean rng;
public void init(){
i=new int[100];
for(int j=0;j<i.length;j++){
i[j]=(int)(Math.random()*360);
}
m=200;
rng=true;
t=new Thread(this);
addMouseMotionListener(this);
t.start();
}
public void paint(Graphics g){
for(int j=0;j<i.length;j++){
if(5*j<getWidth()-50){
if(j%2==0){
g.drawArc(50*(j%10),50*(j/10),50,50,i[j],m);
g.drawArc(50*(j%10),50*(j/10),50,50,i[j]+180,m);
}else {g.drawArc(50*(j%10),50*(j/10),50,50,360-i[j],m);
g.drawArc(50*(j%10),50*(j/10),50,50,360-i[j]+180,m);
}
}
}
}
public void run(){
while(rng){
for(int j=0;j<i.length;j++){
i[j]=(i[j]+3+(int)(Math.random()*10))%360;
}
Image img=createImage(getWidth(),getHeight());
paint(img.getGraphics());
getGraphics().drawImage(img,0,0,this);
try{t.sleep(10);}
catch(Exception e){}
}
}
public void destroy(){rng=false;t=null;}
public void mouseMoved(MouseEvent e){
m=(++m)%200;
}
public void mouseDragged(MouseEvent e){m=(--m)%200;
}
}