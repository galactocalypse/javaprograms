import java.awt.*;
import java.applet.Applet;
public class Animation extends Applet{
    public void paint(Graphics g){
        int x=50,y=50,r=360;
        for(int j=0;j<100;j++){
            for(int i=0;i<r;i++){
                if(i<200)g.setColor(new Color(i,0,0));
                else g.setColor(new Color(i-200,0,0));
                g.fillArc(x+j,y+j,r-(2*j),r-(2*j),i+j,1);}
        }
    }
}