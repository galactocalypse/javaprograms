import java.applet.*;
import java.awt.geom.*;
import java.awt.*;

import java.awt.event.*;
public class Scroll extends Applet implements Runnable,MouseMotionListener{
Thread t;

Rectangle2D r;
boolean rng,move;
int y;
String s[]={"This","is","the","supposed","string."};
public void init(){
rng=move=true;
r=new Rectangle2D.Double(20,20,getMaxStringWidth(),getHeight()-40);
y=(int)(r.getY()+r.getHeight()-getGraphics().getFont().getSize());
addMouseMotionListener(this);
setIgnoreRepaint(true);
t=new Thread(this);
t.start();
}
public void paint(Graphics g){}
public void run(){
while(rng){
if(move){y--;
if(y<=r.getY()-(15*s.length))y=(int)(r.getY()+r.getHeight()-getGraphics().getFont().getSize());
}
Image img=createImage(getWidth(),getHeight());
Graphics2D g=(Graphics2D)img.getGraphics();
g.draw(r);
for(int i=0;i<s.length;i++){
g.drawString(s[i],20,(int)(r.getY()+(y+(i*15))%r.getHeight()));
}
getGraphics().drawImage(img,0,0,(int)r.getWidth()+1,(int)r.getHeight()+1,(int)r.getX(),(int)r.getY(),(int)(r.getWidth()+r.getX()+1),(int)(1+r.getHeight()+r.getY()),this);
try{t.sleep(10);}
catch(Exception e){}
}
}
public void mouseMoved(MouseEvent e){
Point2D p=new Point2D.Double(e.getX(),e.getY());
if(r.contains(p))move=false;
else move=true;
}
int getMaxStringWidth(){
if(s==null)return 0;
int max=0;
FontMetrics fm=getFontMetrics(getGraphics().getFont());
max=fm.stringWidth(s[0]);
for(int i=1;i<s.length;i++){
if(fm.stringWidth(s[i])>max)max=fm.stringWidth(s[i]);
}return max;
}
public void mouseDragged(MouseEvent e){
Point2D p=new Point2D.Double(e.getX(),e.getY());
if(r.contains(p))move=false;
else move=true;

}
}