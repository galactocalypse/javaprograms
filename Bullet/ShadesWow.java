import java.awt.*;
import java.applet.*;
import java.awt.geom.*;
public class ShadesWow extends Applet{
public void drawBox(Graphics g,int x,int y,int w,int h, int size){
for(int k=size;k>=1;k--){
g.setColor(new Color((int)(k*255/size),(int)(k*255/size),(int)(k*255/size)));
g.drawRoundRect(x+k,y+k,w,h,w/4,h/4);
}
g.setColor(new Color(((int)((x*255/getHeight())+(y*255/getWidth()))/2),0,0));
g.fillRoundRect(x,y,w,h,w/4,h/4);
}
public void paint(Graphics g){
for(int i=0;i<getWidth();i+=20){
for(int j=0;j<getHeight();j+=20){
if((int)((Math.random()*100))%5!=0)
drawBox(g,i,j,15,15,5);
}
}
}
}