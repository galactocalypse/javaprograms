import java.applet.*;
import java.awt.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;
import java.awt.geom.*;
public class Anim extends Applet implements Runnable,MouseListener{
static Image bg=null;
 int size=15;
 Color col=Color.black;
 Font f=new Font("Georgia",Font.ITALIC,size);
 int y;
 Color colSet[]=new Color[50];
 int spcg=5;
 File file;
 int speed=1;
 Point2D p;
 Rectangle2D area;
 boolean running=true;
 Thread t;
 String str[];
 boolean runIt=true;
public void init(){
file=new File("lines.txt");
int nol=0;
try{
DataInputStream in=new DataInputStream(new FileInputStream(file));
String string="";
while((string=in.readLine())!=null){
nol++;
}
in.close();
str=new String[nol];
in=new DataInputStream(new FileInputStream(file));
nol=0;
while((str[nol]=in.readLine())!=null){
nol++;
}
in.close();
in=null;
}
catch(Exception e){}
for(int i=0;i<colSet.length;i++){
colSet[i]=new Color(100+(int)(Math.random()*150),100+(int)(Math.random()*150),100+(int)(Math.random()*150));
}
y=getHeight();
area=new Rectangle2D.Float(0,0,getWidth(),getHeight());
p=new Point2D.Float(getWidth()+10,getHeight()+10);;
try{
bg=ImageIO.read(new File("0.jpg"));
}
catch(Exception e){}
t=new Thread(this);
addMouseListener(this);
t.start();
}
public void paint(Graphics g){
if(bg!=null){g.drawImage(bg,0,0,getWidth(),getHeight(),this);
}
g.setColor(col);

g.setFont(f);
for(int i=0;i<str.length;i++){
if((y+(i*(size+spcg)))<getHeight()+size)
g.drawString(str[i],(int)((getWidth()/2)-((str[i].length()/2.0)*0.6*(float)size)),y+(i*(size+spcg)));
}
}
public void run(){
while(running){
if(runIt){
y-=speed;
}
if(y<=-(str.length*(spcg+size))+5)y=getHeight()+size;
Graphics g=getGraphics();
Image img=createImage(getWidth(),getHeight());
Graphics g1=img.getGraphics();
paint(g1);
g.drawImage(img,0,0,this);
try{t.sleep(100);
}
catch(Exception e){}
}}
public void destroy(){
t=null;
running=false;
}
public void mouseEntered(MouseEvent e){
runIt=false;}
public void mouseExited(MouseEvent e){
runIt=true;
}
public void mousePressed(MouseEvent e){p=new Point2D.Float(e.getX(),e.getY());}
public void mouseReleased(MouseEvent e){p=new Point2D.Float(e.getX(),e.getY());}
public void mouseClicked(MouseEvent e){col=colSet[y%colSet.length];}
}