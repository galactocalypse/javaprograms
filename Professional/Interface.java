import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class Interface extends Applet implements ActionListener{
TextField name,ph[],addline1,addline2,addline3,city,state,country,dob;
Button submit,reset,addno;
public void init(){
name=new TextField();
city=new TextField();
submit=new Button("Submit");
reset=new Button("Reset");
add(name);
add(city);
add
add(submit);
add(reset);
submit.addActionListener(this);
reset.addActionListener(this);
}
public void actionPerformed(ActionEvent e){}
}