import java.awt.*;
import java.applet.*;

public class Revolutjgion extends Applet implements Runnable
{
    Thread t;
    double i=0,moon=0,mars=0,saturn=0;
    int xearth,yearth,xmoon,ymoon,xmars,ymars,xsaturn,ysaturn;
    int sunS=60,earthS=30,moonS=4,marsS=32,saturnS=42;
    int earthD=70,moonD=15,marsD=100,saturnD=150;
    boolean stopFlag,fl=true;
    
    public void init()
    {
        setBackground(new Color(0,0,0));
           xearth=yearth=xmoon=ymoon=0;
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
            xearth=getWidth()/2+(int)(earthD*Math.cos(Math.toRadians(i)));
            yearth=getHeight()/2-(int)(earthD*Math.sin(Math.toRadians(i)));
            
            moon=moon+5;   
            xmoon=xearth-(int)(moonD*Math.cos(Math.toRadians(180-moon)))+10;
            ymoon=yearth+(int)(moonD*Math.sin(Math.toRadians(-moon)))+10;
            
            mars=mars+1.03;
            xmars=getWidth()/2+(int)(marsD*Math.cos(Math.toRadians(mars)));
            ymars=getHeight()/2-(int)(marsD*Math.sin(Math.toRadians(mars)));
            
            saturn=saturn+1.05;
            xsaturn=getWidth()/2+(int)(saturnD*Math.cos(Math.toRadians(saturn)));
            ysaturn=getHeight()/2-(int)(saturnD*Math.sin(Math.toRadians(saturn)));
            Image img=createImage(getWidth(),getHeight());
            paint(img.getGraphics());
            getGraphics().drawImage(img,0,0,this);
            try{
                Thread.sleep(0);
            }catch(Exception e){}
            
            if(i==360)
            i=0;
            if(moon>=360)
            moon=0;           
            if(mars>=360)
            mars=0;
            if(saturn>=360)
            saturn=0;
        }
            
            
            }
    
    
    public void paint(Graphics g)
    {
        //orbits
        g.setColor(new Color(100,100,50));
        g.drawOval(getWidth()/2-(earthD-(earthS/2)),getHeight()/2-(earthD-(earthS/2)),2*earthD,2*earthD);
        g.drawOval(getWidth()/2-(marsD-(marsS/2)),getHeight()/2-(marsD-(marsS/2)),2*marsD,2*marsD);
        g.drawOval(getWidth()/2-(saturnD-(saturnS/2)),getHeight()/2-(saturnD-(saturnS/2)),2*saturnD,2*saturnD);
        
        for(int k=0;k<10;k++)//stars
        {
            g.fillOval((int)( Math.random()*getWidth()),(int)( Math.random()*getHeight()),2,2);
        }
        //sun
        g.setColor(new Color(255,225,0));
        fillOvall(g,(getWidth()/2-((sunS)/2)+(earthS/2)),(getHeight()/2-((sunS)/2)+(earthS/2)),sunS,sunS,new Color(225,225,50));
        //planets are plotted
        g.setColor(new Color(60,60,226));
        Color c=g.getColor();
        fillOvall(g,xearth,yearth,earthS,earthS,c);
        g.setColor(new Color(255,255,255));
        g.fillOval(xmoon,ymoon,moonS,moonS);
        g.setColor(new Color(255,105,0));
        fillOvall(g,xmars,ymars,marsS,marsS,new Color(255,105,0));
        g.setColor(new Color(255,195,0));
        fillOvall(g,xsaturn,ysaturn,saturnS,saturnS,new Color(255,195,0));
            
            
    }
    
    public void stop()
    {
        stopFlag=true;
        t=null;
    }
    public void fillOvall(Graphics g,int x,int y,int w,int h,Color c){
        int red=c.getRed(),green=c.getGreen(),blue=c.getBlue(),r1,b1,g1;
        
        for(int i=0;i<w/2;i++){
            r1=(int)(red*i*2/w);
            g1=(int)(green*2*i/w);
            b1=(int)(blue*2*i/w);
            g.setColor(new Color(r1,g1,b1));
            g.fillOval(x+i,y+i,w-(2*i),h-(2*i));
        }
    }
}
