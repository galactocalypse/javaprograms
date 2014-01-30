import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.applet.*;
public class AC extends Rectangle{
Image img;
AC(int x,int y,int w,int h,Image bg){
new Rectangle2D.Float(x,y,w,h);
img=bg;
}
Image getBg(){return img;}
public void paint(Graphics g1,Applet io){
Graphics2D g=(Graphics2D)g1;
g.setColor(Color.black);
g.fillRect((int)getX(),(int)getY(),(int)getWidth(),(int)getHeight());
g.drawImage(img,(int)getX(),(int)getY(),io);
}
}