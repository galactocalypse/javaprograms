import java.awt.*;
import java.applet.*;
import java.awt.geom.*;
public class Demotet extends Applet implements Runnable{
int r;
Thread t;
boolean rng;
Rectangle2D rect;
double deg;
int ox,oy;
public void init(){
t=new Thread(this);
rng=true;
ox=oy=250;
deg=45;
r=1;
rect=new Rectangle2D.Float((int)(ox+(r*Math.cos(Math.toRadians(deg)))),(int)(oy+(r*Math.sin(Math.toRadians(deg)))),10,10);
t.start();
}
public void paint(Graphics g1){
Graphics2D g=(Graphics2D)g1;
g.fill(rect);
}
public void  run(){
while(rng){
r=r+1;
check();
rect=new Rectangle2D.Float((int)(ox+(r*Math.cos(Math.toRadians(deg)))),(int)(oy+(r*Math.sin(Math.toRadians(deg)))),10,10);
repaint();
try{
t.sleep(10);
}
catch(Exception e){}
}
}
void check(){
if(ox+(r*Math.cos(Math.toRadians(deg)))>=getWidth()){
ox=(int)(ox+(r*Math.cos(Math.toRadians(deg))));
oy=(int)(oy+(r*Math.sin(Math.toRadians(deg))));
deg=Math.abs(180+deg);
r=1;
}
else if(ox+(r*Math.cos(Math.toRadians(deg)))<=0){
ox=(int)(ox+(r*Math.cos(Math.toRadians(deg))));
oy=(int)(oy+(r*Math.sin(Math.toRadians(deg))));
deg=-(deg+180);
r=1;
}
else if(oy+(r*Math.sin(Math.toRadians(deg)))>=getHeight()){
ox=(int)(ox+(r*Math.cos(Math.toRadians(deg))));
oy=(int)(oy+(r*Math.sin(Math.toRadians(deg))));
deg=(deg+90);
r=1;
}
else if(oy+(r*Math.sin(Math.toRadians(deg)))<=0){
ox=(int)(ox+(r*Math.cos(Math.toRadians(deg))));
oy=(int)(oy+(r*Math.sin(Math.toRadians(deg))));
deg=-(180-deg);
r=1;
}
}
public void destroy(){
t=null;
rng=false;
}
}