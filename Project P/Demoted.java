import java.awt.*;
import java.applet.*;
public class Demoted extends Applet{
public void paint(Graphics g1){
int x=10,y=100,g=0,f=0,h=0,c=2,a=1,b=1;
for(x=100;x<getWidth();x++){
y=(int)(-((2*h*x)+(2*f))+Math.pow(Math.pow(((2*h*x)+(2*f)),2)-(4*b*(c+(2*g*x)+(a*x*x))),0.5));
g1.drawRect(x,y,1,1);
}
}
}