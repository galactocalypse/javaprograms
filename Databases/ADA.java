import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.awt.geom.*;
public class ADA extends Applet{
public void init(){
setSize(800,400);
}
public void paint(Graphics g){
for(int i=0;i<20;i++){
if(i<10)
g.setColor(new Color((i*12),i*12,i*12));
else g.setColor(new Color((((i-10)*12)),((i-10)*12),((i-10)*12)));
g.fillRect(i,i,getWidth()-(2*i),getHeight()-(2*i));
}
}
}