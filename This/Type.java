import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class Type extends Applet implements KeyListener,MouseListener,Runnable{
String str;
String input;
int typed;
int sec;
boolean end;
int index;
Thread t;
boolean rng;
public void init(){
str="This is the sentence to be typed.";
input="";
typed=0;
index=0;
sec=0;
end=true;
rng=false;
t=new Thread(this);
addKeyListener(this);
addMouseListener(this);
t.start();}
public void keyTyped(KeyEvent e){
char ch=e.getKeyChar();
if(ch=='*'){printEnd(getGraphics());end=true;
return;}
if(index<str.length()){if(ch==str.charAt(index)){input=input+str.charAt(index);index++;}
}typed++;
chkEnd();
}

public void printEnd(Graphics g){
double spd=(str.length()*60)/sec;
double acc=100-(typed/str.length());
g.drawString("Speed : "+spd+"cpm",50,150);
g.drawString("Accuracy : "+acc,50,180);
}
public void chkEnd(){
if(index==str.length()){
printEnd(getGraphics());
end=true;
}
}
public void keyPressed(KeyEvent e){}
public void keyReleased(KeyEvent e){}
public void mouseEntered(MouseEvent e){}
public void mouseExited(MouseEvent e){}
public void mouseClicked(MouseEvent e){
if(end){end=false;}
}
public void mousePressed(MouseEvent e){}
public void mouseReleased(MouseEvent e){}
public void run(){
while(rng){
if(!end)sec++;
Graphics g=getGraphics();
g.drawString(str,50,50);
g.setColor(Color.red);
g.drawString(input,50,100);
g.drawString(""+sec,50,250);
try{t.sleep(1000);}
catch(Exception e){}
}
}
}