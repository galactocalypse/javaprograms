import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;

public class FD implements ActionListener{
JFrame f;
JButton b;
Button cc;
public void showFrame(){
f=new JFrame("Classy");
f.setSize(400,300);
f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
cc=new Button("AKK");
b=new JButton("CLose");
b.setForeground(Color.white);
b.setBackground(Color.black);
b.setBounds(50,85,100,30);
b.addActionListener(this);
cc.setForeground(Color.white);
cc.setBackground(Color.black);
cc.setBounds(200,85,100,30);
cc.addActionListener(this);
f.getContentPane().setLayout(null);
f.getContentPane().add(b);
f.getContentPane().add(cc);
f.setVisible(true);
}
public void actionPerformed(ActionEvent e){
String str=e.getActionCommand();
if(str.equalsIgnoreCase("Close")){
b.setForeground(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
b.setBackground(new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255)));
}
else f.dispose();
}
public static void main(String args[]){
FD dd=new FD();
dd.showFrame();
}
}