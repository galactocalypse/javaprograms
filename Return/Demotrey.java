import java.awt.*;
import java.applet.*;
import java.awt.geom.*;
import java.awt.event.*;
public class Demotrey extends Applet{
public void paint(Graphics g){
int x=0,y=0;
for(int i=0;i<50;i++){
x=x+y;
if(i%7==0)y++;
g.drawLine(0,i+x,220,i+x);
}
}
}