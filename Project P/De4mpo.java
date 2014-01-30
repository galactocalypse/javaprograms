import java.awt.*;
import java.applet.*;
public class De4mpo extends Applet{
public void init(){
setBackground(Color.black);
}
public void paint(Graphics g){
for(int i=5;i<=10;i++){
cell(g,120*((i%(getWidth()/120))),40*((i*100)/(getHeight()-40)),120,40,"CELLS");
}
}
public void cell(Graphics g,int x,int y,int w,int h,String val){
for(int i=0;i<=w/2;i+=1){
g.setColor(new Color(200*2*i/w,200*2*i/w,200*2*i/w));
g.drawRoundRect(x+i,y,w-(2*i),h,w,h/2);
}
int x1=x+(int)((w-(g.getFont().getSize()*0.6*val.length()))/2);
int y1=y+g.getFont().getSize()+((h-g.getFont().getSize())/2);
g.setColor(Color.white);
g.drawString(val,x1,y1);
g.setColor(Color.gray);
g.drawString(val,x1-1,y1-1);

}
}