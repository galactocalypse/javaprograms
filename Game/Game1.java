import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.awt.geom.*;
public class Game1 extends Applet implements MouseListener,Runnable{
Thread t;
boolean rng;
int nor;
Rectangle2D cars[][],map,user;
public void init(){
t=new Thread(this);
rng=true;
nor=3;
map=new Rectangle2D.Float(0,0,200,nor*70*2);
user=new Rectangle2D.Float(85,350,30,50);
cars=new Rectangle2D.Float[nor][3];
for(int i=0;i<nor;i++){
for(int j=0;j<3;j++){
//if(((int)(Math.random()*100))%5!=0)
cars[i][j] = new Rectangle2D.Float(35+(j*50),10+(140*i),30,50);
}
}
//t.start();
}
public void paint(Graphics g1){
Graphics2D g=(Graphics2D)g1;
for(int i=0;i<nor;i++){
for(int j=0;j<3;j++){
if(cars[i][j]!=null)
g.draw(cars[i][j]);
}
}
g.draw(map);
g.fill(user);

}
public void mousePressed(MouseEvent e){}
public void mouseReleased(MouseEvent e){}
public void mouseEntered(MouseEvent e){}
public void mouseExited(MouseEvent e){}
public void mouseClicked(MouseEvent e){}
public void run(){
while(rng){
}
}
public void destroy(){
t=null;
rng=false;
}
}