import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.awt.geom.*;
public class Demofinal extends Applet implements KeyListener{
PtrRes[] pts;
Point2D cp,fwd;
int x,y;
public void init(){
x=100;
y=100;
cp=new Point2D.Double(x,y);
pts=new PtrRes[4];
pts[0]=new PtrRes(cp,20,45);
pts[1]=new PtrRes(cp,20,135);
pts[2]=new PtrRes(cp,20,225);
pts[3]=new PtrRes(cp,20,315);
fwd=new Point2D.Double((pts[0].p.getX()+pts[3].p.getX())/2,(pts[0].p.getY()+pts[3].p.getY())/2);
addKeyListener(this);
}
public void updtPts(){
pts[0]=new PtrRes(cp,20,pts[0].initang);
pts[1]=new PtrRes(cp,20,pts[1].initang);
pts[2]=new PtrRes(cp,20,pts[2].initang);
pts[3]=new PtrRes(cp,20,pts[3].initang);
fwd=new Point2D.Double((pts[0].p.getX()+pts[3].p.getX())/2,(pts[0].p.getY()+pts[3].p.getY())/2);
}
public void paint(Graphics g1){
Graphics2D g=(Graphics2D)g1;
//g.draw(new Line2D.Float(pts[0].p,pts[1].p));
//g.draw(new Line2D.Double(pts[1].p,pts[2].p));
//g.draw(new Line2D.Double(pts[2].p,pts[3].p));
g.draw(new Line2D.Double(pts[3].p,pts[0].p));
g.drawRect((int)cp.getX(),(int)cp.getY(),1,1);
g.setColor(Color.red);
g.draw(new Line2D.Double(cp,fwd));
}
public void upt(int deg){
for(int i=0;i<pts.length;i++){
pts[i].rotate(deg);
}
}
public void keyPressed(KeyEvent e){}
public void keyReleased(KeyEvent e){}
public void keyTyped(KeyEvent e){
switch(e.getKeyChar()){
case 'a':
case 'A':
upt(-2);
break;
case 'd':
case 'D':
upt(2);
break;
case 'w':
case 'W':
if(cp.getX()<fwd.getX())
cp=new Point2D.Double(cp.getX()+2,getNextPt(cp,fwd,-2));
else cp=new Point2D.Double(cp.getX()+2,getNextPt(cp,fwd,2));
updtPts();
break;
case 's':
case 'S':
if(cp.getX()<fwd.getX())
cp=new Point2D.Double(cp.getX()+2,getNextPt(cp,fwd,-2));
else cp=new Point2D.Double(cp.getX()+2,getNextPt(cp,fwd,2));
updtPts();
break;
}
repaint();
}
public double getNextPt(Point2D p1,Point2D p2,int mag){
double m=(p1.getY()-p2.getY())/(p1.getX()-p2.getX());
double ry=m*((p1.getX()+mag)-p2.getX())+p2.getY();
return ry;
}
}