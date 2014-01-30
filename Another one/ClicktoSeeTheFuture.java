import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class ClicktoSeeTheFuture extends Applet implements MouseListener, MouseMotionListener
    {
        String msg=" ";
        int mousex=0;
        int mousey=0;
        int newx=0;
        int newy=0;
        
        public void init()
        {
            addMouseListener(this);
            addMouseMotionListener(this);
        }
        public void mouseClicked(MouseEvent me)
        {
            mousex=me.getX();
            mousey=me.getY();
            msg="u cudn't";
             if(mousex>=newx&mousex<=newx+20&mousey>=newy&mousey<=newy+20)
            repaint();
            
        }
        public void mouseEntered(MouseEvent me)
        {
        }
        public void mouseExited(MouseEvent me)
        {
            
        }
        public void mousePressed(MouseEvent me)
        {
           
        }
        public void mouseReleased(MouseEvent me)
        {
            
        }
        public void mouseDragged(MouseEvent me)
        {
          
        }
        public void mouseMoved(MouseEvent me)
        {
            msg="u cudn't";
            mousex=me.getX();
            mousey=me.getY();
            showStatus("Mouse moved at "+mousex+", "+mousey);
            if(mousex>=newx&mousex<=newx+20&mousey>=newy&mousey<=newy+20)
            repaint();
        }
        public void paint(Graphics g)
        {
             newx=(int)(Math.random()*getWidth());
             newy=(int)(Math.random()*getHeight());            
             
            g.drawString("Click on the Rectangle 2 see ur future",newx,newy );
            g.drawString(msg, mousex, mousey);
            g.setColor(Color.cyan);
            g.fillRect(newx,newy,20,20);
        }
    }
