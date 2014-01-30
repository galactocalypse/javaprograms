import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class ChangeCircle extends Applet implements Runnable
{
Thread t=null;
boolean stopFlag;
int n=0;
double ang=0;
int centx,centy,tempx,tempy,wid,hit,x1,y1,x2,y2,diff;

public void start()
{
t=new Thread(this);
stopFlag=false;
t.start();
}

public void run()
{
while(n<=250)
{

centx=getWidth()/2-(n);
centy=getHeight()/2-(n);
wid=n*2;
hit=n*2;
diff=(250-n);
x1=getWidth()/2+(int)((double)diff*(Math.cos(ang)));
y1=getHeight()/2-(int)((double) diff*(Math.sin(ang)));
x2=getWidth()/2-(int)((double)diff*(Math.cos(ang)));
y2=getHeight()/2+(int)((double)diff*(Math.sin(ang)));
repaint();
try{
Thread.sleep(50);
}catch(InterruptedException e){}
if(stopFlag)
break;
if(n==250)
{
tempx=centx;
tempy=centy;
ang=0;

while(n>0)
{
diff=250-n;
centx=getWidth()/2-(n);
centy=getHeight()/2-(n);
wid=n*2;
hit=n*2;
x1=getWidth()/2+(int)((double)diff*(Math.cos(ang)));
y1=getHeight()/2-(int)((double) diff*(Math.sin(ang)));
x2=getWidth()/2-(int)((double)diff*(Math.cos(ang)));
y2=getHeight()/2+(int)((double)diff*(Math.sin(ang)));
repaint();
try{
Thread.sleep(500);
}catch(InterruptedException e){}
n--;
ang++;

}

}
n++;
ang++;
}
}

public void paint(Graphics g)
{

g.drawOval(centx,centy,wid,hit);
g.drawLine(x1,y1,getWidth()/2,getHeight()/2);
g.drawLine(x2,y2,getWidth()/2,getHeight()/2);
}

public void stop()
{
stopFlag=true;
t=null;
}
}