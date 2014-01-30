import java.awt.*;
import java.applet.*;
public class Frog extends Applet{
Button fd;
public void init(){
//setBackground(Color.blue);
}
public void paint(Graphics g){

for(int i=0;i<50;i++){
g.setColor(new Color((int)(i*255/100),(int)(i*255/100),(int)(i*255/100)));
g.drawLine(i,i,i,100-i);
g.drawLine(99-i,i,99-i,100-i);
}

}
}