import java.applet.*;
import java.awt.*;
public class RE extends Applet{
public void paint(Graphics g){
int x=300,y=20,r=200,u=1,i;
for(i=100;i<256;i++){
g.setColor(new Color((int)((255-i)*u),(int)((255-i)*u),(int)((255-i)*u)));

g.fillRoundRect(x-i,y+i/2,r,r,20,20);
}
g.setColor(Color.white);
for(int j=0;j<5;j++){
g.fillRoundRect(x-i+j,y+j+(i/2),r-(2*j),r-(2*j),20,20);
}
for(int j=0;j<5;j++){
//g.setColor(new Color(j*50,j*50,j*50));
g.fillRoundRect(x-i+j+5,y+5+j+(i/2),r-10-(2*j),r-10-(2*j),20,20);
g.setColor(new Color((5-j)*50,(5-j)*50,(5-j)*50));
g.fillRoundRect(x-i+j+5+5,y+5+j+(i/2)+5,r-10-(2*j)-10,r-10-(2*j)-10,20,20);
}
}
}