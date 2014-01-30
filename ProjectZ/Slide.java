import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class Slide extends Frame implements MouseMotionListener,WindowListener{
Slide(){
addWindowListener(this);
setSize(500,500);
setVisible(true);
toFront();
}
public void mouseMoved(MouseEvent e){}
public void mouseDragged(MouseEvent e){}
public void windowOpened(WindowEvent e){}
public void windowIconified(WindowEvent e){}
public void windowDeiconified(WindowEvent e){}
public void windowDeactivated(WindowEvent e){
toFront();
}
public void windowClosing(WindowEvent e){
dispose();
System.exit(0);
}
public void windowClosed(WindowEvent e){}
public void windowActivated(WindowEvent e){}
}