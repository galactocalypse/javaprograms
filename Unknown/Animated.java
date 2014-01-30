import java.awt.*;
import java.applet.*;
public class Animated{
int w=100;
int h=100;
String str="";
Container comp=null;
int f=0;
boolean flag=false;
Animated(Container c,String str,int width,int height,int fs){
w=width;
h=height;
this.str=str;
comp=c;
f=fs;
}
public Image give(){
Image img=comp.createImage(w,h);
Graphics g=img.getGraphics();

g.setFont(new Font("Xenotron",Font.BOLD,f));
if(flag==true){for(int i=0;i<w/3;i++){
for(int j=0;j<h/3;j++){
int x=(int)(Math.random()*240);
if(x+1%2==0||x%5==0){
g.setColor(new Color(x,x,x));
g.fillRect((i*3),(j*3),3,3);
}
}
}

}

g.setColor(new Color(30,30,30));
g.drawString(str,85+1,h-10+2);
g.drawString(str,85+2,h-10-1);
g.setColor(Color.black);
g.drawString(str,85,h-10);
return img;
}
Image ret(){
Image img=comp.createImage(w,h);
Graphics g=img.getGraphics();
g.setFont(new Font("Xenotron",Font.BOLD,f));
if(flag)
g.setColor(new Color(50,50,50));
else g.setColor(new Color(200,200,200));

g.drawString(str,85+1,h-10+2);
g.drawString(str,85+2,h-10-1);
g.setColor(Color.black);
g.drawString(str,85,h-10);
for(int i=0;i<h;i+=3){
if(flag)
g.setColor(new Color(i*(200/h),i*(200/h),i*(200/h)));
else g.setColor(new Color(255-(i*(200/h)),255-(i*(200/h)),255-(i*(200/h))));

g.drawLine(0,i,w,i);
}
return img;
}
}