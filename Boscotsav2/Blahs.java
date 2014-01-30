import java.awt.*;
import java.applet.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;
import java.awt.geom.*;
public class Blahs extends Applet{
Image img;
public void init(){

}
public void paint(Graphics g1){
Graphics2D g=(Graphics2D)g1;
try{
img=ImageIO.read(new File("imageme.jpg"));
    }
    catch(Exception e){}
    
    TexturePaint tp=new TexturePaint((BufferedImage)img, new Rectangle2D.Float(0,0,50,50));
    g.setPaint(tp);
    g.setFont(new Font("Micromieps",Font.BOLD,100));
    g.drawString("Openlabs",20,200);
}
}