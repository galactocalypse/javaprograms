import java.awt.*;
import java.applet.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.io.*;

public class First implements ActionListener{
 JFrame f;
 PrinterObj prnt;
 boolean saved=false;
 TextArea name;
 TextField invnum,date,odate,cdate,orderno,chlno,buyvat,lorrynum,rrno,qty,rate,per,vat,cst,fright,particulars,rrdt;
 JLabel lname,linvnum,ldate,lorderno,lcdate,lodate,lchlno,lbuyvat,llorrynum,lrrno,lqty,lparticulars,lrate,lvat,lcst,lfright,lrrdt,lper;
 String n,inum,dt,odt,cdt,odno,chno,bvat,lnum,rrn,qtty,pts,rt,vt,cent,rdt,pr,frgt;
 List ql,ptclrs,rates,pers,amts;
 int arraysize=0;
 String[] qla,ptclrsa,ratesa,persa,amtsa;
 Button reset,submit,print,addPtr,rem,calculate;
 boolean isSel;
 static First first;
 public static void main(String args[]){
     first=new First();
     first.isSel=false;

first.f=new JFrame("Input");
first.f.setBounds(0,0,540,460);
first.f.setDefaultCloseOperation(first.f.EXIT_ON_CLOSE);
first.f.getContentPane().setLayout(null);
first.reset=new Button("Reset");
first.submit=new Button("Save");
first.addPtr=new Button("Add");
first.print=new Button("Print");
first.rem=new Button("Del");
first.calculate=new Button("Calculate");
first.arraysize=0;
first.prnt=new PrinterObj();

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
first.print.setBounds(300,370,40,20);
first.print.addActionListener(first);

first.ql=new List();
first.ql.addActionListener(first);
first.ql.setBounds(10,250,40,100);

first.rates=new List();
first.rates.addActionListener(first);
first.rates.setBounds(310,250,50,100);

first.ptclrs=new List();
first.ptclrs.addActionListener(first);
first.ptclrs.setBounds(60,250,240,100);


first.pers=new List();
first.pers.addActionListener(first);
first.pers.setBounds(370,250,50,100);

first.amts=new List();
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
first.linvnum.setBounds(180,40,80,20);
first.ldate.setBounds(345,40,80,20);
first.lorderno.setBounds(180,80,100,20);
first.lodate.setBounds(180,120,100,20);
first.lcdate.setBounds(345,120,100,20);
first.lchlno.setBounds(345,80,100,20);
first.lbuyvat.setBounds(15,160,100,20);
first.llorrynum.setBounds(140,160,100,20);
first.lrrno.setBounds(265,160,100,20);
first.lqty.setBounds(15,200,100,20);
first.lparticulars.setBounds(75,200,100,20);
first.lrate.setBounds(285,200,100,20);
first.lvat.setBounds(15,350,100,20);
first.lcst.setBounds(95,350,100,20);
first.lfright.setBounds(170,350,100,20);
first.lrrdt.setBounds(385,160,50,20);
first.lper.setBounds(345,200,50,20);

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
first.f.getContentPane().add(first.print);

first.f.setVisible(true);
}
public String[] takeVals(){
String saveStr[]=new String[17+ql.countItems()];

    try{
    saveStr[1]=n=name.getText();
saveStr[2]=inum=invnum.getText();
saveStr[3]=dt=date.getText();
saveStr[4]=odt=odate.getText();
saveStr[5]=cdt=cdate.getText();
saveStr[6]=rdt=rrdt.getText();
saveStr[7]=odno=orderno.getText();
saveStr[8]=chno=chlno.getText();
saveStr[9]=bvat=buyvat.getText();
saveStr[10]=lnum=lorrynum.getText();
saveStr[11]=rrn=rrno.getText();
saveStr[12]=qtty=qty.getText();
saveStr[13]=pts=particulars.getText();
saveStr[14]=rt=rate.getText();
saveStr[15]=vt=vat.getText();
saveStr[16]=cent=cst.getText();
saveStr[17]=frgt=fright.getText();

for(int i=0;i<ql.countItems();i++){
qla[i]=ql.getItems()[i];
ptclrsa[i]=ptclrs.getItems()[i];
ratesa[i]=rates.getItems()[i];
persa[i]=pers.getItems()[i];
amtsa[i]=amts.getItems()[i];
saveStr[18+i]=qla[i]+"   "+ptclrsa[i]+"    "+ratesa[i]+"    "+persa[i]+"    "+amtsa[i];
    }
}
catch(Exception e){}
    
return saveStr;

}
public void actionPerformed(ActionEvent e){
String str=e.getActionCommand();
    if(str.equalsIgnoreCase("ADD")){
        if(checkI(qty.getText())&&checkD(rate.getText())&&checkD(per.getText())&&checkD(vat.getText())&&checkD(cst.getText())&&checkD(fright.getText())&&particulars.getText().length()>0){
            ql.addItem(qty.getText());
            ptclrs.addItem(particulars.getText());
            rates.addItem(rate.getText());
            pers.addItem(per.getText());
            try{
            int q=Integer.parseInt(qty.getText());
            double r=Double.parseDouble(rate.getText());
            double p=Integer.parseInt(per.getText());
            double vt=Double.parseDouble(vat.getText());
            double ct=Double.parseDouble(cst.getText());
            double frt=Double.parseDouble(fright.getText());    
            double amount=getAmt(q,r,p);
            String h=""+amount;
            amts.addItem(h);
            qla[arraysize]=""+q;
            ptclrsa[arraysize]=particulars.getText();
            ratesa[arraysize]=""+r;
            amtsa[arraysize]=""+amount;
            arraysize++;
            }
            catch(Exception e2){}
        }
        isSel=false;
    }
    else if(str.equalsIgnoreCase("Del")){
        if(isSel){
            int index=ql.getSelectedIndex();
            ql.remove(index);
            amts.remove(index);
            rates.remove(index);
            pers.remove(index);
            ptclrs.remove(index);
            arraysize--;
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
    else if(str.equalsIgnoreCase("Save")){saved=true;save();}
    else if(str.equalsIgnoreCase("Print")&&saved==true){
    prnt.printIt();
    }
    else if(str.equalsIgnoreCase("Reset")){
        name.setText("");
invnum.setText("");
date.setText("");
odate.setText("");
cdate.setText("");orderno.setText("");chlno.setText("");buyvat.setText("");lorrynum.setText("");rrno.setText("");qty.setText("");rate.setText("");per.setText("");vat.setText("");cst.setText("");fright.setText("");particulars.setText("");rrdt.setText("");
ql.clear();
ptclrs.clear();
rates.clear();
pers.clear();
amts.clear();
arraysize=0;
qla=ptclrsa=ratesa=persa=amtsa=new String[10];
try{
takeVals();
}
catch(Exception exp){}
isSel=false;
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

public void save(){
try{
File f=new File("c:\\record.txt");
f.createNewFile();
PrintWriter pw=new PrintWriter(new FileWriter(f));
String[] vtw=takeVals();
if(vtw!=null)
for(int i=0;i<vtw.length;i++){
pw.println(vtw[i]);
    }
    pw.close();
    }
    catch(Exception e){
        System.err.println("Error!");
    
}
}
}