import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class Type extends Applet implements KeyListener,Runnable{
String str;

Thread t;
boolean rng;double time;
String input;
int index;
int typed;
boolean o;
public void init(){
rng=true;
str="This is a fine day!";
input="";
typed=0;time=0;index=0;o=false;
t=new Thread(this);
addKeyListener(this);
t.start();
}
public void paint(Graphics g){
g.drawString(str,50,100);
g.setColor(Color.red);
g.drawString(input,50,150);

if(o==true){
double speed=str.length()/(time/60000);
double acc=100-((typed-str.length())/str.length());
g.drawString("Speed : "+speed+" cpm",50,200);
g.drawString("Accuracy : "+acc+"%",50,220);
}
}
public void keyTyped(KeyEvent e){
typed++;
if(e.getKeyChar()=='*')o=true;
else if(str.charAt(index)==e.getKeyChar()){input=input+str.charAt(index);index++;}
over();
}
public void keyPressed(KeyEvent e){}
public void keyReleased(KeyEvent e){}
void over(){
if(o==true){
removeKeyListener(this);
}
}
public void run(){
while(rng){
repaint();
time=time+500;
try{t.sleep(500);}
catch(Exception e){}
}
}
}