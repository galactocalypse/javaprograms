import java.awt.*;
import java.applet.*;
public class rotation extends Applet implements Runnable
{
int x=300,y=300,x2=300,y2=300;
Thread t=null;
boolean stopflag;
public void init(){

}
public void start(){
t=new Thread(this);
stopflag=false;
t.start();
}
public void run(){
for(int i=0;i<360;i++){
try{
repaint();
x2=300+(int)(100*Math.cos(Math.toRadians(i)));
y2=300+(int)(100*Math.sin(Math.toRadians(i)));

if(stopflag==true)
break;
Thread.sleep(50);

}
catch(InterruptedException e){}
}
}
public void stop(){
stopflag=true;
t=null;
}
public void paint(Graphics g){
g.drawLine(x,y,x2,y2);
}
}