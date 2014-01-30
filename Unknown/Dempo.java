import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.applet.*;
import javax.imageio.*;
import javax.swing.*;
public class Dempo extends Applet{
AC a;
public void init(){
Image img=createImage(200,200);
Graphics g=img.getGraphics();
g.fillRect(0,0,150,50);
g.setColor(Color.red);
g.fillOval(40,20,100,100);
a=new AC(100,100,200,200,img);
}
public void paint(Graphics g){
a.paint(g,this);
}
}
