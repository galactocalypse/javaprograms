import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.awt.geom.*;
public class Demon extends Applet implements MouseMotionListener,MouseListener{
Rectangle2D rect;
Arc2D arc;
public void init(){
rect=new Rectangle2D.Float(100,100,100,100);
arc=new Arc2D.Double(200,200,100,100,45,75,1);
addMouseMotionListener(this);
addMouseListener(this);
}

public void paint(Graphics g1){
Graphics2D g=(Graphics2D)g1;
g.setColor(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
g.draw(rect);
g.draw(arc);
}
public void mousePressed(MouseEvent e){}
public void mouseClicked(MouseEvent e){
repaint();
}
public void mouseMoved(MouseEvent e){}
public void mouseEntered(MouseEvent e){}
public void mouseExited(MouseEvent e){}
public void mouseDragged(MouseEvent e){
if(rect.contains(new Point2D.Float(e.getX(),e.getY())))
rect=new Rectangle2D.Float(e.getX()-25,e.getY()-25,100,100);
repaint();
}
public void mouseReleased(MouseEvent e){}

}