import java.awt.*;
import java.applet.*;
public class ScrollText extends Applet implements Runnable{
String str;
int x,y;
Thread t;
boolean rng;

public void init(){
t=new Thread(this);
str="Rijubrata : the man who does it all!!!";
rng=true;
x=248;
y=0;
t.start();
}

public void paint(Graphics g){
for(int i=0;i<str.length();i++){
g.drawString(""+str.charAt(i),x,(y+(i*15))%getHeight());
}
}
public void run(){
while(rng){
y=(y+1)%getHeight();
repaint();
try{t.sleep(50);
}
catch(Exception e){}
}
}
}