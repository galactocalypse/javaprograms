import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.awt.geom.*;
public class War extends Applet implements Runnable,KeyListener{
Rectangle2D user;
FireBall f[];
Thread t;
boolean rng;
int x,y,unit,dir;

public void init(){
user=new Rectangle2D.Float(x,y,100,100);
unit=100;
dir=2;
f=new FireBall[25];
t=new Thread(this);
rng=true;
addKeyListener(this);
t.start();
}
public void updt(){
user=new Rectangle2D.Float(x,y,100,100);
for(int i=0;i<f.length;i++){
if(f[i]!=null)f[i].update();
//if(checkIntersection()==true)f[i].consumed=true;
//if(f[i].consumed)f[i]=null;

}
}
public boolean checkIntersection(){

for(int i=0;i<f.length;i++){
int x=(int)f[i].getRect().getX(),y=(int)f[i].getRect().getY();
if(x<0||x>getWidth()||y<0||y>getHeight())return true;
//if(user.intersects(f[i].getRect()))return true;
}
return false;
}
public void paint(Graphics g1){
Graphics2D g=(Graphics2D)g1;
g.draw(user);
for(int i=0;i<f.length;i++){
if(f[i]!=null)f[i].showBullet(g);
}
}
public void run(){
while(rng){
updt();
repaint();
try{
t.sleep(50);
}
catch(Exception e){}
}
}
public void keyTyped(KeyEvent e){
char ch=(""+e.getKeyChar()).toLowerCase().charAt(0);
switch(ch){
case 'a':
x=x-unit;
break;
case 'd':
x=x+unit;
break;
case 'w':y=y-unit;
break;
case 's': y=y+unit;
break;
case 'f':fire();
break;
}
e.consume();
}
public void keyPressed(KeyEvent e){}
public void keyReleased(KeyEvent e){}
public void fire(){
add(new FireBall(x,y,dir));
}
public void add(FireBall fb){
for(int i=0;i<f.length;i++){
if(f[i]==null){f[i]=fb;break;}
}
}
}