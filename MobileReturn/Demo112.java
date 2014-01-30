import java.awt.*;
import java.applet.*;
public class Demo112 extends Applet{
RoadMap rp;
public void paint(Graphics g){
rp=new RoadMap();
Image img=createImage(200,200);
Graphics g1=img.getGraphics();
g1.drawString("There's everything in here!",20,20);
g.drawImage(rp.rotImg(img),0,10,this);
}
}