import java.awt.*;
import java.applet.*;
public class Demofttd extends Applet{
public void paint(Graphics g){
double x,y,a=150,b,e=0.7,deg;
b=Math.sqrt(a*a*(1-(e*e)));
for(deg=0;deg<360;deg++){
x=a*Math.cos(Math.toRadians(deg));
y=b*Math.sin(Math.toRadians(deg));
g.drawRect((int)x+200,(int)y+200,1,1);
}
}
}