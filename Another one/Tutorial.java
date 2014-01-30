import java.awt.*;
import java.applet.*;
import java.awt.geom.*;
import java.awt.event.*;

public class Tutorial extends Applet implements ActionListener{
TextField txt=new TextField();
Button b=new Button("Go!");
int n;
Rectangle2D rect;
int ix,iy;
public void init(){
setSize(600,200);
setLayout(null);
setBackground(Color.yellow);
txt.setBounds(getWidth()-120,60,100,20);
b.setBounds(getWidth()-120,100,100,20);
b.addActionListener(this);
add(txt);
add(b);
n=3;
ix=200;
iy=20;
}
public void paint(Graphics g1){
Graphics2D g=(Graphics2D)g1;
int x=ix,y=iy;
Thread t=new Thread();
for(int i=1;i<=n;i++){
x=ix-(i*10);
y=y+10;if(rect!=null)
g.clearRect((int)rect.getX(),(int)rect.getY()-3,(int)rect.getWidth()+1,(int)rect.getHeight()+6);
g.setColor(Color.black);
rect=new Rectangle2D.Float(100+(i*10),y-10,120,15);
for(int j=0;j<i;j++){
g.clearRect((int)rect.getX(),(int)rect.getY()-3,(int)rect.getWidth()+1,(int)rect.getHeight()+6);
g.setColor(Color.black);
g.drawString(""+i,x+(j*20),y);
g.draw(new Rectangle2D.Float((int)(rect.getX()+20),(int)(rect.getY()),(int)(rect.getWidth()-40),(int)(rect.getHeight())));
int x1[]={(int)rect.getX(),(int)rect.getX()+20,(int)rect.getX()+20};
int y1[]={(int)rect.getY()+(int)(rect.getHeight()/2),(int)(rect.getY())-3,(int)(rect.getY()+rect.getHeight()+3)};
g.drawPolygon(x1,y1,3);
g.drawString("i = "+i+"  ;  j = "+j,15+(int)rect.getX()+10,(int)rect.getY()+(int)rect.getHeight()-2);
try{
t.sleep(500);
}
catch(Exception e){System.err.println("ERROR!");}
}
}
t.destroy();
}
public void actionPerformed(ActionEvent e){
if(e.getActionCommand().equalsIgnoreCase("Go!")){
try{
n=(int)Math.ceil(Double.parseDouble(txt.getText()));
repaint();
}
catch(Exception e1){}
}
}
}