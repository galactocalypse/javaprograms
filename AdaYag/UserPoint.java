import java.awt.geom.*;
import java.awt.*;
public class UserPoint extends Point2D.Float{
int angle;
int a,b;
public UserPoint(int a,int b,int ang){
this.a=a;
this.b=b;
angle=ang;
}
public UserPoint(){
a=b=angle;
}
public void update(){
angle=(angle+1)%360;
x=(int)(a*Math.cos(Math.toRadians(angle)));
y=(int)(b*Math.sin(Math.toRadians(angle)));

}
}