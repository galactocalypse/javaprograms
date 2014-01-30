import java.awt.*;
import java.applet.*;
public class Demo extends Applet{
String s[]={"This","is","the","string"};
public void init(){}
public void paint(Graphics g){
g.drawString("This:"+getMaxStringWidth(),100,100);
g.drawRect(10,10,getMaxStringWidth(),100);
}
int getMaxStringWidth(){
if(s==null)return 0;
int max=0;
FontMetrics fm=getFontMetrics(getGraphics().getFont());
max=fm.stringWidth(s[0]);
for(int i=1;i<s.length;i++){
if(fm.stringWidth(s[i])>max)max=fm.stringWidth(s[i]);
}return max;
}
}