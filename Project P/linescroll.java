import java.io.*;
import java.applet.*;
import java.awt.*;
import java.awt.Graphics.*;        
    
    public class linescroll extends Applet implements Runnable
    {
        String s="A new boy has come ";
        Thread t=null;
        int state,i;
        boolean stopflag,dir;
       // public void init()
        {
        
        }
        public void start()
        {
            t=new Thread(this);
            stopflag=false;
            dir=false;
            t.start();
            i=0;
        }
        public void run()
        {
            char ch;
            for(;;)
            {
                try
                {
                    repaint();
                    Thread.sleep(50);
                    ch=s.charAt(0);
                    s=s.substring(1,s.length())+ch;
                    if(!dir)
                    {
                    i=i+5;
                    }
                    else
                    {
                    i=i-5;
                    }
                    if(i==0)
                    {
                    i=0;
                    dir=false;
                    }
                    if(i==getSize().width)
                    {
                    i=getSize().width;
                    dir=true;
                    }
                    if(stopflag)
                     break;
                   }  
                     catch(InterruptedException e){}
                }
            }
            public void stop()
            {
                stopflag=true;
                t=null;
            }
            public void paint(Graphics g)
            {
            g.drawOval(i,20,20,20);
             g.drawLine(i+20,i+50,20,100);
                g.drawString(s,30,50);
            }
        }
 