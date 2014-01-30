import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.applet.*;
public class Dermotugsd extends Applet {
public void init(){
}
public void paint(Graphics g1){
Graphics2D g=(Graphics2D)g1;
Image img=createImage(getWidth(),getHeight());
Graphics h=img.getGraphics();
paintBg(h);


TexturePaint tp=new TexturePaint((BufferedImage)img,new Rectangle2D.Float(0,0,250,250));

g.setFont(new Font("Harlow Solid Italic",Font.BOLD,200));

for(int i=0;i<30;i++){
g.setColor(new Color(255-(i*8),255-(i*8),255-(i*8)));
g.drawString("May Day",8+30-i,398+30-i);
}
g.setPaint(tp);
g.drawString("May Day",10,400);
//g.fillRect(100,100,300,200);
}
public void paintBg(Graphics g){
//g.fillRect(0,0,getWidth(),getHeight());
int block=30,dpt=10,size=block-(dpt/2),lim=255,flag=0;
for(int i=0;i<getWidth();i+=block){
for(int j=10;j<getHeight();j+=block){
int xy=(int)(Math.random()*10);
if(xy%2==0||xy%3==0)
draw3DR(g,i,j,size,size,dpt,lim,flag);
}
}
}
public void draw3DR(Graphics g,int x,int y,int w,int h,int dpt,int l,int flag){
int lim=l;
for(int i=0;i<dpt;i++){
/*if(flag==1)g.setColor(new Color(i*lim/dpt,50,20));    
else g.setColor(new Color(255-(i*lim/dpt),50,20));    
*/
if(flag==1)g.setColor(new Color(i*lim/dpt,i*lim/dpt,i*lim/dpt));    
else g.setColor(new Color(255-(i*lim/dpt),255-(i*lim/dpt),255-(i*lim/dpt)));    

g.fillRect(x+i,y+i,w,h);
}
}
}