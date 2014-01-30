import java.awt.*;
import java.applet.*;
public class Der extends Applet{
Animated a;
public void paint(Graphics g){
a=new Animated(this,"BITWIZ",500,100,100);
g.drawImage(a.give(),0,0,this);
}
}