import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Circum extends Applet implements ActionListener{
int n,dist;
int ox,oy;
TextField txt;
Button b;

public void init(){
txt=new TextField("3");
b=new Button("Go!");
b.addActionListener(this);
add(txt);
add(b);
n=3;
dist=100;
ox=getWidth()/2;
oy=getHeight()/2;
}
public void paint(Graphics g){
int x=0,y=0;
g.setColor(Color.lightGray);
g.drawOval(ox-dist,oy-dist,2*dist,2*dist);
for(int i=0;i<360;i+=(360/(n))){
g.setColor(Color.black);
g.drawString(""+i,10,50+(15*(i*n/360)));
x=(int)(ox+(Math.cos(Math.toRadians(i))*dist));
y=(int)(oy+(Math.sin(Math.toRadians(i))*dist));
g.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
g.drawLine(x,y,(int)(ox+(Math.cos(Math.toRadians(i+(360/(n))))*dist)),(int)(oy+(Math.sin(Math.toRadians(i+(360/(n))))*dist)));
}
}
public void actionPerformed(ActionEvent e){
try{
int z=(int)(Double.parseDouble(txt.getText()));
if(z<360)n=z;
repaint();
}
catch(Exception e1){}
}
}