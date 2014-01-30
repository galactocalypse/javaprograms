 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;

/* FrameDemo.java requires no other files. */
public class P  extends JApplet implements ActionListener{
JFrame frame = new JFrame("Password");
JButton b=new JButton("Enter");
JLabel emptyLabel = new JLabel("Enter Password :");
JPasswordField t=new JPasswordField(20);
    public void ask(){
        frame.setSize(130, 100);
        frame.getContentPane().setLayout(null);
        frame.setBounds(100,100,100,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(b);
        emptyLabel.setBounds(0,0,100,20);
        t.setBounds(0,30,120,30);
        b.setBounds(100,50,80,30);
        emptyLabel.setPreferredSize(new Dimension(130, 100));
        frame.getContentPane().add(emptyLabel);
        
        frame.getContentPane().add(t);
        frame.pack();
        frame.setVisible(true);
    }
    
   public static void main(){
       P p=new P();
       p.ask();
    }
        public void actionPerformed(ActionEvent e){
            String s=t.getText();
        
    }
}
