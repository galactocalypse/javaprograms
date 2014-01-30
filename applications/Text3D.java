import java.awt.*;
import java.applet.*;
import java.awt.event.*;
    public class Text3D extends Applet implements ActionListener{
        String sr="3D TEXT";
        Button set=new Button("Set");
        Color c;
        int fs=30;
        TextField text,fontSize=new TextField("Size"),depth=new TextField("Depth");
        int i,s=25,x=50,y=50;
        CheckboxGroup dir=new CheckboxGroup();
        Checkbox upleft,upright,dwnlt,dwnrt;
    public void init(){
        setLayout(null);
        text=new TextField("ada");            
        upleft=new Checkbox("North-West",dir,true);
        upright=new Checkbox("North-East",dir,false);
        dwnlt=new Checkbox("South-West",dir,false);
        dwnrt=new Checkbox("South-East",dir,false);
        set.addActionListener(this);
        text.setBounds(10,10,100,30);
        depth.setBounds(120,10,50,30);
        fontSize.setBounds(160,10,50,30);        
        set.setBounds(200,10,80,30);
        upleft.setBounds(10,50,80,30);
        upright.setBounds(100,50,80,30);
        dwnlt.setBounds(190,50,80,30);
        dwnrt.setBounds(280,50,80,30);
        add(text);        
        add(set);
        add(fontSize);
        add(depth);
        add(upleft);
        add(upright);
        add(dwnlt);
        add(dwnrt);
        
    }
    public void paint(Graphics g){
            x=200;y=300;
            g.setFont(new Font("Georgia",Font.BOLD,fs));
            for(i=0;i<s;i++){
                if(i==s-1)g.setColor(Color.red);else 
                g.setColor(Color.gray);
                stat();
                g.drawString(sr.toUpperCase(),x,y);
            }
        }
        public void actionPerformed(ActionEvent e){
            String act=e.getActionCommand().toLowerCase();
            if((text.getText())!="")
                sr=text.getText();
                    else sr="3D TEXT";
            try{
                    s=(int)(Double.parseDouble(depth.getText()));
                }
            catch(Exception ex){
                depth.setText("Invalid entry! Enter a number");
            }   
            try{
                fs=(int)(Integer.parseInt(fontSize.getText()));
            }
            catch(Exception ex){
                fontSize.setText("Invalid Entry1");
            }               
        repaint();
    }
    public void stat(){
        
            if(upleft.getState()){y--;x--;}
                else if(upright.getState()){y--;x++;}
                else if(dwnlt.getState()){y++;x--;}
                else {x++;y++;}
            }
}