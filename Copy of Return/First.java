import java.awt.*;
import java.applet.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.io.*;

public class First implements ActionListener{
 JFrame f;
 TextArea name;
 TextField invnum,date,odate,cdate,orderno,chlno,buyvat,lorrynum,rrno,qty,rate,per,vat,cst,fright,particulars,rrdt;
 JLabel lname,linvnum,ldate,lorderno,lcdate,lodate,lchlno,lbuyvat,llorrynum,lrrno,lqty,lparticulars,lrate,lvat,lcst,lfright,lrrdt,lper;
 String n,inum,dt,odt,cdt,odno,chno,bvat,lnum,rrn,qtty,pts,rt,vt,cent,rdt,pr,frgt;
 List ql,ptclrs,rates,pers,amts;
 Button reset,submit,print,addPtr,rem,calculate;
 boolean isSel;
 static First first;
 public static void main(String args[]){
     first=new First();
     first.isSel=false;

first.f=new JFrame("Input");
first.f.setBounds(0,0,800,600);
first.f.setDefaultCloseOperation(first.f.EXIT_ON_CLOSE);
first.f.getContentPane().setLayout(null);
first.reset=new Button("Reset");
first.submit=new Button("Save");
first.addPtr=new Button("Add");
first.rem=new Button("Remove");
first.calculate=new Button("Calculate");

first.addPtr.setBounds(400,220,40,20);
first.submit.setBounds(360,370,60,20);
first.addPtr.addActionListener(first);
first.submit.addActionListener(first);
first.reset.setBounds(430,370,60,20);
first.reset.addActionListener(first);
first.rem.setBounds(450,220,40,20);
first.rem.addActionListener(first);
first.calculate.setBounds(450,220,40,20);
first.calculate.addActionListener(first);

first.ql=new List();
first.ql.addActionListener(first);
first.ql.addItem("QUantiTY");
first.ql.setBounds(10,250,40,100);

first.rates=new List();
first.rates.addActionListener(first);
first.rates.addItem("rates");
first.rates.setBounds(310,250,50,100);

first.ptclrs=new List();
first.ptclrs.addActionListener(first);
first.ptclrs.addItem("ptclrs");
first.ptclrs.setBounds(60,250,240,100);


first.pers=new List();
first.pers.addActionListener(first);
first.pers.addItem("pers");
first.pers.setBounds(370,250,50,100);

first.amts=new List();
first.amts.addItem("Amts");
first.amts.setBounds(430,250,60,100);

first.name=new TextArea();
first.invnum=new TextField();
first.date=new TextField();
first.cdate=new TextField();
first.odate=new TextField();
first.orderno=new TextField();
first.chlno=new TextField();
first.buyvat=new TextField();
first.lorrynum=new TextField();
first.rrno=new TextField();
first.qty=new TextField();
first.particulars=new TextField();
first.rate=new TextField();
first.vat=new TextField();
first.cst=new TextField();
first.fright=new TextField();
first.rrdt=new TextField();
first.per=new TextField();

first.lname=new JLabel("M/s");
first.linvnum=new JLabel("Invoice No.");
first.ldate=new JLabel("Date");
first.lcdate=new JLabel("Challan Date");
first.lodate=new JLabel("Order Date");
first.lorderno=new JLabel("Order No.");
first.lchlno=new JLabel("Challan No.");
first.lbuyvat=new JLabel("Buyer's vat");
first.llorrynum=new JLabel("Lorry No.");
first.lrrno=new JLabel("R/R No.");
first.lqty=new JLabel("Quantity");
first.lparticulars=new JLabel("Particulars");
first.lrate=new JLabel("Rate");
first.lvat=new JLabel("VAT");
first.lcst=new JLabel("CST");
first.lfright=new JLabel("Fright");
first.lrrdt=new JLabel("R/R Date");
first.lper=new JLabel("PER");

first.name.setBounds(10,60,150,100);
first.invnum.setBounds(175,60,150,20);
first.date.setBounds(340,60,150,20);
first.orderno.setBounds(175,100,150,20);
first.chlno.setBounds(340,100,150,20);
first.buyvat.setBounds(10,180,110,20);
first.lorrynum.setBounds(135,180,110,20);
first.rrno.setBounds(260,180,110,20);
first.qty.setBounds(10,220,40,20);
first.particulars.setBounds(60,220,210,20);
first.rate.setBounds(280,220,50,20);
first.vat.setBounds(10,370,60,20);
first.cst.setBounds(90,370,60,20);
first.fright.setBounds(160,370,60,20);
first.cdate.setBounds(340,140,150,20);
first.odate.setBounds(175,140,150,20);
first.rrdt.setBounds(380,180,110,20);
first.per.setBounds(340,220,50,20);

first.lname.setBounds(15,40,150,20);
first.linvnum.setBounds(180,40,50,20);
first.ldate.setBounds(345,40,50,20);
first.lorderno.setBounds(180,80,50,20);
first.lodate.setBounds(180,120,50,20);
first.lcdate.setBounds(345,120,50,20);
first.lchlno.setBounds(345,80,50,20);
first.lbuyvat.setBounds(15,160,50,20);
first.llorrynum.setBounds(140,160,50,20);
first.lrrno.setBounds(265,160,50,20);
first.lqty.setBounds(15,200,50,20);
first.lparticulars.setBounds(75,200,50,20);
first.lrate.setBounds(325,200,50,20);
first.lvat.setBounds(15,350,50,20);
first.lcst.setBounds(95,350,50,20);
first.lfright.setBounds(170,350,50,20);
first.lrrdt.setBounds(385,160,50,20);
first.lper.setBounds(385,200,50,20);

first.f.getContentPane().add(first.name);
first.f.getContentPane().add(first.invnum);
first.f.getContentPane().add(first.date);
first.f.getContentPane().add(first.orderno);
first.f.getContentPane().add(first.chlno);
first.f.getContentPane().add(first.buyvat);
first.f.getContentPane().add(first.lorrynum);
first.f.getContentPane().add(first.rrno);
first.f.getContentPane().add(first.qty);
first.f.getContentPane().add(first.particulars);
first.f.getContentPane().add(first.rate);
first.f.getContentPane().add(first.vat);
first.f.getContentPane().add(first.cst);
first.f.getContentPane().add(first.fright);
first.f.getContentPane().add(first.cdate);
first.f.getContentPane().add(first.odate);
first.f.getContentPane().add(first.rrdt);
first.f.getContentPane().add(first.per);

first.f.getContentPane().add(first.lname);
first.f.getContentPane().add(first.linvnum);
first.f.getContentPane().add(first.ldate);
first.f.getContentPane().add(first.lorderno);
first.f.getContentPane().add(first.lchlno);
first.f.getContentPane().add(first.lbuyvat);
first.f.getContentPane().add(first.llorrynum);
first.f.getContentPane().add(first.lrrno);
first.f.getContentPane().add(first.lqty);
first.f.getContentPane().add(first.lparticulars);
first.f.getContentPane().add(first.lrate);
first.f.getContentPane().add(first.lvat);
first.f.getContentPane().add(first.lcst);
first.f.getContentPane().add(first.lfright);
first.f.getContentPane().add(first.lcdate);
first.f.getContentPane().add(first.lodate);
first.f.getContentPane().add(first.lrrdt);
first.f.getContentPane().add(first.lper);

first.f.getContentPane().add(first.ql);
first.f.getContentPane().add(first.pers);
first.f.getContentPane().add(first.rates);
first.f.getContentPane().add(first.ptclrs);
first.f.getContentPane().add(first.amts);


first.f.getContentPane().add(first.addPtr);
first.f.getContentPane().add(first.submit);
first.f.getContentPane().add(first.reset);
first.f.getContentPane().add(first.rem);
first.f.getContentPane().add(first.calculate);

first.f.setVisible(true);
}
public void takeVals(){
n=name.getText();
inum=invnum.getText();
dt=date.getText();
odt=odate.getText();
cdt=cdate.getText();
rdt=rrdt.getText();
odno=orderno.getText();
chno=chlno.getText();
bvat=buyvat.getText();
lnum=lorrynum.getText();
rrn=rrno.getText();
qtty=qty.getText();
pts=particulars.getText();
rt=rate.getText();
vt=vat.getText();
cent=cst.getText();
frgt=fright.getText();
}
public void actionPerformed(ActionEvent e){
String str=e.getActionCommand();
    if(str.equalsIgnoreCase("ADD")){
        if(checkI(qty.getText())&&checkD(rate.getText())&&checkD(per.getText())&&checkD(vat.getText())&&checkD(cst.getText())&&checkD(fright.getText())&&particulars.getText().length()>0){
            ql.addItem(qty.getText());
            ptclrs.addItem(particulars.getText());
            rates.addItem(rate.getText());
            pers.addItem(per.getText());
            int q=Integer.parseInt(qty.getText());
            double r=Double.parseDouble(rate.getText());
            double p=Integer.parseInt(per.getText());
            double vt=Double.parseDouble(vat.getText());
            double ct=Double.parseDouble(cst.getText());
            double frt=Double.parseDouble(fright.getText());    
            String h=""+getAmt(q,r,p);
            amts.addItem(""+h);
        }
        isSel=false;
    }
    else if(str.equalsIgnoreCase("Remove")){
        if(isSel){
            int index=ql.getSelectedIndex();
            ql.remove(index);
            amts.remove(index);
            rates.remove(index);
            pers.remove(index);
            ptclrs.remove(index);
            isSel=false;
        }
    }
    else if(e.getSource() instanceof java.awt.List){
        int index=((java.awt.List)e.getSource()).getSelectedIndex();
        amts.select(index);
        ql.select(index);
        rates.select(index);
        pers.select(index);
        ptclrs.select(index);
        isSel=true;
    }
}
    public double getTotal(){
        double a=0;
        for(int i=0;i<amts.getRows();i++){
            a=a+Double.parseDouble(amts.getItem(i));
        }
        return a;
    }
    public double getGTotal(){
        double a=getTotal();
        a=a*(100+Double.parseDouble(vt)+Double.parseDouble(cent)+Double.parseDouble(frgt))/100;
        return a;
    }
    public double getAmt(int q,double r,double p){
        return (q*r);
    }

public boolean checkD(String s){
try{
double s1=Double.parseDouble(s);
return true;
}
catch(Exception e){}
return false;
}

public boolean checkI(String s){
try{
int s1=Integer.parseInt(s);
return true;
}
catch(Exception e){}
return false;
}
}