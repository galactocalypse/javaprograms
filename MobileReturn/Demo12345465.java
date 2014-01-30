import java.awt.*;
import java.awt.geom.*;
import java.applet.*;
import java.awt.event.*;
public class Demo12345465 extends Applet implements KeyListener,Runnable{
Rectangle2D user;
int timer;
Thread t;
boolean rng;
float speed,acc,maxspeed;
int x,y,width,height;

public void define(){
user=new Rectangle2D.Float(x,y,width,height);
}
public void paint(Graphics g1){
Graphics2D g=(Graphics2D)g1;
g.fill(user);
g.drawString("spd : "+speed,200,200);
}
public void keyPressed(KeyEvent e){
char ch=(""+e.getKeyChar()).toLowerCase().charAt(0);
timer=timer+1;
if(timer==15){speed++;timer=0;}
if(ch=='a'){x=(int)(x-speed);}
else if(ch=='w'){y--;}
else if(ch=='s'){y++;}
else if (ch=='d'){x=(int)(x+speed);}

define();
repaint();
}
public void keyTyped(KeyEvent e){
timer++;}
public void keyReleased(KeyEvent e){}
public void init(){
x=100;
y=100;
width=100;
height=50;
speed=1;
define();
addKeyListener(this);
rng=true;
t=new Thread(this);
t.start();
}
public void run(){
while(rng){
if(timer==15){speed++;timer=0;}
define();
try{
t.sleep(50);
}
catch(Exception e){}
}
}
public void destroy(){
t=null;
rng=false;
}
}