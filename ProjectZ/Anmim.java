import java.awt.*;
import java.applet.*;
import java.awt.geom.*;
public class Anmim extends Applet{
public void init(){}
public void paint(Graphics g){
for(int i=0;i<getWidth();i+=22){
for(int j=0;j<getHeight();j+=22){
if((i+j)%(1+(int)(Math.random()*10))!=0)
drawIt(g,i+1,j+1,20,20,(j+i)%2);
}
}

}
public void drawIt(Graphics g,int x,int y,int wd,int ht,int type){
for(int i=x;i<x+wd;i+=2){
for(int j=y;j<y+ht;j+=2){
//g.setColor(new Color((int)((i+j-x-y)*255/(wd+ht)),(int)((i+j-x-y)*255/(wd+ht)),(int)((i+j-x-y)*255/(wd+ht))));
if((i+j-x-y)%1==0){
g.setColor(new Color((int)((i+j-x-y)*255/(wd+ht)),0,0));
g.drawRect(i,j,1,1);
}
    }
}
}
}