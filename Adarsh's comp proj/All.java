import java.applet.*;
import java.awt.*;
public class All extends Applet{
Calculator c=new Calculator();;
DigitalClock dc=new DigitalClock();
Paint2 p=new Paint2();
WeekScheduler ws=new WeekScheduler();
public void init(){
setSize(1000,1000);
setLayout(null);
c.setBounds(0,0,300,480);
ws.setBounds(300,0,400,200);
dc.setBounds(380,330,512,360);
add(c);
add(dc);
add(ws);
c.init();
dc.init();
ws.init();
}
    }