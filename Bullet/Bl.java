import java.awt.*;
import java.applet.*;
public class Bl extends Applet{
public void init(){}
public void paint(Graphics g){
//apply it as you like
paintBox(g,0,0,500,500);
}
public void paintBox(Graphics g,int x,int y,int width, int height){
for(int i=0;i<height;i++){
g.setColor(new Color(255,(int)(i*255/(height-1)),(int)(i*255/(height-1))));
g.drawLine(x,y+i,x+width,y+i);
}
}
}