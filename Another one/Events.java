import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class Events extends Applet implements ItemListener,ActionListener{
CheckboxGroup cbg;
Checkbox c1,c2,c3,c4;
Button b1,b2;
String msg;
public void init(){
cbg=new CheckboxGroup();
c1=new Checkbox("Science",false,cbg);
c2=new Checkbox("Commerce",false,cbg);
c3=new Checkbox("This");
c4=new Checkbox("That");
b1=new Button("Submit");
b2=new Button("Reset");
add(c1);
add(c2);
add(c3);
add(c4);
add(b1);
add(b2);
b1.addActionListener(this);
b2.addActionListener(this);
c1.addItemListener(this);
c2.addItemListener(this);
c3.addItemListener(this);
c4.addItemListener(this);
}
public void itemStateChanged(ItemEvent e){
showStatus(e.getItem().toString());
b1.setEnabled(true);
}
public void actionPerformed(ActionEvent e){
showStatus(e.getActionCommand());
if(e.getActionCommand().equalsIgnoreCase("Reset")){
c1.setState(false);
c2.setState(false);
c3.setState(false);
c4.setState(false);
b1.setEnabled(false);
}
}
}