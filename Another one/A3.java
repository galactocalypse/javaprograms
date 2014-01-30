import java.awt.*;
import java.applet.*;
public class A3 extends Applet{
public void init(){setBackground(Color.black);}
public void paint(Graphics g){
for(int i=0;i<getWidth();i+=10){
for(int j=0;j<getHeight();j+=10){
g.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
if((int)(Math.random()*100)%2==1)
g.draw3DRect(i+(int)(Math.random()*15),j+(int)(Math.random()*15),3+(int)(Math.random()*5),5,true);
else g.fill3DRect(i+(int)(Math.random()*15),j+(int)(Math.random()*15),5,3+(int)(Math.random()*5),false);
}
}
}
}