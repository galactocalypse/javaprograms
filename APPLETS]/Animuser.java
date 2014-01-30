import java.awt.*;
import java.applet.*;
public class Animuser extends Applet{
public void init(){
setSize(910,300);
Anim anim=new Anim();
setLayout(null);
anim.setBounds(0,0,900,100);
add(anim);
anim.init();

}
}