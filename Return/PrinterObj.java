import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.awt.print.*;
public class PrinterObj extends JFrame implements Printable{
String n,inum,dt,odt,cdt,odno,chno,bvat,lnum,rrn,qtty[],pts[],rt[],vt,cent,rdt,pr[],frgt,amts[];
 
NumberToWords ntw;
public PrinterObj(){
new JFrame();
setDefaultCloseOperation(EXIT_ON_CLOSE);
setBackground(Color.white);
setSize(480,660);
}

public void paint(Graphics g){
g.translate(6,31);
g.drawRect(0,0,460,620);
g.drawLine(0,60,460,60);
g.drawLine(0,125,460,125);
g.drawLine(0,150,460,150);
g.drawLine(0,170,460,170);
g.drawLine(0,480,460,480);
g.drawLine(0,520,460,520);
g.drawLine(0,600,460,600);
g.drawLine(230,60,230,150);
g.drawLine(345,60,345,150);
g.drawLine(230,80,460,80);
g.drawLine(60,150,60,480);
g.drawLine(325,150,325,480);
g.drawLine(355,170,355,480);
g.drawLine(375,150,375,409);
g.drawLine(405,150,405,480);
g.drawLine(440,170,440,480);
g.drawLine(355,465,460,465);
g.drawLine(355,451,460,451);
g.drawLine(355,437,460,437);
g.drawLine(355,423,460,423);
g.drawLine(355,409,460,409);
g.drawLine(50,497,460,497);
g.drawLine(50,515,460,515);
g.drawLine(245,520,245,600);

FontMetrics m=g.getFontMetrics(new Font("Arial",Font.BOLD,12));
int x=m.stringWidth("ORIGINAL FOR BUYERS");
g.setFont(new Font("Arial",Font.BOLD,12));
g.drawString("ORIGINAL FOR BUYERS",(460-x)/2,12);

m=g.getFontMetrics(new Font("Arial",Font.BOLD,24));
x=m.stringWidth("Chowdhary Mineral & Coal");
g.setFont(new Font("Arial",Font.BOLD,24));
g.drawString("Chowdhary Mineral & Coal",(460-x)/2,32);

m=g.getFontMetrics(new Font("Arial",Font.PLAIN,10));
x=m.stringWidth("8, STATION ROAD, LILUAH, HOWRAH");
g.setFont(new Font("Arial",Font.PLAIN,10));
g.drawString("8, STATION ROAD, LILUAH, HOWRAH",(460-x)/2,47);

x=m.stringWidth("TAX-NOVOICE");
g.drawString("TAX-INVOICE",(460-x)/2,59);
g.setFont(new Font("Arial",Font.PLAIN,8));
g.drawString("M/s",2,70);
g.drawString("INVOICE No.",232,70);
g.drawString("DT",347,70);
g.drawString("ORDER No. & DT",232,90);
g.drawString("CHALLAN No.",347,90);
g.drawString("& DT",347,100);
g.drawString("Buyer's VAT Regd NO.",2,135);
g.drawString("LORRY No.",232,135);
g.drawString("R/R No.",347,135);

g.setFont(new Font("Arial",Font.PLAIN,10));
m=g.getFontMetrics(new Font("Arial",Font.PLAIN,10));
x=m.stringWidth("Quantity");
g.drawString("Quantity",(60-x)/2,165);

x=m.stringWidth("PARTICULARS");
g.drawString("P A R T I C U L A R S",60+((265-x)/2),165);

x=m.stringWidth("RATE");
g.drawString("RATE",325+((50-x)/2),159);
g.setFont(new Font("Arial",Font.PLAIN,8));
m=g.getFontMetrics(new Font("Arial",Font.PLAIN,8));
x=m.stringWidth("Rs.        P.");
g.drawString("Rs.        P.",325+(50-x)/2,168);
g.drawString("    Rs.        P.",405+(50-x)/2,168);

g.setFont(new Font("Arial",Font.PLAIN,10));
g.drawString("PER",380,165);
g.drawString("AMOUNT",410,159);
g.setFont(new Font("Arial",Font.PLAIN,8));
g.drawString("VAT No. 19710571012",62,440);
g.drawString("W.B.S.T. By/10674 NEw 19710571109",62,452);
g.drawString("C.S.T. 5849 (By) C New 197105710206",62,464);
g.setFont(new Font("Arial",Font.BOLD,8));
g.drawString("Please pay by A/c Payee Cheque",62,478);
g.setFont(new Font("Arial",Font.BOLD,10));
g.drawString("Rupees",6,497);
g.setFont(new Font("Arial",Font.PLAIN,8));
g.drawString("1.  Please send S.T.D. Form along with payment.",2,532);
g.drawString("2.  24% interest will be charged in case the payment is",2,544);
g.drawString("    not made within the allowed credit period.",2,556);
g.drawString("3.  Goods once sold can not be returned without our Approval.",2,568);
g.drawString("     Our responsibility ceases when goods leave our godown.",2,580);
g.drawString("4.  All matters are subject to Calcutta Jurisdiction.",2,592);

g.setFont(new Font("Arial",Font.PLAIN,12));
m=g.getFontMetrics(new Font("Arial",Font.PLAIN,12));
x=m.stringWidth("E. & O.E.");
g.drawString("E. & O.E.",245+(215-x)/2,532);
g.setFont(new Font("Arial",Font.ITALIC,10));
g.drawString("For",253,544);
g.setFont(new Font("Arial",Font.BOLD,10));
g.drawString("CHOWDHARY MINERAL & COAL",278,544);
g.setFont(new Font("Arial",Font.PLAIN,10));
g.drawString("CHECKED BY",2,610);
g.drawString("COMPARED BY",180,610);
g.drawString("PREPARED BY",380,610);

int cx=17,cy=60;
Rectangle r=new Rectangle(cx,cy,160,65);
pt(r,g,n.split(" "),new Font("Arial",Font.PLAIN,12));

g.setColor(Color.black);
//g.drawRect(282,60,60,20);
cx=282;
cy=60;
r=new Rectangle(cx,cy,60,20);
pt(r,g,inum.split(" "),new Font("Arial",Font.PLAIN,12));

//g.drawRect(380,60,75,20);
cx=380;
cy=60;
r=new Rectangle(cx,cy,75,20);
pt(r,g,dt.split(" "),new Font("Arial",Font.PLAIN,10));

//g.drawRect(306,82,36,14);
cx=306;
cy=82;
r=new Rectangle(cx,cy,36,14);
pt(r,g,dt.split(" "),new Font("Arial",Font.PLAIN,12));

//g.drawRect(400,82,57,14);
cx=400;
cy=82;
r=new Rectangle(cx,cy,57,14);
pt(r,g,dt.split(" "),new Font("Arial",Font.PLAIN,12));


//g.drawRect(236,100,105,16);
cx=236;
cy=100;
r=new Rectangle(cx,cy,105,16);
pt(r,g,dt.split(" "),new Font("Arial",Font.PLAIN,12));

//g.drawRect(351,100,105,16);
cx=351;
cy=100;
r=new Rectangle(cx,cy,105,16);
pt(r,g,dt.split(" "),new Font("Arial",Font.PLAIN,12));


//g.drawRect(398,127,60,8);
cx=398;
cy=127;
r=new Rectangle(cx,cy,60,8);
pt(r,g,dt.split(" "),new Font("Arial",Font.PLAIN,10));

//g.drawRect(350,137,104,10);
cx=350;
cy=137;
r=new Rectangle(cx,cy,104,10);
pt(r,g,dt.split(" "),new Font("Arial",Font.PLAIN,10));

//g.drawRect(232,133,110,12);
cx=232;
cy=133;
r=new Rectangle(cx,cy,110,12);
pt(r,g,dt.split(" "),new Font("Arial",Font.PLAIN,10));

//g.drawRect(85,129,125,16);
cx=85;
cy=129;
r=new Rectangle(cx,cy,125,16);
pt(r,g,dt.split(" "),new Font("Arial",Font.PLAIN,10));

////g.drawRect(62,175,261,250);
int np=pts.length;
int ht=(250/np)-4;
cx=64;
cy=142;
for(int i=0;i<pts.length;i++){
cy=cy+ht+4;
r=new Rectangle(cx,cy,180,ht);
////g.drawRect(cx,cy,262,ht);
pt(r,g,(pts[i]).split(" "),new Font("Arial",Font.PLAIN,12));
r=new Rectangle(cx-60,cy,20,ht);
pt(r,g,(qtty[i]).split(" "),new Font("Arial",Font.PLAIN,12));
r=new Rectangle(cx+262,cy+4,28,ht-6);
g.drawRect((int)r.getX(),(int)r.getY(),(int)r.getWidth(),(int)r.getHeight());
pt(r,g,(rt[i]).split(" "),new Font("Arial",Font.PLAIN,12));
r=new Rectangle(cx+295,cy+4,15,ht-6);
g.drawRect((int)r.getX(),(int)r.getY(),(int)r.getWidth(),(int)r.getHeight());
pt(r,g,(pr[i]).split(" "),new Font("Arial",Font.PLAIN,12));
r=new Rectangle(cx+315,cy+4,22,ht-6);
g.drawRect((int)r.getX(),(int)r.getY(),(int)r.getWidth(),(int)r.getHeight());
pt(r,g,("10").split(" "),new Font("Arial",Font.PLAIN,12));
}
r=new Rectangle(55,482,358,36);
//g.drawRect((int)r.getX(),(int)r.getY(),(int)r.getWidth(),(int)r.getHeight());
pt(r,g,(ntw.get(1452545451,"")+" Only").split(" "),g.getFont());
}

public void pt(Rectangle r,Graphics g,String s[],Font f){
FontMetrics m=g.getFontMetrics(f);
int x=0,lines=1;

for(int i=0;i<s.length;i++){
if(x+m.stringWidth(s[i]+" ")>=r.getWidth()){x=0;lines++;}
else {x+=m.stringWidth(s[i]+" ");}
}
int fontsize=(int)r.getHeight()/(lines),cx=0,cy=0;
if(fontsize>f.getSize())fontsize=f.getSize();
f=new Font(f.getName(),f.getStyle(),fontsize);
g.setFont(f);
m=g.getFontMetrics(f);
cy+=(fontsize+2);
for(int i=0;i<s.length;i++){
g.drawString(s[i]+" ",(int)r.getX()+cx,(int)r.getY()+cy);
cx+=m.stringWidth(s[i]+" ");
try{
if(cx+m.stringWidth(s[i+1]+" ")>=(r.getX()+r.getWidth())){cy+=(fontsize+2);cx=0;}
}
catch(Exception e){}
}

}
public int print(Graphics g, PageFormat pf, int page) throws
                                                        PrinterException {

        if (page > 0) { /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }
        g.translate((int)pf.getImageableX(), (int)pf.getImageableY());
        paint(g);

       return PAGE_EXISTS;
    }

    public void printIt() {
         PrinterJob job = PrinterJob.getPrinterJob();
         job.setPrintable(this);
         boolean ok = job.printDialog();
         if (ok) {
             try {
                  job.print();
             } catch (PrinterException ex) {
             System.err.println("Prob!");}
         }
    }
}