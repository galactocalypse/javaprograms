import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.awt.geom.*;
public class HGHT extends Applet implements Runnable{
Color c[][];
Thread t;
int flag;
boolean rng;
public void init(){
setSize(600,600);
c=new Color[getWidth()/10][getHeight()/10];
for(int i=0;i<c.length;i++){
for(int j=0;j<c.length;j++){
c[i][j]=new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
}
}
flag=0;
t=new Thread(this);
rng=true;
t.start();
}
public void shift(){
Color temp=c[0][0];
for(int i=0;i<c.length;i++){
for(int j=0;j<c.length;j++){
if(i!=c.length-1&&j!=c.length){
if(j==c.length-1)
c[i][j]=c[i+1][j];
else c[i][j]=c[i][j+1];
}
}
}
c[c.length-1][c.length-1]=temp;
}
public void paint(Graphics g1){
Graphics2D g=(Graphics2D)g1;
for(int i=0;i<getWidth();i+=10){
for(int j=0;j<getHeight();j+=10){
g.setColor(c[i/10][j/10]);
g.drawRect(i+15*flag,j+15*flag,5,5);
}
}
}
public void run(){
while(rng){
Image img=createImage(getWidth(),getHeight());
paint(img.getGraphics());
getGraphics().drawImage(img,0,0,this);
shift();
if((int)(Math.random()*100)%10==3)flag=1-flag;
try{t.sleep(100);}
catch(Exception e){}
}
}
}