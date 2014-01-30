import java.awt.*;
import java.applet.*;
public class Demonnaatt extends Applet{
public void init(){}
public void paint(Graphics g){
int x=10,y=10,m=2;
for(;x<getWidth()-20;x++){
y=m*x;
g.drawRect(x,y,1,1);
}
}
}