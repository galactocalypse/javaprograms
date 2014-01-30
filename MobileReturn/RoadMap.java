import java.awt.*;
import java.awt.image.*;
import java.applet.*;
public class RoadMap{
public Image getRoadMap(int length){
Image img=new Applet().createImage(length+200,400);
Graphics g=img.getGraphics();
return img;
}
public Image rotImg(Image img){
int x=(img.getWidth(new Applet())<img.getHeight(new Applet()))?img.getHeight(new Applet()):img.getWidth(new Applet());
Image i=new Applet().createImage(x,x);
Image i2=i;
Graphics g=i.getGraphics();
Graphics h=i2.getGraphics();
g.drawImage(img,0,0,new Applet());
for(int k=0;k<i.getWidth(new Applet());k++){
for(int j=0;j<i.getHeight(new Applet());j++){
h.drawImage(i,k,j,k+1,j+1,j,k,j+1,k+1,new Applet());
}
}
return i2;
}
}