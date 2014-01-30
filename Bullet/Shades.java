import java.awt.*;
import java.applet.*;
import java.awt.geom.*;
public class Shades extends Applet{
public void drawBox(Graphics g, int x,int y, int width, int height){
for(int i=1;i<=height;i++){
g.setColor(new Color((int)((255*i)/height),0,0));
g.drawLine(x,i+y,x+width,i+y);
}
}
public void paint(Graphics g){
for(int i=0;i<getWidth();i+=20){
for(int j=0;j<getHeight();j+=20){
drawBox(g,i,j,15,15);
}
}
}
}