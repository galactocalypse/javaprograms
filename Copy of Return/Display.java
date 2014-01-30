import javax.swing.*;
import java.awt.*;
public class Display{
JFrame f;
Component c[];
Display(){
f=new JFrame();
f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
}
public void addComp(Component comp){
Component c1[]=new Component[c.length+1];
for(int i=0;i<c.length;i++){
c1[i]=c[i];
}
c1[c.length]=comp;
c=c1;
}
public void addToFrame(){
for(int i=0;i<c.length;i++){
f.getContentPane().add(c[i]);
}
}
public void showFrame(){
f.setVisible(true);
}
public void main(){

}
}