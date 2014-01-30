import java.awt.*;
import java.applet.*;

public class Radar extends Applet implements Runnable
{
Thread t;
float i,x;
int c,x1,y1,x2,y2;
boolean stopFlag,fl;

public void init()
{
x1=(getWidth()/2)+(int)(100*Math.cos(Math.toRadians(0)));
y1=(getHeight()/2)+(int)(100*Math.sin(Math.toRadians(0)));
x2=(getWidth()/2)-(int)(100*Math.cos(Math.toRadians(0)));
y2=(getHeight()/2)-(int)(100*Math.sin(Math.toRadians(0)));
t=new Thread(this);
c=0;x=0;
stopFlag=false;
fl=true;
t.start();
}

public void run()
{
for(i=0;i<360;i+=0.1)
{
x=i;
x1=(getWidth()/2)+(int)(100*Math.cos(Math.toRadians(x)));
y1=(getHeight()/2)+(int)(100*Math.sin(Math.toRadians(x)));
x2=(getWidth()/2)-(int)(100*Math.cos(Math.toRadians(x)));
y2=(getHeight()/2)-(int)(100*Math.sin(Math.toRadians(x)));
if(fl)
c++;
if(fl==false)
c--;
if(c==225)
fl=false;
if(c==0)fl=true;
paint(getGraphics());
try{
Thread.sleep(0);
}catch(Exception e){}
if(stopFlag)
break;
if(i==359.9)
i=0;


}
}

public void paint(Graphics g)
{
g.setColor(new Color(c,0,0));
g.drawLine(getWidth()/2,getHeight()/2,x1,y1);
g.drawLine(getWidth()/2,getHeight()/2,x2,y2);
}

public void stop()
{
stopFlag=true;
t=null;
}
}