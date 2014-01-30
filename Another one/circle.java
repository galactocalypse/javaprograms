 import java.awt.*;
import java.applet.*;

public class circle extends Applet
 implements Runnable{
int i;
Thread th;
boolean rng;
public void init(){
setBackground(Color.white);
setForeground(Color.black);
rng=true;
i=0;
th=new Thread(this);
}
public void start(){
th.start();
}
public void run(){
while(rng){
if(i<=10)i=i+1;
if(i==11)i=0;
repaint();
try{
Thread.sleep(100);
}
catch(InterruptedException e){}
}
}
public void paint(Graphics g){
g.drawOval(100+i,240+i,100-(2*i),100-(2*i));
setBackground(Color.white);
setForeground(Color.black);

}
public void destroy(){rng=false;}
}
