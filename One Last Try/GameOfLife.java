import java.awt.*;
import java.applet.*;
import java.awt.geom.*;
public class GameOfLife extends Applet implements Runnable{
Thread t;
boolean rng;
Grid grid;

public void init(){
grid=new Grid(4,4);
rng=true;
grid.populate();
t=new Thread(this);
t.start();
}
public void paint(Graphics g){
for(int i=0;i<4;i++){
for(int j=0;j<4;j++){
if(grid.g[i][j]==1)g.fillRect((i*20)+1,(j*20)+1,18,18);
}
}
}
public void run(){
while(rng){
grid=grid.getNextState();
repaint();
try{t.sleep(1000);}
catch(Exception e){
}
}
}
public void destroy(){
rng=false;
t=null;
}
}