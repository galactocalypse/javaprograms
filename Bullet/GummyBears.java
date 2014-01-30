import java.awt.*;import java.applet.*;
public class GummyBears extends Applet{
public void init(){

}
public void paint(Graphics g){
Font f=new Font("",Font.BOLD,20);
FontMetrics fm=g.getFontMetrics(f);
g.setFont(f);
g.drawString("This is baking!",100,100);
}
}