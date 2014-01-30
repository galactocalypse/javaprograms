import java.awt.*;
import java.awt.image.*;
import java.applet.*;
import java.awt.geom.*;
import java.awt.event.*;
public class Dermo54t extends Applet implements Runnable{
Thread t;
boolean rng;

public void init(){
setBackground(Color.black);
t=new Thread(this);
rng=true;
t.start();
}
public void paint(Graphics g1){
Graphics2D g=(Graphics2D)g1;
for(int i=0;i<=getWidth()/2;i++){
g.setColor(new Color(i*200/getWidth(),i*200/getWidth(),i*200/getWidth()));
//g.drawLine(i,0,i,getHeight());
//g.drawLine(getWidth()-i,0,getWidth()-i,getHeight());
}

int col=250;
Image img=createImage(getWidth(),getHeight());
Graphics p=img.getGraphics();
//p.fillRect(0,0,getWidth(),getHeight());
for(int i=0;i<getWidth();i+=4){
for(int j=0;j<getHeight();j+=4){
p.setColor(new Color((i+j)*col/((getWidth()+getHeight())),(i+j)*col/((getWidth()+getHeight())),(i+j)*col/((getWidth()+getHeight()))));
if((int)(Math.random()*10)%2==0||(int)(Math.random()*10)%5==0||(int)(Math.random()*10)%3==0)
p.fillRect(i,j,3,3);
}
}


TexturePaint text=new TexturePaint((BufferedImage)img,new Rectangle(0,0,getWidth(),getHeight()));

g.setFont(new Font("Xenotron",Font.BOLD,130));
FontMetrics m=g.getFontMetrics(new Font("Xenotron",Font.BOLD,130));
for(int i=0;i<15;i++){
g.setColor(new Color((i*10),(i*10),(10*i)));
if(i==14){g.setColor(Color.darkGray);i=16;}
//g.drawString("ADARSH",15-i+((getWidth()-m.stringWidth("ADARSH"))/2),15-i+((getHeight()/2)));
}

g.setPaint(text);
g.drawString("WELCOME",(getWidth()-m.stringWidth("WELCOME"))/2,(getHeight()/2));
/**for(int i=0;i<getWidth();i+=6){
for(int j=0;j<getHeight();j+=6){
g.setColor(new Color((i+j)*255/((getWidth()+getHeight())),(i+j)*255/((getWidth()+getHeight())),(i+j)*255/((getWidth()+getHeight()))));
//g.setColor(Color.black);
if((int)(Math.random()*100)%5==0)
g.fillRect(i,j,4,4);
}
}
**/
}
public void run(){
while(rng){
Image img=createImage(getWidth(),getHeight());
paint(img.getGraphics());
getGraphics().drawImage(img,0,0,this);
try{t.sleep(100);}
catch(Exception e){}
}
}
}