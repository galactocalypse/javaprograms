import java.awt.*;
import java.applet.*;

public class Revolution extends Applet implements Runnable
{
    Thread t;
    double i=0;
    int c=0,x1,y1,x2,y2;
    boolean stopFlag,fl=true;
    
    public void init()
    {
        setBackground(new Color(0,0,0));
           x1=y1=x2=y2=0;
     }
     
    public void start()
    {
        t=new Thread(this);
        stopFlag=false;
        t.start();
    }
    
    public void run()
    {
        
         for(i=0;i<=360;i++)   
         {
             
             if(stopFlag)
            break;
            x1=getWidth()/2+(int)(200*Math.cos(Math.toRadians(i)));
            y1=getHeight()/2-(int)(200*Math.sin(Math.toRadians(i)));
            x2=x1-(int)(22*Math.cos(Math.toRadians(180-i)));
            y2=y1+(int)(22*Math.sin(Math.toRadians(-i)));
            repaint();
            try{
                Thread.sleep(10);
            }catch(Exception e){}
            if(i==360)
            i=0;
        }
            
            
            }
    
  
    public void paint(Graphics g)
    {
        g.setColor(new Color(255,255,255));
        for(int k=0;k<50;k++)
        {
            g.fillOval((int)( Math.random()*getWidth()),(int)( Math.random()*getHeight()),2,2);
        }
        g.setColor(new Color(255,225,0));
        g.fillOval(getWidth()/2-45,getHeight()/2-45,90,90);
        g.setColor(new Color(0,0,226));
        g.fillOval(x1,y1,30,30);
        g.setColor(new Color(255,255,255));
        g.fillOval(x2,y2,10,10);
    }
    
    public void stop()
    {
        stopFlag=true;
        t=null;
    }
}
