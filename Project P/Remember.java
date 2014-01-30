import java.awt.*;
import java.applet.*;
import java.awt.geom.*;
import java.awt.event.*;
public class Remember extends Applet{
int cols,colx,coly,cellx,celly,rows,colwidth,rowheight;
public void init(){
cols=5;
rows=10;
colx=10;coly=50;colwidth=50;rowheight=20;
}
public void paint(Graphics g){
for(int i=0;i<=cols;i++){
g.drawLine(colx+(i*colwidth),coly,colx+(i*colwidth),coly+(rows*rowheight));
}
for(int i=0;i<=rows;i++){
g.drawLine(colx,coly+(i*rowheight),colx+(colwidth*cols),coly+(i*rowheight));
}
for(int i=1;i<=(rows);i++){
for(int j=1;j<=(cols);j++){
write(i,j,""+j+":"+i,g);
}
}
}
void write(int r,int c,String d,Graphics g){
g.drawString(d,colx+((c-1)*colwidth),coly+((r)*rowheight));
}
}