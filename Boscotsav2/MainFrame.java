import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MainFrame extends JFrame implements Runnable,ActionListener,MouseMotionListener,MouseListener{
Thread t;
boolean running=true;
Color a=Color.black;
MainFrame(String s,int w,int h){
new JFrame(s);
setBounds(0,2,w,h);
setResizable(false);
initIt();
getContentPane().setLayout(null);
addMouseMotionListener(this);
addMouseListener(this);
t=new Thread(this);
}
public void showIt(){
if(t==null)t=new Thread(this);
t.start();
setVisible(true);
}
public void destroy(){
t=null;
running=false;
}
public void initIt(){}
public void paint(Graphics g){
g.setColor(a);
g.fillRect(0,0,100,100);
}
public void toRun(){
if(a==Color.red)a=Color.black;
repaint();}
public void run(){
while(running){
toRun();
try{t.sleep(100);}catch(Exception e){}
}
}
public static void main(String args[]){
MainFrame fr=new MainFrame("Demo",500,500);
fr.showIt();
}
public void actionPerformed(ActionEvent e){}
public void mouseMoved(MouseEvent e){}
public void mouseDragged(MouseEvent e){}
public void mouseEntered(MouseEvent e){}
public void mouseExited(MouseEvent e){}
public void mousePressed(MouseEvent e){}
public void mouseReleased(MouseEvent e){}
public void mouseClicked(MouseEvent e){if(a==Color.red||a==Color.black)a=Color.yellow;else a=Color.green;}
}