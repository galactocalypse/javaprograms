import java.awt.*;
import java.applet.*;
import java.awt.geom.*;
import java.awt.image.*;
public class Btsav extends Applet{
public void init(){
}
//public void paint(Graphics g){
//g.drawImage(getBg(0,0,getWidth(),getHeight(),20,20,0,0,0,true),0,0,this);
//}
public void paintBox(Graphics g,int x,int y,int w,int h,int dir,int shape){
for(int i=0;i<w/2;i++){
int var=(int)(i*255/((w>h)?h:w));
if(dir==0)g.setColor(new Color(var,var,var));
else g.setColor(new Color(255-var,255-var,255-var));
switch(shape){
case 0:
g.fillRect(x+i,y+i,w-(2*i),h-(2*i));
break;
case 1:
g.fillRoundRect(x+i,y+i,w-(2*i),h-(2*i),w>h?h:w,w>h?h:w);
break;
case 2:
g.fill3DRect(x+i,y+i,w,h,true);
break;
case 3:
g.fillArc(x+i,y+i,w-(2*i),h-(2*i),2*i,240+i);
break;
case 4:
g.drawRect(x+i,y+i,w,h);
break;
case 5:
g.drawRoundRect(x+i,y+i,w,h,w>h?h:w,w>h?h:w);
break;
case 6:
g.draw3DRect(x+i,y+i,w,h,true);
break;
case 7:
g.drawArc(x+i,y+i,w,h,0,90+i);
break;
}

}
}

public void paint(Graphics g){
//public Image getBg(int x,int y,int tw,int th,int w,int h,int spacing,int dir,int shape,boolean r){

Image img=createImage(500,500);
Graphics g1=img.getGraphics();
boolean r=true;
int tw=getWidth(),th=getHeight(),w=20,h=20,spacing=2;
for(int i=0;i<tw;i+=w){
for(int j=0;j<th;j+=h){
if((!r)||(r&&(int)(Math.random()*50)%7==0))
paintBox(g1,i,j,w-spacing,h-spacing,0,2);
    }
}
g.drawImage(img,0,0,this);
}
}