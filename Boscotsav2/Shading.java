import java.awt.*;
import java.applet.*;
public class Shading extends Applet{
public void init(){}

public void paint(Graphics g){
/**
 * title
for(int i=0;i<800;i++){
g.setColor(new Color(i/5,i/5,i/5));
g.drawRect(i,0,2,200);
*/
//back
for(int i=0;i<50;i++){
g.setColor(new Color(200+i,200+i,200+i));
g.fillRect(0,i,getWidth(),getHeight()-(2*i));
}
}
}