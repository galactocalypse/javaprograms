import java.applet.*;
import java.awt.*;
public class Blahstest extends Applet{
public void init(){}
public void paint(Graphics g){
/**for(int i=0;i<getWidth();i+=4){
for(int j=0;j<getHeight();j+=4){
int x=(int)((i+j)*255/(getWidth()+getHeight()));
g.setColor(new Color(x,x,x));
g.fillRect(i,j,4,4);
}    }
**/
g.setColor(new Color(50,50,50));
g.fillRect(0,0,getWidth(),getHeight());
g.setFont(new Font("Micromieps",Font.BOLD,80));

g.setColor(Color.gray);
g.drawString("TECHATHON",41,201);
for(int i=0;i<20;i++){
int x=50+(int)((20-i)*5/2);
g.setColor(new Color(x,x,x));
g.drawString("TECHATHON",40-i,200-i);
}
g.setColor(new Color(50,50,50));
g.drawString("TECHATHON",40-19,200-19);

}

}