import java.awt.*;
import javax.swing.*;
import javax.imageio.*;
import java.awt.geom.*;
import java.util.*;

    public class D extends JFrame{
        
       
        boolean won=false,lost=false;
        Container c;
        Font titleFont=new Font("Xenotron",Font.BOLD,120);
        Rectangle2D optionBar;
        Rectangle2D status;
        Rectangle2D pic;
        Rectangle2D level;
        
        String[] caps,pass,hints,descs;
        
        Date date=new Date();        
        
        TextField p=new TextField();
        
        int currLev=1;
        String ccaption="adarsh yagnik";
        String chint="adarsh";
        String cpass="adarsh";
        String cdesc="adarsh";
        Image cImg=null;
        public D(){
        new JFrame("BiTWIZ");
        setBounds(0,0,900,600);
        define();
        c.setLayout(null);
        setVisible(true);
        
    }
    
    public void updateDetails(){
        ccaption=caps[currLev-1];
        chint=hints[currLev-1];
        cpass=pass[currLev-1];
        cdesc=descs[currLev-1];
    }
    
    public void define(){
        status=new Rectangle2D.Float(0,getHeight()-31,getWidth(),30);
        optionBar=new Rectangle2D.Float(0,getHeight()-62,getWidth(),30);
        pic=new Rectangle2D.Float(10,140,380,380);
        level=new Rectangle2D.Float(0,105,getWidth(),30);
        c=getContentPane();
        setResizable(false);
        setBackground(Color.black);
        }
        
        public void paint(Graphics g1){
            Graphics2D g=(Graphics2D)g1;
            if(!won&&!lost){
            title(g);
            drawOptionBar(g);
            drawCapBar(g);
            showOptions(g);
            showStatus(g);
            showPic(g);
            drawCaption(g);
            showLevel(g);
            showTime(g);
            
        }
            else if(won&&!lost){}
            else if(lost&&!won){}
        }
        
        public void title(Graphics2D g){
            g.setFont(titleFont);
            g.fillRect(0,0,getWidth(),100);
        for(int i=0;i<100;i+=1){
            g.setColor(new Color(i,i,i));
            g.drawLine(0,i,getWidth()-1,i);
        }
            g.drawString("BITWIZ",152,100);
            g.setColor(Color.black);
            g.drawString("BITWIZ",150,98);
        }
        public void drawOptionBar(Graphics2D g){
            g.setColor(Color.black);
            g.fill(optionBar);
        }
        public void showStatus(Graphics2D g){
        for(int i=0;i<30;i++){
            g.setColor(new Color(180-i*6,180-i*6,180-i*6));
            g.drawLine(0,(int)status.getY()+i,getWidth(),(int)status.getY()+i);
        }
    }
        public void showOptions(Graphics2D g){
        for(int i=0;i<30;i++){
            g.setColor(new Color(180-i*6,180-i*6,180-i*6));
            g.drawLine(0,(int)optionBar.getY()+i,getWidth(),(int)optionBar.getY()+i);
        }
    }
    public void drawCaption(Graphics2D g){
        g.setColor(Color.white);
        g.setFont(new Font("TimesNewRoman",Font.BOLD,18));
        g.drawString(ccaption,635-(int)(ccaption.length()/2*0.6*g.getFont().getSize()),300);
        g.setColor(Color.gray);
        g.drawString(ccaption,637-(int)(ccaption.length()/2*0.6*g.getFont().getSize()),300);
        g.drawString(ccaption,635-(int)(ccaption.length()/2*0.6*g.getFont().getSize()),302);
        g.setColor(Color.darkGray);
        g.drawString(ccaption,637-(int)(ccaption.length()/2*0.6*g.getFont().getSize()),302);
        g.setColor(Color.black);
        g.drawString(ccaption,636-(int)(ccaption.length()/2*0.6*g.getFont().getSize()),301);
    }
    public void drawCapBar(Graphics2D g){
        for(int i=0;i<20;i++){
        g.setColor(new Color(i*10,i*10,i*10));
        g.drawRoundRect((int)(pic.getX()+pic.getWidth()+20+i),(int)(pic.getY()+(pic.getHeight()/3)+i)-(2*i),(int)(getWidth()-(1*(pic.getX()+pic.getWidth()+20+i)))-20-(1*i),50+(2*i),10,10);
    }
    }
        public void showPic(Graphics2D g){
            g.setColor(Color.lightGray);
            g.drawRoundRect((int)pic.getX(),(int)pic.getY(),(int)pic.getWidth(),(int)pic.getHeight(),10,10);
            if(cImg!=null)
            g.drawImage(cImg,(int)pic.getX()+5,(int)pic.getY()+5,(int)pic.getWidth()-10,(int)pic.getHeight()-10,this);
        }
        public void showLevel(Graphics2D g){
            g.setColor(Color.black);
            for(int i=0;i<level.getHeight();i++){
                g.setColor(new Color(i*4,i*4,i*4));
                g.drawLine(0,(int)level.getY()+i,getWidth(),(int)level.getY()+i);
            }
        g.setFont(new Font("Georgia",Font.PLAIN,20));
        g.setColor(Color.gray);
        g.drawString("L E V E L  "+currLev,379,125);
        g.setColor(Color.lightGray);
        g.drawString("L E V E L  "+currLev,380,124);
        g.setColor(Color.darkGray);
        g.drawString("L E V E L  "+currLev,380,125);
        }
        public void showTime(Graphics2D g){
        }
        public void won(Graphics2D g){}
        public void lost(Graphics2D g){}
        public void check(String s){
            if(s.equalsIgnoreCase(cpass)){
            if(currLev<25){
                currLev++;
                updateDetails();
            }
            else if(currLev==25)won=true;
            
            }       
        }
    }