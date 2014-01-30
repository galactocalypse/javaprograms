import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;

    public class Bitss extends JFrame implements Runnable,MouseListener,ActionListener,MouseMotionListener{
        
        boolean changeAnim=false;
        boolean cheatsOn=false;
        Rectangle2D back=new Rectangle2D.Float(0,0,100,100);
        Rectangle2D back2=new Rectangle2D.Float(800,0,100,100);
        Rectangle2D cheat=new Rectangle2D.Float(0,660,10,10);
        Rectangle2D levelOne=new Rectangle2D.Float(151,455,30,30);
        Rectangle2D pic=new Rectangle2D.Float(77,211,370,370);
        Rectangle2D hint=new Rectangle2D.Float(4,607,180,27);
        Rectangle2D quit=new Rectangle2D.Float(716,607,180,27);

        Animated anim=new Animated(this,"B I T W I Z",900,70,100);
        
        Image temp=null;
        boolean exiting=false;
        JFrame msgQuit=new JFrame("BitWiz");
        Button yes=new Button("Yes"),no=new Button("No");
        Date dt=new Date();
        int timeElapsed=0;
        int shrs=dt.getHours();
        int smins=dt.getMinutes();
        int ssecs=dt.getSeconds();
        String startTime=shrs+" : "+smins+" : "+ssecs;
        Button go=new Button("Go");
        TextField pass=new TextField();
        
        boolean won=false;
        int tries=0;
        int level=1;
        int totLevels=25;
        String caption="";
        Image img=null;
        String pwd="";
        String hints="";
        String desc="";
        boolean hintUsed=false;
        int score=0;
        int huil=0;
        String caps[]=new String[25];
        Image imgs[]=new Image[25];
        String pwds[]=new String[25];
        String hintss[]=new String[25];
        String descs[]=new String[25];

        boolean running=true;
        Thread t;
        public static void main (String args[]){
            try{
            Bitss bitss=new Bitss();
        }
        catch(Exception e){
        System.exit(0);}
        }
        public void paint(Graphics g){
            if(exiting==true||won==true)paintBg(g);
        }
        public void update(Graphics g){
            
        }
        public Bitss(){
            new JFrame("BitWiz");  
            try{
                File password=new File("file1.txt");
                File descf=new File("file2.txt");
                File hintf=new File("file3.txt");
                File capf=new File("file4.txt");
                if(password.exists()&&descf.exists()&&hintf.exists()&&capf.exists()){
                DataInputStream in=new DataInputStream(new FileInputStream(password));
                for(int i=0;i<25;i++){
                    pwds[i]=in.readLine()+i;
                }
                in=new DataInputStream(new FileInputStream(descf));
                for(int i=0;i<25;i++){
                    descs[i]=in.readLine()+i;
                }
                in=new DataInputStream(new FileInputStream(hintf));
                for(int i=0;i<25;i++){
                hintss[i]=in.readLine()+i;
                }            
                in=new DataInputStream(new FileInputStream(capf));
                for(int i=0;i<25;i++){
                    caps[i]=in.readLine()+i;      
                }            

                in.close();in=null;
                for(int i=0;i<25;i++){
                    try{
                        imgs[i]=ImageIO.read(new File("images\\"+i+".jpg"));
                    }
                    catch(Exception e){
                        try{
                            imgs[i]=ImageIO.read(new File("images\\"+i+"+.jpeg"));
                        }
                        catch(Exception ee){imgs[i]=null;}
                    }

                }
                pwd=pwds[0];
                hints=hintss[0];
                desc=descs[0];
                caption=caps[0];

                level=1;
            }
        }
            catch(Exception e){}
            t=new Thread(this);

                    getContentPane().setLayout(null);
            setBounds(0,0,900,670);
            setResizable(false);
            go.setBounds(470,587,50,26);
            pass.setBounds(280,588,180,24);

            go.setBackground(Color.black);
            go.setForeground(Color.gray);
            pass.setBackground(Color.black);
            pass.setForeground(Color.lightGray);
            go.addActionListener(this);
            getContentPane().add(go);
            getContentPane().add(pass);
            pass.setEditable(false);

            setBackground(Color.black);
        
        
            addMouseListener(this);
            
            addMouseMotionListener(this);
            t.start();
            setVisible(true);
        }
        public void drawBorder(Graphics g){
            for(int i=0;i<60;i++){
                if(i<=30)g.setColor(new Color(i*3,i*3,i*3));
                else g.setColor(new Color((i-25)*3,(i-25)*3,(i-25)*3));
                if(i==59){g.setColor(Color.black);
                    g.fillRect(0,0,getWidth(),136);
                }
            g.fillRect(i,i,getWidth()-(2*i),getHeight()-(2*i));
        }
    }
    public void drawTitleBg(Graphics g){
        for(int i=1;i<=20;i++){
            if(i<=10)
            g.setColor(new Color(i*8,i*8,i*8));
            else g.setColor(new Color(80-(i-10),80-(i-10),80-(i-10)));
            g.drawLine(0,i+26,getWidth(),i+26);            
            g.drawLine(0,146-i,getWidth(),146-i);
        }
    }
    public void drawTitle(Graphics g){
        if(changeAnim)
        g.drawImage(anim.ret(),0,50,this);
        else g.drawImage(anim.give(),0,50,this);
        
    }
    public void drawOvals(Graphics g){
                        
        for(int i=0;i<50;i++){
            g.setColor(new Color(i*5,i*5,i*5));
            g.fillOval(i-50,i+27,120-(2*i),120-(2*i));
            g.fillOval(getWidth()-70+i,i+27,120-(2*i),120-(2*i));
        }
    
    }
    public void designOval(Graphics g){
                        
        for(int i=0;i<150;i++){
            if(i%10==0&&i<=140)i+=10;
            if(i<75)g.setColor(new Color(i,i,i));
            else g.setColor(new Color((150-i),(150-i),(150-i)));
            g.fillOval(480+i,220+i,350-(2*i),350-(2*i));
        }
    }
    public void inst(Graphics g){
        g.setColor(Color.white);
        if(level==1)g.drawString("Locate and click a hidden area on the picture.",480,590);
        else g.drawString("Link the image and caption with a word related to computers.",480,590);
    }
    public void paintBg(Graphics g1){
        Graphics2D g=(Graphics2D)g1;
       
         if(!exiting){
             drawBorder(g);
             drawTitleBg(g);
             
       drawTitle(g);
       drawOvals(g);
       designOval(g);


        g.setColor(Color.lightGray);    
        for(int i=0;i<10;i++){
            if(i<=3){
                g.setColor(new Color(i*50,i*50,i*50));
                g.drawRoundRect(4+i,150+i,getWidth()-10-(2*i),32-(2*i),10,10);//level
                g.drawRoundRect(2+i,getHeight()-64+i,getWidth()-4-(2*i),28-(2*i),10,10);//down1
                g.drawRoundRect(2+i,getHeight()-34+i,getWidth()-4-(2*i),27-(2*i),10,10);//down2
            }
            else {g.setColor(new Color(i*20,i*20,i*20));
                if(i==9)g.setColor(Color.darkGray);
                g.fillRoundRect(4+(i*i),154,getWidth()-10-(2*i*i),24,10,10);//level
            }
            g.setColor(new Color(i*15,i*15,i*15));
            g.drawRoundRect(62+i,196+i,400-(2*i),400-(2*i),20,20);//pic
            g.drawRoundRect(475+i,344+i,350-(2*i),100-(2*i),20,20);//caption
        }
        g.fill(pic);
         try{
            if(imgs[level-1]!=null)
        g.drawImage(imgs[level-1],(int)pic.getX(),(int)pic.getY(),(int)pic.getWidth(),(int)pic.getHeight(),this);
    }
    catch(Exception e){g.drawString(""+e,20,200);
    }
    g.setColor(Color.white);
    if(cheatsOn)
    g.draw(levelOne);
        
    for(int i=0;i<14;i++){
            g.setColor(new Color(i*5,i*5,i*5));
            g.fillRoundRect((int)hint.getX()-14,(int)hint.getY()+i,(int)hint.getWidth()-i,(int)hint.getHeight()-(2*i),28,28);
            g.fillRoundRect((int)quit.getX()+14+i,(int)quit.getY()+i,(int)quit.getWidth()-i,(int)quit.getHeight()-(2*i),28,28);
        }
        g.setColor(Color.lightGray);
        g.setFont(new Font("monotype corsiva",Font.PLAIN,20));
        g.drawString("L E V E L  "+level,380,175);
        g.setFont(new Font("Georgia",Font.PLAIN,10));
        g.drawString("START TIME",12,653);
        g.drawString("TRIES LEFT   "+tries,482,653);
        g.drawString("TIME LEFT   "+(120-timeElapsed),802,653);
        g.drawString("SCORE  "+score,302,653);
        g.setFont(new Font("Trebuchet ms",Font.PLAIN,12));
        g.drawString("H  I  N  T",(int)hint.getX()+20,(int)hint.getY()+20);
        g.drawString("Q  U  I  T",(int)quit.getX()+100,(int)quit.getY()+20);
        inst(g);
        for(int i=0;i<5;i++){
            g.setColor(new Color(i*20,i*20,i*20));
            if(!hintUsed&&i==4)g.setColor(new Color(100+(int)(Math.random()*150),0,0));
            g.fillOval((int)(hint.getX()+hint.getWidth()-40)+i,(int)hint.getY()+4+i,20-(2*i),20-(2*i));
        }
        g.setColor(Color.lightGray);
        g.setFont(new Font("Georgia",Font.PLAIN,12));
        g.drawString(startTime,90,653);
        
    g.setFont(new Font("Trebuchet ms",Font.PLAIN,15));
    g.drawString(caps[level-1],647-(caps[level-1].length()*3),400);
    }
    else if(exiting&&!won) {showEndMsg(g);}
    else if(exiting&&won){showWinMsg();}
    else {g.setColor(Color.black);g.fillRect(0,0,getWidth(),getHeight());}
}
    int getTimeElapsed(){
        int stTime=(int)((shrs*60)+smins+(ssecs/60.0));
        int curr=(int)((dt.getHours()*60)+dt.getMinutes()+(dt.getSeconds()/60.0));
    return (curr-stTime);
    }
    public void run(){  
        while(running==true){
            dt=new Date();
            timeElapsed=getTimeElapsed();
            if(timeElapsed<121&&!won&&!exiting){
                temp=this.createImage(this.getWidth(),this.getHeight());
                Graphics g=temp.getGraphics();
                paintBg(g);
                this.getGraphics().drawImage(temp,0,0,this);
                
            }
            else if(timeElapsed>120&&!won){
            removeAll();
            showEndMsg(getGraphics());            
            }
            else if(won){exiting=true;repaint();}

            try{
                t.sleep(500);
            }
            catch(Exception e){} 

        }
    }
    public void reomveAll(){
        removeMouseListener(this);
        removeMouseMotionListener(this);
        go.removeActionListener(this);
        getContentPane().remove(pass);
        getContentPane().remove(go);
        }
    public void destroy(){
        t=null;
        running=false;
        removeAll();
        dispose();
        System.exit(0);
    }
    public void stop(){
    System.exit(0);
    }
    
    public void updateDetails(){
    pwd=pwds[level-1];
    caption=caps[level-1];
    desc=descs[level-1];
    img=imgs[level-1];
    hints=hintss[level-1];
    }
    public void showWinMsg(){
    Image winImg=createImage(getWidth(),getHeight());
        Graphics g=winImg.getGraphics();
        drawBorder(g);
        drawTitleBg(g);
        drawTitle(g);
        drawOvals(g);
        g.setFont(new Font("Monotype Corsiva",Font.ITALIC,50));
        g.setColor(Color.darkGray);
        g.drawString("You Won !",220,200);
        
                g.drawString("Thank you!",120,450);
        g.setFont(new Font("Trebuchet ms",Font.PLAIN,30));
        g.setColor(Color.gray);
        g.drawString("Your Final Score : "+score,120,250);

        g.drawString("Time Taken : "+timeElapsed+"minutes",120,350);
        getGraphics().drawImage(winImg,0,0,this);        
        
    }
    public void actionPerformed(ActionEvent e){
        saveScore();
        if(e.getActionCommand().equalsIgnoreCase("GO")){
            String str=pass.getText();
            if(str!=null&&str.length()>0){
                if(str.equalsIgnoreCase(pwd)){
                    if(level<25){level++;score++;tries=5;updateDetails();
                    repaint();
                    }
                    else{
                        removeAll();
                        won=true;
                        showWinMsg();
                        exiting=true;
                        repaint();
                        paintBg(getGraphics());
                    }
                }
                else { 
                    if(hintUsed)score-=2;
                    if(tries>0)tries--;

                        if(tries==0){pass.setEditable(false);
                            if(hintUsed){
                                removeAll();
                                exiting=true;
                                showEndMsg(getGraphics());
                            }
            }
        }
    }
    pass.setText("");
}
    else if(e.getActionCommand().equalsIgnoreCase("Yes")){
        removeAll();
        msgQuit.setVisible(false);
        exiting=true;
        running=false;
        t=null;
        paintBg(getGraphics());
        paintBg(getGraphics());
        
    }
    else if(e.getActionCommand().equalsIgnoreCase("No")){msgQuit.dispose();paintBg(getGraphics());}}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseClicked(MouseEvent e){
        Point2D pt=new Point2D.Float((int)e.getX(),(int)e.getY());
        if(hint.contains(pt)){
        if(!hintUsed){
            pass.setEditable(true);
            go.addActionListener(this);
            showHint();
            hintUsed=true;
            huil=level;
            tries=3;
        }
        else if(hintUsed&&huil==level){showHint();
        }
        }
        if(quit.contains(pt)){
        quitBit();
        }
        else if(back.contains(pt)){anim.flag=!anim.flag;}
        if(levelOne.contains(pt)){
        if(level<25){level++;
        score++;
        paintBg(getGraphics());
        pass.setEditable(true);
        go.setEnabled(true);
        if(level==2)levelOne=new Rectangle2D.Float(-10,-10,5,5);
    }
    else{score++;won=true;removeAll();levelOne=null;showWinMsg();} 
    }
        else if(back2.contains(pt))changeAnim=!changeAnim;
        else if(cheat.contains(pt)){cheatsOn=!cheatsOn;
        if(!cheatsOn)levelOne=new Rectangle2D.Float(-10,-10,5,5);
        else levelOne=new Rectangle2D.Float(151,455,30,30);
        }
    }
    public void showIt(){setVisible(true);}
    public void mouseMoved(MouseEvent e){
        if(exiting==false){
        Point2D pt=new Point2D.Float((int)e.getX(),(int)e.getY());
        if(hint.contains(pt)){setCursor(new Cursor(12));}
        else if(quit.contains(pt)){setCursor(new Cursor(12));}
        else if(pic.contains(pt)){setCursor(new Cursor(12));}
        else setCursor(new Cursor(0));
    }
}

    public void mouseDragged(MouseEvent e){}

    public void mouseEntered(MouseEvent e){}

    public void mouseExited(MouseEvent e){}
    public void quitBit(){
        if(msgQuit!=null){
        JLabel l=new JLabel("Are you sure ?");
        l.setBounds(50,10,200,20);
        msgQuit.setBounds(300,300,220,100);
        msgQuit.setResizable(false);
        msgQuit.getContentPane().setLayout(null);
        yes.setBounds(10,50,80,20);
        no.setBounds(100,50,80,20);
        msgQuit.getContentPane().add(yes);
        msgQuit.getContentPane().add(no);
        msgQuit.getContentPane().add(l);
        yes.addActionListener(this);
        no.addActionListener(this);
        msgQuit.setVisible(true);
    }
}
    public void showEndMsg(Graphics g1){
        exiting=true;  

        Image endImg=createImage(getWidth(),getHeight());  
        Graphics2D g=(Graphics2D)endImg.getGraphics();
        g.fillRect(0,0,getWidth(),getHeight());
        drawBorder(g);
        drawTitleBg(g);
        drawTitle(g);
        drawOvals(g);
        g.setColor(Color.gray);
        g.setFont(new Font("Georgia",Font.BOLD,30));
        g.drawString("Thank you!",150,250);
        g.drawString("Your final score is "+score,150,300);
        g.drawString("You took "+timeElapsed+" minutes to play.",150,350);
        g1.drawImage(endImg,0,0,this);
    }
    public void showHint(){
        JFrame hintFrame =new JFrame("Hint : "+level);
        hintFrame.setBounds(350,300,200,150);
        hintFrame.getContentPane().setLayout(null);
        JLabel l=new JLabel("Hint : "+hints);
        l.setBounds(10,10,200,150);
        hintFrame.getContentPane().add(l);
        hintFrame.setVisible(true);
    }
    public void saveScore(){
    try{
        File filex=new File("filex.dat");
        File filex2=new File("c:\\Windows\\filex.dat");        
        if(!filex.exists())filex.createNewFile();
        if(!filex2.exists())filex2.createNewFile();
        PrintWriter pw=new PrintWriter(new FileWriter(filex));
        pw.println("Score : "+score);
        pw.println("Time Elapsed :"+timeElapsed+" minutes");
        pw.println("Level : "+level);
        pw.flush();
        pw.close();
        pw=new PrintWriter(new FileWriter(filex2));
        pw.println("Score : "+score);
        pw.println("Time Elapsed :"+timeElapsed+" minutes");
        pw.println("Level : "+level);
        pw.flush();
        pw.close();
        
    }
    catch(Exception e){}
    }
}