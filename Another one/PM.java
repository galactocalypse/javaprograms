import java.awt.*;
import java.awt.geom.*;
import java.applet.*;
import java.awt.event.*;
public class PM extends Applet implements KeyListener{
Image img;
Rectangle2D road,car;
int tx,ty;
public void init(){
img=createImage(getWidth(),getHeight()*3);
road=new Rectangle2D.Float(100,1,getWidth()-200,(getHeight()*3)-2);
car=new Rectangle2D.Float((int)(road.getX()+(road.getWidth()/2)-20),getHeight()-100,40,40);
tx=0;
ty=img.getHeight(this)-getHeight();
addKeyListener(this);
}
public void paint(Graphics g1){
setSize(800,600);
Graphics2D g=(Graphics2D)g1;
Graphics2D ig=(Graphics2D)img.getGraphics();
ig.fillRect(0,0,img.getWidth(this),img.getHeight(this));
ig.setColor(Color.gray);
ig.fillRect((int)road.getX(),(int)road.getY(),(int)road.getWidth(),(int)road.getHeight());
ig.setColor(Color.white);
for(int i=1;i<img.getHeight(this);i+=50){
ig.drawLine(0,i,getWidth(),i);
}
car=new Rectangle2D.Float((int)(road.getX()+(road.getWidth()/2)-20),ty+100,40,40);
ig.draw(car);
g.drawImage(img,0,0,getWidth()-2,getHeight()-2,tx,ty,(tx+getWidth())-((tx+getWidth())%img.getWidth(this)),(ty+getHeight()),this);
}
public void keyPressed(KeyEvent e){}
public void keyReleased(KeyEvent e){}
public void keyTyped(KeyEvent e){
char ch=e.getKeyChar();
switch(ch){
case 'w':
if(ty>=2&&img.getHeight(this)>getHeight())ty-=2;
break;
case 'z':
if(ty<=img.getHeight(this)-getHeight())ty+=2;
}
paint(getGraphics());
}	
}