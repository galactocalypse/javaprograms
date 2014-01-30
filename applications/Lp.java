import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.Button;
import java.util.*;
    public class Lp extends Applet implements ActionListener{
        int i,r=10,gr=20,b=30;
        Color colour;
        
              public void init(){
            setLayout(null);
            colour=new Color(r,gr,b);
            Button change=new Button("change");
            change.setBounds(0,460,500,500);
            change.setBackground(Color.black);
            add(change);
            change.addActionListener(this);

            }
        public void paint(Graphics g){
            setBackground(Color.black);
            
            g.setColor(new Color(r,gr,b));
            g.drawLine(150,150,80,300);
            g.drawLine(151,150,81,300);
            g.drawLine(152,150,82,300);
            g.drawLine(153,150,83,300);
            
            g.drawLine(80,300,300,300);
            g.drawLine(80,301,300,301);
            g.drawLine(80,302,300,302);
            g.drawLine(80,303,300,303);
            
            g.drawLine(250,200,150,400);
            g.drawLine(251,200,151,400);
            g.drawLine(252,200,152,400);
            g.drawLine(253,200,153,400);
            
            g.drawLine(300,300,250,200);
            g.drawLine(301,300,251,200);
            g.drawLine(302,300,252,200);
            g.drawLine(303,300,253,200);
            
            g.drawArc(30,100,340,340,0,360);
            g.drawArc(31,101,338,338,0,360);
            g.drawArc(32,102,336,336,0,360);
            g.drawArc(33,103,334,334,0,360);
        }
        public void actionPerformed(ActionEvent evt){
        if(evt.getActionCommand().equalsIgnoreCase("change")){
            Date d=new Date();
        int i=d.getSeconds();
        if(i%5==0){r=i;gr=250;b=195;init();}
            else if(i%15==0){r=190;gr=i*5;b=20;init();}
            else if(i%14==0){r=205;gr=55;b=i;init();}
            else if(i%13==0){r=gr=b=15;init();}
            else if(i%12==0){r=254;gr=i*10;b=4;init();}
            else if(i%11==0){r=205;gr=42;b=(i*10);init();}
            else if(i%10==0){r=i*25;gr=17;b=15;init();}
            else if(i%9==0){r=200;gr=(25*i);b=2;init();}
            else if(i%8==0){r=250;gr=25;b=i;init();}
            else if(i%7==0){r=gr=b=20;init();}
            else if(i%6==0){r=200;gr=i*10;b=4;init();}
            else if(i%5==0){r=205;gr=24;b=(i*10);init();}
            else if(i%4==0){r=i*25;gr=57;b=25;init();}
            else if(i%3==0){r=200;gr=(i*70);b=0;init();}
            else if(i%2==0){r=225;gr=25;b=i;init();}
            else if(i%1==0){r=gr=b=150;init();}
            else if(i%17==0){r=254;gr=i*10;b=4;init();}
            else if(i%19==0){r=(105+i);gr=42;b=(i*10);init();}
            else if(i%31==0){r=i*25;gr=57;b=22;init();}
                   }repaint();
    }    
                 
    }

