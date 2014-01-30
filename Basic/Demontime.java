import java.awt.*;
import java.applet.*;
import java.awt.event.*;
public class Demontime extends Applet{
public void paint(Graphics g1){
Graphics2D g=(Graphics2D)g1;
int size=20;
for(int i=0;i<getWidth()/size;i++){
for(int j=0;j<getHeight()/size;j++){
g.drawImage(getImg((2*j)%360,20),i*size,j*size,this);
}
}
}
public Image getImg(int angle,int size){
Image img=createImage(size,size);
Graphics2D d=(Graphics2D)img.getGraphics();
d.rotate(angle*Math.PI/180);
for(int i=0;i<size*2;i++){
d.setColor(new Color(i*125/size,i*125/size,i*125/size));
d.drawLine(i,0,i,size*2);
}
return img;
}

}