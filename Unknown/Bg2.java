import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class Bg2 extends JFrame  implements Runnable,ActionListener,MouseListener,MouseMotionListener{
  Color fc1=Color.gray;
  Color fc2=Color.gray;
  int timeLimit=7200;
    Anim anim=new Anim();
    int score=0;
    Image myImg;
    boolean showHint1=false;
    int tries=5;
    Rectangle2D easy=new Rectangle2D.Float(150,300,20,20);
    int huil=0;
    boolean hintUsed=false;
    boolean exit=false;
    String answer="ans";
    int levels=25;
    int level=1;
    
    Record rec[]=new Record[levels];
    JFrame frame=new JFrame("Bitwise");
    JLabel sure=new JLabel("Are you sure ?");
        JLabel thanx=new JLabel("Thank you!");
        JLabel scr=new JLabel("Your final score is :"+score);
        
    Thread t;
    boolean running=true;
    int timeElapsed=0;
    Date date=new Date();
    final int startTime[]={date.getHours(),date.getMinutes(),date.getSeconds()};
    Rectangle2D pic=new Rectangle2D.Float(71,159,370,350);
    Button go=new Button("Go");
    Button yes=new Button("Yes");
    Button no=new Button("No");
    
    TextField pass=new TextField();
    Rectangle2D hint=new Rectangle2D.Float(4,536,150,30);
    Rectangle2D quit=new Rectangle2D.Float(746,536,150,30);
    Ellipse2D hintIndicator=new Ellipse2D.Float(135,(int)hint.getY()+8,12,12);
    
    public Bg2(){
        new JFrame("BitWiz");
        JFrame.setDefaultLookAndFeelDecorated(false);
     setResizable(false);
   fc1=Color.gray;
   fc2=Color.gray;
   timeLimit=7200;
     anim=new Anim();
    score=0;
     
     showHint1=false;
     tries=5;
     easy=new Rectangle2D.Float(150,300,20,20);
     huil=0;
     hintUsed=false;
     exit=false;
     answer="ans";
     levels=25;
     level=1;
    
    rec=new Record[levels];
    frame=new JFrame("Bitwise");
     sure=new JLabel("Are you sure ?");
        thanx=new JLabel("Thank you!");
         scr=new JLabel("Your final score is :"+score);
        
   t=new Thread(this);
    running=true;
     timeElapsed=0;
     date=new Date();
     pic=new Rectangle2D.Float(71,159,370,350);
     go=new Button("Go");
   yes=new Button("Yes");
    no=new Button("No");
    
   pass=new TextField();
    hint=new Rectangle2D.Float(4,536,150,30);
    quit=new Rectangle2D.Float(746,536,150,30);
    hintIndicator=new Ellipse2D.Float(135,(int)hint.getY()+8,12,12);
  
    setBounds(0,0,900,600);
        getContentPane().setLayout(null);
         anim.setBounds(230,0,432,60);

         
         try{
        for(int i=0;i<levels;i++){
            rec[i]=new Record(ImageIO.read(new File("images//"+i+".jpg")),(i+1));
        }
    }
    catch(Exception e){
        
    }

        go.setBackground(Color.black);
        go.setForeground(Color.gray);
        go.setBounds(500,539,40,26);
        pass.setBackground(Color.black);
        pass.setForeground(Color.gray);
        pass.setBounds(300,539,180,26);
       
        go.addActionListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
       
        getContentPane().add(pass);
         getContentPane().add(go);
           getContentPane().add(anim);

        t.start();
        setVisible(true);
    }

    public void paint(Graphics g1){
       
        Image background =createImage(getWidth(),getHeight());
        Graphics2D g=(Graphics2D)background.getGraphics();
      
        for(int i=0;i<60;i++){
            if(i<=30){
                g.setColor(new Color(i*4,i*4,i*4));
            }
            else g.setColor(new Color((i-30)*4,(i-30)*4,(i-30)*4));
            if(i==59)g.setColor(Color.black);
            g.fillRect(i,i,getWidth()-(2*i),getHeight()-(2*i));
        }
        int x=2,y=0,w=this.getWidth()-4,h=100;
        for(int i=1;i<=20;i++){
            if(i<10){g.setColor(new Color(255-(i*28),255-(i*28),255-(i*28)));
            }
            else if(i<=19) {g.setColor(new Color(((i-10)*28),((i-10)*28),((i-10)*28)));
            }
            else if(i<=20)g.setColor(Color.black);
            g.fillRoundRect(x+i,y+i,w-(2*i),h-(2*i),30,30);
        }   
        for(int i=0;i<20;i++){
            if(i<=10)g.setColor(new Color(255-(i*25),255-(i*25),255-(i*25)));
            else g.setColor(new Color(510-(i*25),510-(i*25),510-(i*25)));
            g.drawLine(22,40+i,getWidth()-24,40+i);
        }
         if(!exit){
        g.setColor(Color.darkGray);
        g.drawRoundRect(x+2,y+2,w-4,h-4,30,30);
        g.setColor(Color.gray);
        g.drawRoundRect(x+60,y+102,w-120,30,10,10);
        g.drawRoundRect(x+60,y+134+5,450-60,390,10,10);
        g.drawRoundRect(x+452,y+134+5,384,390,10,10);
        g.drawRoundRect(x,y+536,w,30,10,10);
        g.drawRoundRect(x,y+568,w,30,10,10);
        oval(g,-50,0);
        oval(g,850,0);

        g.setColor(Color.white);

        g.fill(pic);
        if(rec[level].image!=null)
        g.drawImage(rec[level-1].image,(int)pic.getX()+1,(int)pic.getY()+1,(int)pic.getWidth()-2,(int)pic.getHeight()-2,this);
        
        g.setFont(new Font("Georgia",Font.PLAIN,15));
        g.setColor(Color.white);
        if(level!=1){
        g.drawString(rec[level].caption,640-(6*(rec[level].caption.length()/2)),324);
        g.setFont(new Font("Georgia",Font.PLAIN,12));        
        g.drawString("Link the image and caption with a word related to computers.",650-(3*60),504);
    }
        else if(level==1){
            g.drawString("Locate and click a small hidden area",650-(3*36),324);
            g.drawString("in the image to go on to the next level.",650-(3*39),344);
        }
        g.setFont(new Font("tIMESNEWROMAN",Font.PLAIN,10));
        g.setColor(Color.gray);
        g.drawString("PASSWORD ",200,555);
        g.drawString("  START TIME : ",x,y+588);
        g.setFont(new Font("tIMESNEWROMAN",Font.PLAIN,15));
        g.drawString(""+startTime[0]+":"+startTime[1]+":"+startTime[2],x+80,y+590);        
        g.setFont(new Font("TimesNewRoman",Font.BOLD,20));
        g.drawString("L E V E L",x+251+100,y+125);        
        g.drawString("L E V E L",x+249+100,y+123);        
        g.drawString("L E V E L",x+251+100,y+123);        
        g.drawString("L E V E L",x+249+100,y+125);
        g.setColor(Color.black);
        g.drawString("L E V E L",x+250+100,y+124);
        g.setColor(Color.white);
        g.setFont(new Font("Georgia",Font.ITALIC,100));
        g.drawString("\"",x+462,y+244);
        g.drawString("\"",x+822-60,y+504);
        for(int i=1;i<=10;i++){
            g.setColor(new Color(i*15,i*15,i*15));
            g.fillRect((int)hint.getX(),(int)hint.getY()+i,(int)(hint.getWidth()-(hint.getHeight()/2)),(int)hint.getHeight()-(2*i));
            g.fillArc((int)(hint.getX()+hint.getWidth()-hint.getHeight())+i,i+(int)hint.getY(),(int)hint.getHeight()-(2*i),(int)hint.getHeight()-(2*i),-90,180);;
            
            g.fillRect((int)(quit.getX()+quit.getHeight()/2),(int)quit.getY()+i,(int)(quit.getWidth()-quit.getHeight()/2),(int)quit.getHeight()-(2*i));
            g.fillArc((int)(quit.getX()+i),i+(int)quit.getY(),(int)quit.getHeight()-(2*i),(int)quit.getHeight()-(2*i),90,180);
        }
        
        g.setColor(Color.black);
        g.setFont(new Font("TimesNewRoman",Font.BOLD,15));
        g.drawString("H I N T",(int)hint.getX()+30,(int)hint.getY()+20);
        g.drawString("H I N T",(int)hint.getX()+30+1,(int)hint.getY()+20+1);
        g.setColor(fc1);
        g.drawString("H I N T",(int)hint.getX()+30-1,(int)hint.getY()+20-1);
        
        g.setColor(Color.black);
        g.setFont(new Font("TimesNewRoman",Font.BOLD,15));
        g.drawString("Q U I T",(int)quit.getX()+50,(int)quit.getY()+20);
        g.drawString("Q U I T",(int)quit.getX()+50+1,(int)quit.getY()+20+1);
        g.setColor(fc2);
        g.drawString("Q U I T",(int)quit.getX()+50-1,(int)quit.getY()+20-1);
        if(showHint1&&level==1){
            g.setColor(Color.white);
            g.drawRect((int)easy.getX(),(int)easy.getY(),(int)easy.getWidth(),(int)easy.getHeight());
        }
        
    }
        
    if(exit) {
        anim.stop();
            exit(g);
        }
        g1.drawImage(background,0,0,this);
        
    }
    public void updateHint(Graphics2D g){
        g.setColor(Color.red);
        if(!hintUsed)g.fill(hintIndicator);
            else g.draw(hintIndicator);
        }
    public void updateScore(Graphics g){
        //g.setColor(Color.black);
        //g.fillRect(270,575,30,20);
        g.setColor(Color.gray);
        g.setFont(new Font("TimesNewRoman",Font.PLAIN,10));
        g.drawString("  SCORE : ",200,588);
        g.setFont(new Font("tIMESNEWROMAN",Font.PLAIN,15));
        g.drawString(""+score,270,588);
    }
    public void updateTime(Graphics g){
        //g.setColor(Color.black);
        //g.fillRect(798,578,30,20);
        g.setColor(Color.gray);
        g.setFont(new Font("TimesNewRoman",Font.PLAIN,10));
        g.drawString("  TIME REMAINING : ",700,588);
        g.setFont(new Font("tIMESNEWROMAN",Font.PLAIN,15));
        g.drawString(""+((timeLimit-timeElapsed)/60)+" minutes",800,590);
    }
    public void actionPerformed(ActionEvent e){
        String str="";
        if(e.getActionCommand()=="Go"){
            if(tries>0){
            if(pass.getText().length()>0&&!pass.getText().equalsIgnoreCase("Please enter password first!")&&!pass.getText().equalsIgnoreCase("Incorrect!")&&!pass.getText().equalsIgnoreCase("Correct!")){
                str=pass.getText();
                if(str.equalsIgnoreCase(rec[level-1].password)){
                    score++;
                    tries=5;
                    level++;
                    pass.setText("");
                    descWindow();
                }
                else {
                    if(huil==level){score-=2;}
                        else score--;
                    pass.setText("Incorrect!");
                    tries--;
                }
                if(tries==0&&hintUsed){go.removeActionListener(this);}
                
            }
        
            else if(pass.getText()==null||pass.getText().length()==0) {pass.setText("Please enter password first!");}
        }
    paint(getGraphics());
        updateTime(getGraphics());
        updateScore(getGraphics());
        updateTries(getGraphics());
    }
    else if(e.getActionCommand().equalsIgnoreCase("yes")){
    exit=true;
    getContentPane().remove(go);
    getContentPane().remove(pass);
    frame.setVisible(false);
    }
    else if(e.getActionCommand().equalsIgnoreCase("no")){
    frame.setVisible(false);
}
    }
    public void updateLevel(Graphics g){
        //g.setColor(Color.black);
        g.setColor(Color.gray);
        g.setFont(new Font("TimesNewRoman",Font.BOLD,20));
        g.drawString(""+level,480,124);
        
    }
    void updateTries(Graphics g){
        //g.setColor(Color.black);
        //g.fillRect(548,576,30,20);
        g.setColor(Color.gray);
        g.setFont(new Font("TimesNewRoman",Font.PLAIN,10));
        g.drawString("  TRIES LEFT : ",450,588);
        g.setFont(new Font("tIMESNEWROMAN",Font.PLAIN,15));
        g.drawString(""+tries,550,588);
    }   
  

    public void run(){
        while(running&&timeElapsed<=timeLimit){
            
        setSize(900,600);


      
    if(level==1){pass.setEditable(false);}
            Image fimg=createImage(getWidth(),getHeight());
            Graphics2D fgr=(Graphics2D)fimg.getGraphics();
            fgr.drawImage(myImg,0,0,this);
            //paint(fgr);
            if(timeElapsed<=2){
           anim.init();
        }
            if(!exit){
            updateTime(fgr);
            updateScore(fgr);
            updateTries(fgr);
            updateLevel(fgr);
            updateHint(fgr);

        }
            getGraphics().drawImage(fimg,0,0,this);
                
            if(tries==0){pass.setEditable(false);
                go.removeActionListener(this);
                getContentPane().remove(go);}
                
                timeElapsed++;
                try{
                    rec[0].levelsCrossed=level-1;
                    rec[0].score=score;
                    //rec[0].save();
                    t.sleep(1000);
                paint(myImg.getGraphics());
                }
                catch(Exception e){}
            }
        }
        public void destroy(){
   


    
    
            t=null;
    running=false;
}
        public void mousePressed(MouseEvent e){}
        public void mouseReleased(MouseEvent e){}
        public void mouseClicked(MouseEvent e){
            Point2D pt=new Point2D.Double(e.getX(),e.getY());
            if(hint.contains(pt)){
                if(!hintUsed||huil==level){
                    if(!hintUsed){
                        tries=3;
                    }
                    huil=level;
                    hintUsed=true;
                    if(tries>0){
                    getContentPane().add(go);
                    go.addActionListener(this);
                    pass.setEditable(true);
                }
                    hintWindow(0);
            
        }
        else if(hintUsed&&huil!=level){
            hintWindow(1);
        }
        
    }
        else if(quit.contains(pt)) {
        disp();
        }
        else if(level==1&&easy.contains(pt)){
                    score++;
                    tries=5;
                    level++;
                    pass.setText("Correct!");
                    pass.setEditable(true);
        }
        else if(new Rectangle2D.Float(890,540,10,10).contains(pt)){showHint1=!showHint1;}
        
        }
        public void mouseEntered(MouseEvent e){
        }
        public void mouseExited(MouseEvent e){}
        public void mouseMoved(MouseEvent e){
        Point2D pt=new Point2D.Double(e.getX(),e.getY());
        if(hint.contains(pt)||quit.contains(pt)){
            if(hint.contains(pt)){
            fc1=Color.white;
            fc2=Color.gray;
        }
        else {fc2=Color.white;fc1=Color.gray;
        }
            setCursor(new Cursor(12));
        }
        else{
            fc1=fc2=Color.gray;
            setCursor(new Cursor(0));
        }
        }
        public void mouseDragged(MouseEvent e){}
    
    public void disp(){
        sure.setBounds(0,0,150,20);
        thanx.setBounds(0,30,150,20);
        scr.setBounds(0,20,150,20);
        yes.addActionListener(this);
        no.addActionListener(this);
        yes.setBounds(0,30,70,20);
        no.setBounds(90,30,70,20);
        
        
        frame.getContentPane().setLayout(null);
        frame.setBounds(460,200,200,100);
        frame.getContentPane().add(sure);
        frame.getContentPane().add(yes);
        frame.getContentPane().add(no);
        frame.setVisible(true);
    }
    void exit(Graphics g){    

        g.setColor(Color.black);
    g.fillRect(0,101,getWidth(),getHeight()-100);
    g.setColor(Color.gray);
    g.setFont(new Font("Monotype Corsiva",Font.BOLD,30));
    g.drawString("Thank you !",250,200);
    g.drawString("Final score : "+score,50,300);
    g.drawString("Levels crossed : "+(level-1),50,400);
    }
    void hintWindow(int op){
    JFrame hf=new JFrame("Hint");
     hf.getContentPane().setLayout(null);
     hf.setBounds(460,200,300,150);
     String str="";
     if(op==0){str=rec[level].hint;
        }
          else if(op==1){str="Hint already used in level "+huil;}
        
            JLabel hintl=new JLabel(str);
            hintl.setBounds(12,12,200,50);
            hf.getContentPane().add(hintl);
        
            hf.setVisible(true);
    }
    void descWindow(){
    JFrame df=new JFrame("Correct!");
     df.getContentPane().setLayout(null);
     df.setBounds(460,200,300,200);
        
     String str=rec[level].description;
    String pwd=rec[level].password;
    JLabel desc=new JLabel(str);
    JLabel pswd=new JLabel("'"+pwd+"'  is the correct answer!");
    pswd.setBounds(12,12,200,20);
    desc.setBounds(12,24,200,50);
    df.getContentPane().add(pswd);
    df.getContentPane().add(desc);
                      
        df.setVisible(true);
    }
    void oval(Graphics g,int x,int y){
        for(int i=0;i<50;i++){
            g.setColor(new Color(i*5,i*5,i*5));
            g.fillOval((x+i),(y+i),100-(2*i),100-(2*i));
        }
    }
}