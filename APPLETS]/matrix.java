import java.awt.*;
import java.applet.*;
public class matrix extends Applet implements Runnable{
int x=100,y=00,max=500,j=0,i=0;
String msg="RIJUBRATA",s;
char ch;

boolean stopflag;
Thread t;
public void init(){}
public void start(){
t=new Thread(this);
stopflag=false;
s="";
t.start();
}
public void run(){
try{
Thread.sleep(50);
for(;;){
y=(y+1)%max;
ch=msg.charAt(j);
s=s+ch;
if(j==8){
j=0;
}
j++;
i++;
if(y==(max)){
y=00;
}
if(stopflag==true){
break;
}
repaint();
}
}
catch(InterruptedException e){}
}

public void stop(){
t=null;
stopflag=true;
}

public void paint(Graphics g){
int k;
for(i=0;i<s.length();i++){
g.drawString(""+msg.charAt(i),x,(y+(i*15))%max);
}
}
}