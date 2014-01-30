import java.awt.*;
import java.applet.*;
public class dE extends Applet implements Runnable{
int k=0;
Image img;
boolean rng=true;
Thread t;
public void init(){
img=getImage(getCodeBase(),"image.jpg");
t=new Thread(this);
t.start();
}
public void paint(Graphics g){
g.drawImage(img,150,100,200,300,this);
int x=2,y=2;
if(k<100){
g.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));

for(x=2+k;x<getWidth()-4-k-1;x++){
g.drawRect(x,y+k,1,1);
}
g.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
for(y=2+k;y<getHeight()-4-k-1;y++){g.drawRect(x,y,1,1);
}
g.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
for(x=getWidth()-4-k-1;x>2+k;x--){g.drawRect(x,y,1,1);
}
g.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
for(y=getHeight()-4-k-1;y>2+k;y--){g.drawRect(x,y,1,1);
}
}
}
public void run(){
while(rng==true&&k<=100){
k+=2;
paint(getGraphics());
try{t.sleep(100);}
catch(Exception e){
}
}
System.exit(0);
}
}