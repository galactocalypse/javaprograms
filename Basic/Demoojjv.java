import java.awt.*;
import java.applet.*;
import java.awt.geom.*;
public class Demoojjv extends Applet{
public void paint(Graphics g){
Point2D p=new Point2D.Float((int)(Math.random()*getWidth()),(int)(Math.random()*getHeight()));
int radius=30,rad,flg=0,extent;
for(int i=0;i<1000;i++){
rad=(int)(Math.random()*radius);
extent=50+(int)(Math.random()*280);
g.setColor(new Color(20+(int)(Math.random()*150),20+(int)(Math.random()*150),0));
g.fillArc((int)p.getX()-rad,(int)p.getY()-rad,2*rad,2*rad,flg,(int)Math.pow(-1,i)*extent);
flg=(flg+extent)%((int)(Math.random()*360));
//p=new Point((int)(p.getX()+(radius*Math.cos(Math.toRadians(extent)))),(int)(p.getX()+(radius*Math.sin(Math.toRadians(extent)))));
//if(p.getX()<40||p.getX()>450||p.getY()>450||p.getY()<0)
p=new Point2D.Float((int)(Math.random()*getWidth()),(int)(Math.random()*getHeight()));
}
}
}