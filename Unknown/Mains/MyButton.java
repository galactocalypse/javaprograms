package Mains;

import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class MyButton extends Applet implements MouseListener {
int ht=30,wd=100,x=0,y=0;
Color c=Color.darkGray.brighter();
boolean state=false;
String buttonName="         Button";
Color fc=Color.yellow;
Color temp=c;
public void init(){
addMouseListener(this);
}
public void paint(Graphics g){
g.setColor(temp);
g.fill3DRect(x,y,wd,ht,true);

g.setColor(fc);
g.drawString(buttonName,x,y+(ht-g.getFont().getSize()));
}
public void setLocation(int x1,int y1,int wd1,int ht1){
x=x1;
y=y1;
wd=wd1;
ht=ht1;
}
public void setBg(Color cd){
temp=c=cd;
repaint();
}
public void setFg(Color cd){
fc=cd;
repaint();
}
public void mousePressed(MouseEvent e){
int mx,my;
mx=e.getX();
my=e.getY();
if(mx>x&&my>y&&mx<x+wd&&my<y+ht){
temp=c.darker();
repaint();
}
}
public void mouseClicked(MouseEvent e){
int mx,my;
mx=e.getX();
my=e.getY();
if(mx>x&&my>y&&mx<x+wd&&my<y+ht){
state=true;
}
}
public String getCommand(){
return buttonName;
}
public void setCommand(String s){
buttonName=s;
repaint();
}
public void mouseReleased(MouseEvent e){
int mx,my;
mx=e.getX();
my=e.getY();
if(mx>x&&my>y&&mx<x+wd&&my<y+ht){
temp=c;
repaint();
}
state=false;
}
public void mouseExited(MouseEvent e){}
public void mouseEntered(MouseEvent e){}
}