import java.awt.*;
class Fields{
Component c[];
Parts p[];
String name;
String invno;
String order,odate;
String cdate,chno;
String lnum;
String rrno,rrdate;
String buyvat;
String chkd,compd,prep;
TextField tname,tinv,torder,todate,tcdate,tchno,tlnum,trrno,trrdate,tbuyvat,tchkd,tcompd,tcprep;
int numofcomps;

public Fields(){}
public Fields(String name,String invno,String order,String odate,String cdate,String chno,String lnum,String rrno,String rrdate,String buyvat,String chkd,String cmpd,String prep){
this.name=name;
this.invno=invno;
this.order=order;
this.odate=odate;
this.cdate=cdate;
this.chno=chno;
this.lnum=lnum;
this.rrno=rrno;
this.rrdate=rrdate;
this.buyvat=buyvat;
this.chkd=chkd;
this.cmpd=cmpd;
this.prep=prep;
tname=new TextField(name);
tinv=new TextField(tinv);
torder=new TextField(torder);
todate=new TextField(todate);
tcdate=new TextField(tcdate);
tchno=new TextField(tchno);
tlnum=new TextField(tlnum);
trrno=new TextField(trrno);
trrdate=new TextField(trrdate);
tbuyvat=new TextField();
tchkd=new TextField();
tcompd=new TextField();
tcprep=new TextField();
}


public void addPart(Parts part){
Parts p1[]=new Parts[p.length+1];
for(int i=0;i<p.length;i++){
p1[i]=p[i];
}
p1[p.length]=part;
p=p1;
}
void updateComps(){
Component[] c1={tname,tinv,torder,todate,tcdate,tchno,tlnum,trrno,trrdate,tbuyvat,tchkd,tcompd,tcprep};
c=c1;
}
public void addComp(Component comp){
Component c1[]=new Component[c.length+1];
for(int i=0;i<c.length;i++){
c1[i]=c[i];
}
c1[c.length]=comp;
c=c1;
}
Component[] getComp(){
return c;
}
}