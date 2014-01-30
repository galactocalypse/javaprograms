import java.io.*;
import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Scroll extends Applet implements Runnable,MouseListener{
Thread t;
boolean rng;
int y;
Color fontColor;
int space=0;
Image img;
int fs=0;
String str[];
public void init(){
try{
str=getData();
img=getImage(getCodeBase(),"scrollimg.jpg");
}
catch(Exception e){System.err.println("Error with file I/O.");
}
y=getHeight();
fontColor=Color.black;
rng=true;
space=4;
fs=12;
addMouseListener(this);
t=new Thread(this);
t.start();
}
public void paint(Graphics g){
if(img!=null)g.drawImage(img,0,0,getWidth(),getHeight(),this);
if(y>getHeight())y=getHeight();
fs=g.getFont().getSize();
g.setColor(fontColor);
for(int i=0;i<str.length;i++)
g.drawString(str[i],(int)(getWidth()-(g.getFont().getSize()*0.5*str[i].length()))/2,y+(i*(g.getFont().getSize()+2)));
}
public void run(){
Image timg=createImage(getWidth(),getHeight());
Graphics tg=timg.getGraphics();
while(rng){y--;
if(y<=0-(str.length*(fs+2)))y=getHeight();
paint(tg);
getGraphics().drawImage(timg,0,0,this);
try{t.sleep(100);
}
catch(Exception e){}
}
}
public String[] getData(){
try{
DataInputStream in=new DataInputStream(new FileInputStream(new File("scrolltext.txt")));
String s="",ts="";
while((ts=in.readLine())!=null){
s=s+"/%/"+ts;
}
in.close();
return s.split("/%/");
}
catch(Exception e){}
return null;
}
public void mousePressed(MouseEvent e){}
public void mouseEntered(MouseEvent e){
rng=false;
}
public void mouseExited(MouseEvent e){rng=true;t=new Thread(this);t.start();}
public void mouseReleased(MouseEvent e){}
public void mouseClicked(MouseEvent e){}
public void destroy(){t=null;rng=false;}
}