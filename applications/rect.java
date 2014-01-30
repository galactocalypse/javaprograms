import java.applet.*;
import java.awt.*;
public class rect extends Applet{
Color r,gr,b;
int x,y,i;
public void init(){

setSize(600,480);}
public void paint(Graphics g){
g.setFont(new Font("Georgia",Font.PLAIN,50));

x=0;y=0;i=0;
for(i=255;i>=0;i--){
try{
r=new Color(i,0,0);
g.setColor(r);
g.fillRect(x,y,3,500);
x=x+3;
if(i>25){
if(i==26){
g.setColor(Color.white);}
g.drawString("ADARSH",i-1,i+10);
g.drawString("YAGNIK",i,500-i);
}
}
catch(Exception e){}
}

}


}


