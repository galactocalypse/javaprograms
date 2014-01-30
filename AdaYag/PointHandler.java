import java.awt.geom.*;
public class PointHandler{
public UserPoint[] getPoints(int a,int b,int angle){
UserPoint[] p=new UserPoint[4];
for(int i=0;i<4;i++){
UserPoint u=new UserPoint(a,b,(angle+(i*90))%360);
p[i]=u;
   }
return p;
}
public UserPoint[] updatePoints(UserPoint[] u){
for(int i=0;i<4;i++)u[i].update();
return u;
}
public UserPoint[] getSecondSet(int a,int b,int angle){
int d=(int)Math.sqrt((a*a)+(b*b));
UserPoint[] p=new UserPoint[4];
for(int i=0;i<4;i++){
UserPoint u=new UserPoint(a,b,(angle+(i*90))%360);
u.y+=d;
p[i]=u;
   }
return p;

}
}