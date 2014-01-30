import java.awt.*;
import java.applet.*;
public class A5 extends Applet implements Runnable{
Thread t;
boolean rng;
int x;
public void init(){
x=0;
rng=true;
t=new Thread(this);
t.start();
}
public void paint(Graphics g){
for(int i=0;i<10;i++){
if(x>=5)
g.drawArc(50,(25-x)*i,50,50-(2*x),32,300);
else g.drawArc(50,(25-10+x)*i,50,50-(2*(10-x)),32,300);

}
}
public void run(){
while(rng){
x=(++x)%10;
Image img=createImage(getWidth(),getHeight());
paint(img.getGraphics());
getGraphics().drawImage(img,0,0,this);
try{t.sleep(100);
}
catch(Exception e){}
}
}
public void destroy(){
rng=false;
t=null;
}
}