import java.awt.*;
import java.applet.*;
public class Treeless extends Applet{
Diver d;
public void init(){
d=new Diver();
}
public void paint(Graphics g){
d.box(g,10,10,20,20,1);
d.box2(g,100,100,20,20);
}
}