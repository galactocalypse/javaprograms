import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.awt.geom.*;
public class Escapa extends Applet implements Runnable,MouseMotionListener,MouseListener{
Thread t;
boolean rng,lost;
Rectangle2D rects[],myRect;
int dir[],spd[],ne,nw,se,sw;
long time;
public void init(){
rects=new Rectangle2D[4];
spd=dir=new int[8];
ne=1;nw=2;se=3;sw=4;
for(int i=0;i<rects.length;i++){
rects[i]=new Rectangle2D.Float(i*(int)(Math.random()*100),i*(int)(Math.random()*100),50,50);
spd[i]=Math.abs((int)(Math.random()*2)-3);
}
while(myRect==null||myRect.intersects(rects[0])||myRect.intersects(rects[1])||myRect.intersects(rects[2])||myRect.intersects(rects[3])){
myRect=new Rectangle2D.Float((int)(Math.random()*200),(int)(Math.random()*200),40,40);
}
dir[0]=ne;
dir[1]=nw;
dir[2]=se;
dir[3]=sw;
addMouseMotionListener(this);
addMouseListener(this);
lost=rng=false;
}
public void paint(Graphics g1){
setSize(500,500);
Graphics2D g=(Graphics2D)g1;
g.setColor(Color.black);
for(int i=0;i<rects.length;i++){g.fill(rects[i]);}
g.setColor(Color.red);
g.fill(myRect);
}
boolean lost(){
for(int i=0;i<4;i++){
if(myRect.intersects(rects[i]))return true;
}
return false;
}
public void run(){
while(!lost&&rng){
time++;
process();
repaint();
if(lost())lost=true;
try{t.sleep(10);}catch(Exception e){}
}
}
public void destroy(){t=null;rng=false;}
public void process(){
for(int i=0;i<rects.length;i++){
if(rects[i].getY()<=0){
if(dir[i]==ne)dir[i]=se;
if(dir[i]==nw)dir[i]=sw;
}
if(rects[i].getY()+50>=getHeight()){
if(dir[i]==se)dir[i]=ne;
if(dir[i]==sw)dir[i]=nw;
}
 if(rects[i].getX()>=getWidth()){
if(dir[i]==se)dir[i]=sw;
 if(dir[i]==ne)dir[i]=nw;
}
 if(rects[i].getX()<=0){
if(dir[i]==sw)dir[i]=se;
 if(dir[i]==nw)dir[i]=ne;
}
if(dir[i]==ne)rects[i]=new Rectangle2D.Float((int)rects[i].getX()+spd[i],(int)rects[i].getY()-spd[i],50,50);
if(dir[i]==se)rects[i]=new Rectangle2D.Float((int)rects[i].getX()+spd[i],(int)rects[i].getY()+spd[i],50,50);
if(dir[i]==nw)rects[i]=new Rectangle2D.Float((int)rects[i].getX()-spd[i],(int)rects[i].getY()-spd[i],50,50);
if(dir[i]==sw)rects[i]=new Rectangle2D.Float((int)rects[i].getX()-spd[i],(int)rects[i].getY()+spd[i],50,50);
}
}
public void mouseMoved(MouseEvent e){}
public void mouseDragged(MouseEvent e){
Point2D p=new Point2D.Float((float)e.getX(),(float)e.getY());
if(myRect.contains(p))myRect=new Rectangle2D.Float((int)p.getX()-20,(int)p.getY()-20,40,40);
}
public void mousePressed(MouseEvent e){if(rng==false&&lost==false){
t=new Thread(this);rng=true;
t.start();
}}
public void mouseReleased(MouseEvent e){}
public void mouseClicked(MouseEvent e){

}
public void mouseEntered(MouseEvent e){}
public void mouseExited(MouseEvent e){}
}