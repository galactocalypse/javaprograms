import java.awt.*;
import java.awt.event.*;
import java.applet.*;



public class Calculator extends Applet implements ActionListener{
    String str1="",str2="";
    double res;
    Font f1=new Font("Impact",Font.BOLD,30);
    Font f2=new Font("Arial",Font.PLAIN,16);
    String operator,str;
    TextField formula=new TextField(15);
    double num1,num2;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,plus, minus, multiply,divide,result,reset,clear;

    public void init()
    {
        setBackground(Color.black);
        setLayout(null);
        setSize(300,480);
        setFont(f1);
    b1=new Button("1");
    b2=new Button("2");
    b3=new Button("3");
    b4=new Button("4");
    b5=new Button("5");
    b6=new Button("6");
    b7=new Button("7");
    b8=new Button("8");
    b9=new Button("9");
    b0=new Button("0");
    plus =new Button("+");
    minus=new Button("-");
    multiply=new Button("*");
    divide=new Button("/");
    clear=new Button("Clear");
    result=new Button("Result");
    reset=new Button("Reset");
    
    b1.setBounds(20,140,50,40);
    b2.setBounds(80,140,50,40);
    b3.setBounds(140,140,50,40);
    b4.setBounds(200,140,50,40);
    b5.setBounds(20,200,50,40);
    b6.setBounds(80,200,50,40);
    b7.setBounds(140,200,50,40);
    b8.setBounds(200,200,50,40);
    b9.setBounds(80,260,50,40);
    b0.setBounds(140,260,50,40);    
    plus.setBounds(20,330,50,40);
    minus.setBounds(80,330,50,40);
    multiply.setBounds(140,330,50,40);
    divide.setBounds(200,330,50,40);
    reset.setBounds(20,380,120,30);
    result.setBounds(160,380,120,30);
    clear.setBounds(190,80,120,30);
        
        
    formula.setFont(f2);  
    formula.setEditable(false);
    formula.setBounds(10,80,160,34);
    add(formula);
    
    
    add(b1);
    add(b2);
    add(b3);
    add(b4);
    add(b5);
    add(b6);
    add(b7);
    add(b8);
    add(b9);
    add(b0);
    add(plus);
    add(minus);
    add(multiply);
    add(divide);
    add(clear);
    add(reset);
    add(result);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        b0.addActionListener(this);
        plus.addActionListener(this);
        minus.addActionListener(this);
        multiply.addActionListener(this);
        divide.addActionListener(this);
        reset.addActionListener(this);
        clear.addActionListener(this);
        result.addActionListener(this);

                    
          }
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("Xenotron",Font.PLAIN,30));
        g.drawString("CALCULATOR",10,20);
    
}
       public void actionPerformed(ActionEvent evt){
           
        String cmdsrc = evt.getActionCommand();
        //1-0
        if(cmdsrc.equals("1")||cmdsrc.equals("2")||cmdsrc.equals("3")||cmdsrc.equals("4")||cmdsrc.equals("5")||cmdsrc.equals("6")||cmdsrc.equals("7")||cmdsrc.equals("8")||cmdsrc.equals("9")||cmdsrc.equals("0"))  {
        formula.setText(formula.getText()+cmdsrc);
        }
        //clear
        else if(cmdsrc.equalsIgnoreCase("clear"))
        formula.setText("");
        //+-*/
        else if(cmdsrc=="+"||cmdsrc=="-"||cmdsrc=="*"||cmdsrc=="/"){    
            if(num1==0&&num2==0){
            num1=Float.parseFloat(formula.getText());        
        }
        else num2=Integer.parseInt(formula.getText());
        formula.setText("");
            operator=cmdsrc;
        }   
        //result
        else if(cmdsrc.equalsIgnoreCase("result")){
             num2=Float.parseFloat(formula.getText());
            if(operator=="+")
            res=num1+num2;
            else if(operator=="-")
            res=num1-num2;
            else if(operator=="*")
            res=num1*num2;
            else if(operator=="/")
            res=num1/num2;
            formula.setText(""+res);
            num1=res;
            num2=0;
        }    
        else if(cmdsrc.equalsIgnoreCase("reset")){
            str=str1=str2=cmdsrc="";
            formula.setText("");
            num1=num2=res=0;
        }
           }
}
