import java.awt.*;
import java.applet.*;
public class BlahKeshto extends Applet implements Runnable{
Thread t;
boolean rng;
int i,dir;

public void init(){
i=0;dir=0;
t=new Thread(this);
rng=true;
t.start();
}
public void paint(Graphics g){

g.fillRoundRect(100,100,100,100,i,i);
g.setColor(Color.red);
g.fillRoundRect(100,100,100,100,100-i,100-i);
}
public void run(){
while(rng){
if(dir==0)i=i+1;
else i--;
if(i%100==0)dir=1-dir;
repaint();
try{
t.sleep(20);
}
catch(Exception e){}
}
}
}