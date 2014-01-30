import java.applet.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
public class DemoGame extends Applet implements Runnable,KeyListener{
Rectangle2D rects[],user;
int dir[],speed[],north,south;
Thread t;
boolean running,won,lost;
int n;
public void init(){
n=5;
setSize(50*(n+2),400);
north=1;
south=2;
rects=new Rectangle2D[n];
dir=new int[n];
speed=new int[n];
for(int i=0;i<n;i++){
rects[i]=new Rectangle2D.Float(50+(i*50),(getHeight()*i/4)+(int)(Math.random()*getWidth()/4),40,100);
dir[i]=north;
speed[i]=1;
speed[i]+=(int)(Math.random()*i);
}
user=new Rectangle2D.Float(0,getHeight()/2,40,40);
running=true;
won=lost=false;
t=new Thread(this);
addKeyListener(this);
t.start();
}
public void wait(int v){
for(int i=0;i<v;i++){int n=2*i;}}
public void paint(Graphics g1){

Image img=createImage(getWidth(),getHeight());
Graphics2D g=(Graphics2D)img.getGraphics();
if(!lost&&!won){
for(int i=0;i<n;i++){
g.fill(rects[i]);
}
g.draw(user);
}
else if(won){
wait(99999999);
g.setColor(Color.green);
g.fillRect(0,0,getWidth(),getHeight());
g.setColor(Color.white);
g.setFont(new Font("Trebuchet ms",Font.BOLD,50));
g.drawString("You Won!",50,getHeight()/2);
t=null;
}
else if(lost){
wait(99999999);
g.setColor(Color.red);
g.fillRect(0,0,getWidth(),getHeight());
g.setColor(Color.white);
g.setFont(new Font("Trebuchet ms",Font.BOLD,50));
g.drawString("You lost!",50,getHeight()/2);
t=null;
}
g1.drawImage(img,0,0,this);
}
public boolean caught(){
for(int i=0;i<n;i++){
if(rects[i].intersects(user)){lost=true;return true;
}
}
return false;
}
public void run(){
while(running){
if(!caught()&&!hasWon()){
for(int i=0;i<n;i++){
if(rects[i].getY()<=0&&dir[i]==north){dir[i]=south;}
else if(rects[i].getY()+rects[i].getHeight()>=getHeight()&&dir[i]==south){dir[i]=north;}
if(dir[i]==north)rects[i]=new Rectangle2D.Float((int)rects[i].getX(),(int)rects[i].getY()-speed[i],(int)rects[i].getWidth(),(int)rects[i].getHeight());
else if(dir[i]==south)rects[i]=new Rectangle2D.Float((int)rects[i].getX(),(int)rects[i].getY()+speed[i],(int)rects[i].getWidth(),(int)rects[i].getHeight());
}
}
else if(hasWon())won=true;
else if(caught())lost=true;
paint(getGraphics());
try{t.sleep(10);
}
catch(Exception e){}
}
}
public void destroy(){
t=null;
rects=null;
user=null;
running=false;
setVisible(false);
}
public void keyPressed(KeyEvent e){}
public void keyReleased(KeyEvent e){}
public void keyTyped(KeyEvent e){
char ch=(""+e.getKeyChar()).toLowerCase().charAt(0);
switch(ch){
case 'a':
if(user.getX()>=50)user=new Rectangle2D.Float((int)user.getX()-50,(int)user.getY(),(int)user.getWidth(),(int)user.getHeight());
break;
case 'w':
if(user.getY()>=20)user=new Rectangle2D.Float((int)user.getX(),(int)user.getY()-50,(int)user.getWidth(),(int)user.getHeight());
break;
case 'd':
if(user.getX()+user.getWidth()<=getWidth()-50)user=new Rectangle2D.Float((int)user.getX()+50,(int)user.getY(),(int)user.getWidth(),(int)user.getHeight());
break;
case 'z':
if(user.getY()+user.getHeight()<=getHeight()-20)user=new Rectangle2D.Float((int)user.getX(),(int)user.getY()+50,(int)user.getWidth(),(int)user.getHeight());
break;
case 'p':
t=new Thread(this);
lost=won=false;
init();
t.start();
default:
break;
}
paint(getGraphics());
}
boolean hasWon(){
if(user.getX()>=getWidth()-55)return true;
else return false;
}
}