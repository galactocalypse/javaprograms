import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Anim extends Applet implements Runnable,MouseListener {
int w=900,h=100,a=4;
Thread t;
boolean condition1=false;
boolean running=true;
public void init(){
setBackground(Color.white);
w=getWidth();
h=getHeight();
addMouseListener(this);
t=new Thread(this);
t.start();
}
public void paint(Graphics g1){
Image x=createImage(w,h);
Graphics g=x.getGraphics();
g.setFont(new Font("Xenotron",Font.PLAIN,100));
/**
g.setColor(Color.darkGray);
g.drawString("B",5+1,52-1);
g.drawString("B",5+1,52+1);
g.drawString("B",5-1,52-1);
g.drawString("B",5-1,52+1);
**/
int r1=0,gi=0,b1=0;
for(int i=0;i<h/a;i++){
for(int j=0;j<w/a;j++){
int red=0,green=0,blue=0;
if(condition1)
red=green=blue=(int)(Math.random()*255);
else {red+=((i+j)/2*(255*2/(w+h)*a));
green+=((i+j)/2*(255*2/(w+h)*a));
blue+=((i+j)/2*(255*2/(w+h)*a));
}
g.setColor(new Color(red,green,blue));
//(i+j)/2*(255*2/(h+w)*a),(i+j)/2*(255*2/(h+w)*a)));
int y=(int)(Math.random()*10);
if(y%2==0||y%5==0)
g.fillRect((j*a)-1,(i*a)-1,a-1,a-1);
}
}

g.setColor(new Color(0,0,0));
g.drawString("BOSCOTSAV",18,80);
g.setColor(new Color(255,255,255));
g.drawString("BOSCOTSAV",20,82);
g1.drawImage(x,0,0,this);
}
public void run(){
while(running){
paint(getGraphics());
try{
t.sleep(1000);
}
catch(Exception e){}
}
}
public void mousePressed(MouseEvent e){
condition1=!condition1;
}
public void mouseEntered(MouseEvent e){
running=false;
t=null;
}
public void mouseExited(MouseEvent e){
running=true;
t=new Thread(this);
t.start();
}
public void mouseReleased(MouseEvent e){}
public void mouseClicked(MouseEvent e){

}
public void destroy(){
t=null;
running=false;
}
}