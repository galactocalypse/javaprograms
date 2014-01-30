import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.applet.*;

public class WeekScheduler extends Applet implements ActionListener{
GregorianCalendar gc=new GregorianCalendar();
int input;
Font f1=new Font("Impact",Font.BOLD,20);
Font f2=new Font("Arial",Font.PLAIN,12);
Font f3=new Font("TimesNewRoman",Font.BOLD,16);
String date,time,events="";
int ypos;
Button setEvent;
TextField getmonth;
int dt,moy,dow,year;
int daysInMonth[]={31,28,31,30,31,30,31,31,30,31,30,31};
String months[]={"January","February","March","April","May","June","July","August","September","October","November","December"};
String week[]={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};    
Button clr=new Button("Clear");

public void paint(Graphics g){
g.setFont(f1);
g.drawString("CALENDAR",100,30);
dt =gc.get(Calendar.DATE);
dow =(gc.get(Calendar.DAY_OF_WEEK))-1;
moy =(gc.get(Calendar.MONTH));
year =gc.get(Calendar.YEAR);
g.setFont(f3);
g.drawString("TODAY :  "+week[dow]+"    "+dt+" "+months[moy]+" , "+year+" ",60,60);
ypos=120;
while(dow!=7){
if(dt>=daysInMonth[moy])moy++;
if(moy>12)year++;
g.drawString(week[dow]+"  "+dt+"  "+months[moy]+" , "+year,20,ypos);
dow++;
dt++;
ypos=ypos+20;

    }
g.setFont(f2);
g.drawString("Event of the week : "+events,50,80);
    }
public void init(){
setSize(350,300);
setLayout(null);
setBackground(Color.orange);
clr.setBounds(130,260,100,30);
setEvent=new Button("Add Event");
getmonth=new TextField();
setEvent.setBounds(230,220,100,28);
getmonth.setBounds(20,220,200,28);
add(getmonth);
add(clr);
add(setEvent);
setEvent.addActionListener(this);
clr.addActionListener(this);
}
public void actionPerformed(ActionEvent evt){
String cmd=evt.getActionCommand();
if(cmd.equalsIgnoreCase("clear")){
events="";
    }
    else {if(events!="")
events=events+" ; "+getmonth.getText();
else events=events+" "+getmonth.getText();
}
getmonth.setText("");
repaint();

    }
 

}