import java.awt.*;
import java.applet.*;
import java.awt.geom.*;
import java.awt.event.*;
public class Demoexx extends Applet implements Runnable,MouseMotionListener,MouseListener{
Ellipse2D ball;
int bx,by;
int mx,my;
int fx,fy;
int deg;
boolean drag;
Thread t;
boolean rng,pt;

public void init(){
fx=bx=15+(int)(double)(Math.random()*(getWidth()-30));
fy=by=15+(int)(double)(Math.random()*(getHeight()-30));
drag=false;
ball=new Ellipse2D.Float(bx-15,by-15,30,30);
rng=true;
pt=true;
addMouseMotionListener(this);
addMouseListener(this);
t=new Thread(this);
t.start();
}
public void paint(Graphics g){
g.drawOval(bx-15,by-15,30,30);
}
public void mouseEntered(MouseEvent e){}
public void mouseExited(MouseEvent e){}
public void mousePressed(MouseEvent e){
if(ball.contains(new Point2D.Float((int)e.getX(),(int)e.getY())))drag=true;else drag=false;
}
public void mouseReleased(MouseEvent e){
pt=true;
if(drag){
drag=false;
deg=(int)(Math.atan((by-my)/(bx-mx))*180/Math.PI);
fx=mx;
fy=my;
}
}
public void mouseClicked(MouseEvent e){}
public void mouseMoved(MouseEvent e){}
public void mouseDragged(MouseEvent e){
pt=false;
if(drag){
mx=(int)e.getX();
my=(int)e.getY();
deg=(int)(Math.atan((by-my)/(bx-mx))*180/Math.PI);
Graphics h=getGraphics();
h.drawLine(bx,by,(int)(bx+(100*Math.cos(deg*Math.PI/180))),(int)(by+(100*Math.sin(deg*Math.PI/180))));
}
}
public void run(){
while(rng){
if(pt){
int dist=(int)(Math.pow(Math.pow(fx-bx,2)+Math.pow(fy-by,2),0.5));
if(dist!=0)dist++;
bx=(int)(fx+(dist*Math.cos(deg*Math.PI/180)));
by=(int)(fy+(dist*Math.sin(deg*Math.PI/180)));
ball=new Ellipse2D.Float(bx-15,by-15,30,30);
repaint();
}
try{t.sleep(10);
}
catch(Exception e){}
}
}
public void destroy(){
t=null;
rng=false;
}
}