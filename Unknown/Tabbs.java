import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.awt.geom.*;

public class Tabbs extends Applet implements MouseListener{
Rectangle2D rect[]=new Rectangle2D[4];
int sel=0;

public void init(){
for(int i=0;i<rect.length;i++){
rect[i]=new Rectangle2D.Float(5+(i*((getWidth()-10)/rect.length)),5,(getWidth()/rect.length)-5,30);
}
addMouseListener(this);
}
public void paint(Graphics g1){
Graphics2D g=(Graphics2D)g1;
for(int i=0;i<rect.length;i++){g.setColor(new Color(i*50,i*50,i*50));
g.fill(rect[i]);
}
g.setColor(new Color(50*sel,50*sel,50*sel));
g.fillRect(5,40,getWidth()-15,getHeight()-60);
}
public void mouseEntered(MouseEvent e){}
public void mouseExited(MouseEvent e){}
public void mousePressed(MouseEvent e){}
public void mouseReleased(MouseEvent e){}
public void mouseClicked(MouseEvent e){
Point2D p=new Point2D.Float((float)e.getX(),(float)e.getY());
for(int i=0;i<rect.length;i++){
if(rect[i].contains(p)){sel=i;repaint();break;}
}
}
}