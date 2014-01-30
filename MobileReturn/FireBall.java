import java.awt.*;
import java.awt.geom.*;
public class FireBall{
int x,y,dir,speed=3;
boolean consumed;
public FireBall(int x,int y,int dir){
this.x=x;
this.y=y;
this.dir=dir;
}
public Rectangle2D getRect(){
return new Rectangle2D.Float(x,y,10,10);
}
public void update(){
switch(dir){
case 1:
y-=speed;
break;
case 2:
x+=speed;
break;
case 3:
y+=speed;
break;
case 4:
x-=speed;
break;
}
}
public void showBullet(Graphics g1){
Graphics2D g=(Graphics2D)g1;
g.fill(getRect());
}
}