import java.awt.*;
import java.io.*;
import javax.imageio.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.applet.*;
public class G1 extends Applet implements KeyListener{
Image map,img;
int tx,ty;
Rectangle2D car;
public void init(){
tx=ty=0;
try{
map=ImageIO.read(new File("image0.jpg"));
}
catch(Exception e){map=null;
}
img=createImage(getWidth(),getHeight());
img.getGraphics().drawImage(map,0,0,getWidth(),getHeight(),tx,ty,(tx+getWidth())%map.getWidth(this),(ty+getHeight())%map.getHeight(this),this);

addKeyListener(this);
}
public void paint(Graphics g1){
Graphics2D g=(Graphics2D)g1;
}
public void keyPressed(KeyEvent e){}
public void keyReleased(KeyEvent e){}
public void keyTyped(KeyEvent e){
char ch=(""+e.getKeyChar()).toLowerCase().charAt(0);
switch(ch){
case 'w':
if(ty>=2&&map.getHeight(this)>getHeight())ty-=2;
break;
case 'a':
if(tx>=2&&map.getWidth(this)>getWidth())tx-=2;
break;
case 'd':
if(tx<=map.getWidth(this)-getWidth()-3)tx+=2;
break;
case 'z':
if(ty<=map.getHeight(this)-getHeight()-3)ty+=2;
}
removeKeyListener(this);
img=createImage(getWidth(),getHeight());
img.getGraphics().drawImage(map,0,0,getWidth(),getHeight(),tx,ty,(tx+getWidth())%map.getWidth(this),(ty+getHeight())%map.getHeight(this),this);
getGraphics().drawImage(img,0,0,this);
addKeyListener(this);
}
}