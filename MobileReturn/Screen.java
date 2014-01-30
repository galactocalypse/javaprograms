import java.awt.*;
import java.applet.*;
import java.awt.geom.*;
import java.awt.event.*;
public class Screen extends Applet implements MouseMotionListener,MouseListener{
Rectangle2D rects[];
int sel;
public void init(){}
public void paint(Graphics g1){
Graphics2D g=(Graphics2D)g1;
for(int i=0;i<rects.length;i++){
if(i==sel)g.setColor(Color.black);
else g.setColor(Color.yellow);
g.fill(rects[i]);
}
}
public void mouseEntered(MouseEvent e){}
public void mouseExited(MouseEvent e){}
public void mousePressed(MouseEvent e){}
public void mouseReleased(MouseEvent e){}
public void mouseClicked(MouseEvent e){}
public void mouseDragged(MouseEvent e){}
public void mouseMoved(MouseEvent e){}

}