import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class Waves extends Applet{
public void init(){}
public void paint(Graphics g){
int width=20;
for(float i=1;i<360;i+=0.5){
g.drawLine(100+(int)i,100+(int)(Math.sin(i*Math.PI/180)*50),100+(int)(i-1),100+(int)(Math.sin((i-1)*Math.PI/180)*50));
}
}
}