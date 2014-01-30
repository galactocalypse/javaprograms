import java.awt.*;
import java.applet.*;
public class Demoeee extends Applet{
public void init(){}
public void paint(Graphics g){
for(int i=0;i<255;i++){
g.setColor(new Color(i,i,i));
g.drawLine(0,2*i,getWidth(),2*i);
g.drawLine(0,(2*i)+1,getWidth(),(2*i)+1);
}
}
}