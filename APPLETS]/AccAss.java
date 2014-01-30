import java.awt.*;
import java.applet.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
    public class AccAss extends Applet implements ActionListener{
        Calculator cal=new Calculator();
        Paint2 p=new Paint2();
        DigitalClock clox=new DigitalClock();
        WeekScheduler sch=new WeekScheduler();
        Button go;
        CheckboxGroup options=new CheckboxGroup();
        Checkbox calc,paint,sched,clock;
        AudioClip clip;
        String clr="";
     public void init(){
         setLayout(null);
         setSize(360,400);
     calc=new Checkbox("     CALCULATOR",options,true);
     sched=new Checkbox("     WEEKLY SCHEDULER",options,false);
     clock=new Checkbox("     CLOCK",options,false);
     paint=new Checkbox("     PAINT",options,false);
     clip=getAudioClip(getCodeBase(),"open.wav");
     clip.play();
     go=new Button("   Go   ");
     calc.setBounds(30,100,150,30);
     sched.setBounds(30,160,150,30);
     clock.setBounds(30,220,150,30);
     paint.setBounds(30,280,150,30);
     go.setBounds(140,340,110,30);
          
     calc.setBackground(Color.pink);
     sched.setBackground(Color.pink);
     clock.setBackground(Color.pink);
     paint.setBackground(Color.pink);
     go.setBackground(Color.pink);
     add(cal);
     add(sch);
     add(clox);
     add(p);
     add(calc);
     add(clock);
     add(sched);
     add(paint);
     
     add(go); 
     go.addActionListener(this);
    }
     public void paint(Graphics g){
         if(clr=="clr"){
             g.fillRect(0,0,500,500);
             clr="";
            }
         setBackground(Color.pink);
         g.setFont(new Font("Impact",Font.PLAIN,30));
         g.drawString("ACCESSORY ASSORTMENT",20,50);
         g.drawRect(10,10,340,380);
         g.drawLine(10,60,350,60);
         g.drawRect(15,65,330,320);
         g.drawLine(15,330,345,330);
        }
      public void actionPerformed(ActionEvent evt){
          if(evt.getSource()==go){
              if(calc.getState()==true){
                  setSize(300,480);
                  cal.init();
            }
            else if(paint.getState()){
                setSize(400,500);
                p.init();
            }
            else if(sched.getState()){
                setSize(350,300);
                sch.init();
            }    
            else if(clock.getState()){
                setSize(132,60);
                clox.init();
            }
          
        }
    }


/*
   A simple program where the user can sketch curves in a variety of
   colors on a variety of background colors.  The user selects
   a drawing color form a pop-up menu at the bottom of the
   applet.  If the user clicks "Set Background", the background
   color is set to the current drawing color and the drawing
   area is filled with that color.  If the user clicks "Clear",
   the drawing area is just filled with the current background color.

   The user's drawing is not persistant.  It is cleared if the
   applet is resized.  If it is covered, in whole or part, and
   then uncovered, the part was covered is gone.
   
   (When this file is compiled, two class files are produced:
   SimplePaint2.class and SimplePaint2$SimplePaintCanvas.class.
   Both class files are necessary to use the applet.)
*/




public class Paint2 extends JApplet {

   JComboBox colorChoice;  // This is a member variable since the "canvas"
                           // needs access to this pop-up menu so that it
                           // will know what color to use.

   public void init() {
       setSize(500,500);
      setBackground(Color.gray);         // Background color of applet.
      
      SimplePaintCanvas canvas = new SimplePaintCanvas();  // The drawing area.
      getContentPane().add(canvas,BorderLayout.CENTER);
      
      JPanel buttonBar = new JPanel();       // A panel to hold the controls.
      buttonBar.setBackground(Color.gray);
      getContentPane().add(buttonBar, BorderLayout.SOUTH);
      
      colorChoice = new JComboBox();  // The pop-up menu of available colors.
      colorChoice.addItem("Black");
      colorChoice.addItem("Red");
      colorChoice.addItem("Green");
      colorChoice.addItem("Blue");
      colorChoice.addItem("Cyan");
      colorChoice.addItem("Magenta");
      colorChoice.addItem("Yellow");
      colorChoice.addItem("White");
      colorChoice.setBackground(Color.white);
      buttonBar.add(colorChoice);
      
      JButton fill = new JButton("Set Background");  // The first button.
      fill.addActionListener(canvas);
      fill.setBackground(Color.lightGray);
      buttonBar.add(fill);
      
      JButton clear = new JButton("Clear");   // The second button.
      clear.addActionListener(canvas);
      clear.setBackground(Color.lightGray);
      buttonBar.add(clear);
      
   }  // end init()



   // ----------------- Nested class definition --------------------------------

   class SimplePaintCanvas extends JPanel 
                    implements MouseListener, MouseMotionListener, ActionListener {

           // A SimplePaintCanvas lets the user use the mouse to draw colored
           // curves.  The current color is specified by a pop-up menu which
           // must be created by the applet and assigned to the instance variable
           // colorChoice.  The applet listens for action events from buttons
           // named "Clear" and "Set Background".  The "Clear" button fills
           // the canvas with the current background color.  The "Set Background"
           // sets the background color to the current drawing color and
           // then clears.


      private final static int 
                  BLACK = 0,
                  RED = 1,            // Some constants to make
                  GREEN = 2,          // the code more readable.
                  BLUE = 3,           // These numbers code for
                  CYAN = 4,           // the differnet drawing colors.
                  MAGENTA = 5,
                  YELLOW = 6;

      /* The following variables are used when the user is sketching a
         curve while dragging a mouse. */

      private int prevX, prevY;     // The previous location of the mouse.

      private boolean dragging;      // This is set to true while the user is drawing.

      private Graphics graphicsForDrawing;  // A graphics context for the applet
                                            // that is used to draw the user's curve.
                                            // (It's not supposed to be good form
                                            // to draw directly onto a component.
                                            // The official recommendation is to do
                                            // all drawing in the paintComponent()
                                            // method.  But this does work.)

      SimplePaintCanvas() {
             // Constructor.  When the canvas is first created, it is set to
             // listen for mouse events and mouse motion events from
             // itself.  The initial background color is white.
         addMouseListener(this);
         addMouseMotionListener(this);
         setBackground(Color.white);
      }


      public void actionPerformed(ActionEvent evt) {
              // Respond when the user clicks on a button.
         String command = evt.getActionCommand();
         if (command.equals("Clear")) {
                // Clear to current background color.
            repaint();
         }
         else if (command.equals("Set Background")) {
                // Set background color, then clear.
                // Also change the selected color so it is
                // not the same as the background color.
                // Change it to black, unless the background is
                // black; in that case change it to white.
            setBackground(getCurrentColor());
            if (colorChoice.getSelectedIndex() == 0)
               colorChoice.setSelectedIndex(7);
            else
               colorChoice.setSelectedIndex(0);
            repaint();
         }
      }


      private Color getCurrentColor() {
               // Check the colorChoice menu to find the currently
               // selected color, and return the appropriate color
               // object.
         int currentColor = colorChoice.getSelectedIndex();
         switch (currentColor) {
            case BLACK:
               return Color.black;
            case RED:
               return Color.red;
            case GREEN:
               return Color.green;
            case BLUE:
               return Color.blue;
            case CYAN:
               return Color.cyan;
            case MAGENTA:
               return Color.magenta;
            case YELLOW:
               return Color.yellow;
            default:
               return Color.white;
         }
      }


      public void mousePressed(MouseEvent evt) {
              // This is called when the user presses the mouse on the
              // canvas.  This begins a draw operation in which the user
              // sketches a curve.

         if (dragging == true)  // Ignore mouse presses that occur
             return;            //    when user is already drawing a curve.
                                //    (This can happen if the user presses
                                //    two mouse buttons at the same time.)

         prevX = evt.getX();    // Start drawing.
         prevY = evt.getY();
         dragging = true;
         graphicsForDrawing = getGraphics();
         graphicsForDrawing.setColor(getCurrentColor());

      } // end mousePressed()


      public void mouseReleased(MouseEvent evt) {
              // Called whenever the user releases the mouse button.
              // If the user was drawing a curve, the curve is done,
              // so we should set drawing to false and get rid of
              // the graphics context that we created to use during
              // the drawing.
          if (dragging == false)
             return;  // Nothing to do because the user isn't drawing.
          dragging = false;
          graphicsForDrawing.dispose();
          graphicsForDrawing = null;
      }


      public void mouseDragged(MouseEvent evt) {
               // Called whenever the user moves the mouse
               // while a mouse button is held down.  If the
               // user is drawing, draw a line segment from the
               // previous mouse location to the current mouse
               // location, and set up prevX and prevY for the
               // next call. 

          if (dragging == false)
             return;  // Nothing to do because the user isn't drawing.

          int x = evt.getX();   // x-coordinate of mouse.
          int y = evt.getY();   // y=coordinate of mouse.

          graphicsForDrawing.drawLine(prevX, prevY, x, y);  // Draw the line.

          prevX = x;  // Get ready for the next line segment in the curve.
          prevY = y;

      } // end mouseDragged.


      public void mouseEntered(MouseEvent evt) { }   // Some empty routines.
      public void mouseExited(MouseEvent evt) { }    //    (Required by the MouseListener
      public void mouseClicked(MouseEvent evt) { }   //    and MouseMotionListener
      public void mouseMoved(MouseEvent evt) { }     //    interfaces).


   } // end class SimplePaintCanvas


} // end class SimplePaint2

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
    {   setBackground(Color.black);
        setLayout(null);
        setSize(300,480);
        setFont(f1);
    b1=new Button("1");    b2=new Button("2");    b3=new Button("3");    b4=new Button("4");    b5=new Button("5");    b6=new Button("6");
    b7=new Button("7");    b8=new Button("8");    b9=new Button("9");    b0=new Button("0");    plus =new Button("+");    minus=new Button("-");
    multiply=new Button("*");    divide=new Button("/");    clear=new Button("Clear");
    result=new Button("Result");    reset=new Button("Reset");        b1.setBounds(20,140,50,40);    b2.setBounds(80,140,50,40);    b3.setBounds(140,140,50,40);
    b4.setBounds(200,140,50,40);    b5.setBounds(20,200,50,40);    b6.setBounds(80,200,50,40);    b7.setBounds(140,200,50,40);
    b8.setBounds(200,200,50,40);    b9.setBounds(80,260,50,40);    b0.setBounds(140,260,50,40);        plus.setBounds(20,330,50,40);
    minus.setBounds(80,330,50,40);    multiply.setBounds(140,330,50,40);    divide.setBounds(200,330,50,40);
    reset.setBounds(20,380,120,30);    result.setBounds(160,380,120,30);  clear.setBounds(190,80,120,30);
        
        formula.setFont(f2);      formula.setEditable(false);    formula.setBounds(10,80,160,34);
    add(formula);
    
    
    add(b1); add(b2);    add(b3);    add(b4);    add(b5);    add(b6);    add(b7);    add(b8);    add(b9);    add(b0);    add(plus);    add(minus);
    add(multiply);    add(divide);    add(clear);    add(reset);    add(result);
        b1.addActionListener(this);        b2.addActionListener(this);        b3.addActionListener(this);        b4.addActionListener(this);        b5.addActionListener(this);        b6.addActionListener(this);        b7.addActionListener(this);        b8.addActionListener(this);        b9.addActionListener(this);        b0.addActionListener(this);        plus.addActionListener(this);        minus.addActionListener(this);        multiply.addActionListener(this);        divide.addActionListener(this);        reset.addActionListener(this);        clear.addActionListener(this);        result.addActionListener(this);
 }
    public void paint(Graphics g){        g.setColor(Color.white);
        g.setFont(new Font("Xenotron",Font.PLAIN,30));
        g.drawString("CALCULATOR",10,20);    
}
       public void actionPerformed(ActionEvent evt){           
        String cmdsrc = evt.getActionCommand();        //1-0
        if(cmdsrc.equals("1")||cmdsrc.equals("2")||cmdsrc.equals("3")||cmdsrc.equals("4")||cmdsrc.equals("5")||cmdsrc.equals("6")||cmdsrc.equals("7")||cmdsrc.equals("8")||cmdsrc.equals("9")||cmdsrc.equals("0"))  {
        formula.setText(formula.getText()+cmdsrc);        }
        //clear
        else if(cmdsrc.equalsIgnoreCase("clear"))
        formula.setText("");        //+-*/
        else if(cmdsrc=="+"||cmdsrc=="-"||cmdsrc=="*"||cmdsrc=="/"){ 
            if(num1!=0&&num2!=0){
            if(operator=="+")           res=num1+num2;
            else if(operator=="-")            res=num1-num2;
            else if(operator=="*")            res=num1*num2;
            else if(operator=="/")            res=num1/num2;
            formula.setText(""+res);            num1=res;
            num2=0;        }    
                
            else if(num1==0&&num2==0){
            num1=Float.parseFloat(formula.getText());        
        }
        else num2=Integer.parseInt(formula.getText());
        formula.setText("");            operator=cmdsrc;
        } 

           //result
          else if(cmdsrc.equalsIgnoreCase("result")){ 
            num2=Float.parseFloat(formula.getText());
            if(operator=="+")           res=num1+num2;
            else if(operator=="-")            res=num1-num2;
            else if(operator=="*")            res=num1*num2;
            else if(operator=="/")            res=num1/num2;
            formula.setText(""+res);            num1=res;
            num2=0;        }    
        else if(cmdsrc.equalsIgnoreCase("reset")){
            str=str1=str2=cmdsrc="";            formula.setText("");
            num1=num2=res=0;        }
           }
           


public class WeekScheduler extends Applet implements ActionListener{
GregorianCalendar gc=new GregorianCalendar();
int input;
Font f1=new Font("Georgia",Font.BOLD,20);
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
clip.play();
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
setLayout(null);setBackground(Color.orange);clr.setBounds(130,260,100,30);
setEvent=new Button("Add Event");getmonth=new TextField();setEvent.setBounds(230,220,100,28);
getmonth.setBounds(20,220,200,28);add(getmonth);add(clr);
add(setEvent);setEvent.addActionListener(this);clr.addActionListener(this);
}
public void actionPerformed(ActionEvent evt){
String cmd=evt.getActionCommand();
if(cmd.equalsIgnoreCase("clear")){
events="";
    }
    else {if(events!="")
events=events+" ; "+getmonth.getText();else events=events+" "+getmonth.getText();}
getmonth.setText("");
repaint();    }
}public class DigitalClock extends Applet implements Runnable{
Thread t;
GregorianCalendar gc;
boolean running=true;
String time="00:00:00";
TextField text;
public void init(){
setSize(132,60);
setLayout(null);
setFont(new Font("Georgia",Font.BOLD,30));
setBackground(Color.yellow);
text=new TextField();
text.setBackground(Color.yellow);
text.setEditable(false);
text.setBounds(2,2,130,88);
add(text);
t=new Thread(this);
t.start();}
public void run(){
while(running){gc=new GregorianCalendar();
time = gc.get(Calendar.HOUR)+":"+gc.get(Calendar.MINUTE)+":"+gc.get(Calendar.SECOND);text.setText(time);
try{t.sleep(500);}
catch(InterruptedException e){System.out.println(e);}}}
public void destroy(){
running=false;t=null;}}
     
    }}