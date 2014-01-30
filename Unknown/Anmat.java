import java.awt.*;
import java.applet.*;
public class Anmat extends Applet implements Runnable{
int noc,dev;
Thread t;
int dir;
boolean rng;
public void init(){
dir=0;noc=80;dev=2;
rng=true;
t=new Thread(this);
t.start();
}
public void paint(Graphics g){
int x=50,y=50,r=300;
for(int i=0;i<noc;i+=1){
for(int j=0;j<360-(9*noc);j+=4){
g.setColor(new Color(255-noc,0,0)); 
g.drawArc(x+(i*2),y+(i*2),r-(4*i),r-(4*i),j+dev+i,2);
if(j%3==0){
g.drawArc(x+1+(i*2),y+1+(i*2),r-(4*i)-2,r-(4*i)-2,j-i-dev,2);
g.drawArc(x+1+(i*2),y+1+(i*2),r-(4*i)-2,r-(4*i)-2,j+i+dev,2);

}
}
}
}
public void run(){
while(rng){
dev=(++dev)%3;
if(noc==39)dir=1-dir;
noc=(++noc)%40;
Image img=createImage(getWidth(),getHeight());
paint(img.getGraphics());
getGraphics().drawImage(img,0,0,this);
try{t.sleep(100);}
catch(Exception e){}
}
}
public void destroy(){
rng=false;t=null;
}
}