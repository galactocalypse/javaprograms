import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
public class FrameDemo extends Applet implements ActionListener{
Button b;
TextField tf;
TextArea ta;
Checkbox cb1,cb2;
CheckboxGroup cbg;
List l;

public void init(){
b=new Button("DemoButton");
tf=new TextField();
ta=new TextArea();
cbg=new CheckboxGroup();
cb1=new Checkbox("CB1",cbg,false);
cb2=new Checkbox("CB2",cbg,false);
l=new List();

setSize(500,500);
setLayout(null);

b.addActionListener(this);
b.setBounds(20,100,100,30);
ta.setBounds(20,150,100,100);
tf.setBounds(20,70,100,28);
cb1.setBounds(200,200,50,20);
cb2.setBounds(200,100,50,20);
l.setBounds(20,300,100,50);


add(b);
add(cb1);
add(cb2);
add(l);
add(ta);
add(tf);
}
public void paint(Graphics g){
g.drawRect(10,10,100,100);
}
public void actionPerformed(ActionEvent e){
String s=tf.getText();
tf.setText("");
l.addItem(s);
}
}