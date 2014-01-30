import java.awt.*;
public class Diver{
public void box(Graphics g,int x,int y,int w,int h,int dir){
for(int i=x;i<x+w;i++){
if(dir==0)g.setColor(new Color((int)((i-x)*255/w),(int)((i-x)*255/w),(int)((i-x)*255/w)));
else g.setColor(new Color(255-(int)((i-x)*255/w),255-(int)((i-x)*255/w),255-(int)((i-x)*255/w)));
g.drawLine(i,y,i,y+h);
}
}
public void box2(Graphics g,int x,int y,int w,int h){
g.draw3DRect(x,y,w,h,true);
}
}