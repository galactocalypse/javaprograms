import java.awt.*;
import java.util.*;
import java.applet.*;
public class DigitalClock extends Applet implements Runnable{
Thread t;
Date date;
boolean running=true;
String time="00:00:00";
TextField text;

public void init(){
setSize(132,60);
setLayout(null);
setFont(new Font("Georgia",Font.BOLD,30));
setBackground(Color.yellow);
text=new TextField();
text.setBackground(Color.yellow);
text.setEditable(false);
text.setBounds(2,2,130,88);
add(text);
t=new Thread(this);
t.start();
}

public void run(){
while(running){
date=new Date();
time = date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();
text.setText(time);
try{
t.sleep(500);
}
catch(InterruptedException e){
System.out.println(e);
}
}
}
public void destroy(){
running=false;
t=null;
}
}