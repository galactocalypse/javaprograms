import java.awt.*;
import java.applet.*;
public class Demon extends Applet implements Runnable{
Thread t;
boolean rng;
int ox=250,oy=250,ia;
String str;
int dist1=100;
public void init(){
str="Adarsh Yagnik";ia=0;
t=new Thread(this);
rng=true;
t.start();
}
public void paint(Graphics g){
g.setFont(new Font("Georgia",Font.BOLD,15));
ia=ia+(int)(10*Math.pow(-1,(int)(Math.random()*10)));
for(int i=0;i<str.length();i++){
g.setColor(new Color((int)(i*255*Math.random()/str.length()),(int)(i*255*Math.random()/str.length()),(int)(i*255*Math.random()/str.length())));
double angle=(ia+(i*360/str.length()))*Math.PI/180;
int dist=dist1-(int)(10*Math.random());
int x=(int)(ox+(Math.cos(angle)*dist));
int y=(int)(oy+(Math.sin(angle)*dist));
g.drawString(""+str.charAt(i),x,y);
}
}
public void run(){
while(rng){
ox=oy=(int)(ox-((int)(3*Math.random())*Math.pow(-1,(int)(Math.random()*10))));
dist1=(int)(dist1-((int)(3*Math.random())*Math.pow(-1,(int)(Math.random()*10))));
ia=(ia+1)%360;
//str=str.substring(1,str.length())+str.charAt(0);
repaint();
try{
t.sleep((int)(200*Math.random()));
}
catch(Exception e){}
}
}
}