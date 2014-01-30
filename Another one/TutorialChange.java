import java.awt.*;
import java.applet.*;
import java.awt.geom.*;
import java.awt.event.*;

public class TutorialChange extends Applet implements ActionListener{
TextField txt=new TextField();
Button b=new Button("Go!");
int n;
Rectangle2D rect;
int ix,iy;
public void init(){
setSize(550,200);
setLayout(null);
setBackground(Color.white);
txt.setBounds(getWidth()-120,60,100,20);
b.setBounds(getWidth()-120,100,100,20);
add(txt);
add(b);
n=3;
ix=220;
iy=20;
}
public void paint(Graphics g1){
Graphics2D g=(Graphics2D)g1;
g.setColor(Color.red);
g.fillRect(0,0,getWidth(),getHeight());
for(int i=0;i<=255;i++){
g.setColor(new Color(i,0,0));
g.drawLine(i,0,i,getHeight());
g.drawLine(getWidth()-i,0,getWidth()-i,getHeight());
}
g.clearRect(10,10,380,180);
int x=ix,y=iy;
Thread t=new Thread();
g.setColor(Color.black);
for(int i=1;i<=n;i++){
x=ix-(i*15);
y=y+15;if(rect!=null)
g.clearRect((int)rect.getX(),(int)rect.getY()-3,(int)rect.getWidth()-19,(int)rect.getHeight()+6);
g.setColor(Color.black);
rect=new Rectangle2D.Float(ix+(i*15)-80,y-10,120,15);
for(int j=1;j<=i;j++){
g.clearRect((int)rect.getX(),(int)rect.getY()-3,(int)rect.getWidth()-19,(int)rect.getHeight()+6);
g.setColor(Color.black);
g.drawString(""+i,x+(j*30)-100,y);
g.draw(new Rectangle2D.Float((int)(rect.getX()+20),(int)(rect.getY()),(int)(rect.getWidth()-40),(int)(rect.getHeight())));
int x1[]={(int)rect.getX(),(int)rect.getX()+20,(int)rect.getX()+20};
int y1[]={(int)rect.getY()+(int)(rect.getHeight()/2),(int)(rect.getY())-3,(int)(rect.getY()+rect.getHeight()+3)};

g.drawPolygon(x1,y1,3);
g.drawString("i = "+i+"  ;  j = "+j,15+(int)rect.getX()+10,(int)rect.getY()+(int)rect.getHeight()-2);
try{
t.sleep(500);
}
catch(Exception e){}
}
}
t.destroy();
}
public void actionPerformed(ActionEvent e){
String str=e.getActionCommand();
if(str.equalsIgnoreCase("Go!")){
try{
int x=(int)Math.ceil(Double.parseDouble(txt.getText()));
if(x>=1&&x<10)n=x;
}
catch(Exception e1){}
repaint();
}
}
}