import java.io.*;
class Calculate{
Expression e1=new Expression();
Expression e2=new Expression();
void accept(){
try{
DataInputStream in=new DataInputStream(System.in);
System.out.println("Enter exp. 1:");
e1.expression=in.readLine();
System.out.println("Enter exp. 2:");
e2.expression=in.readLine();
}
catch(Exception e){}
}
void calc(){
Term result[];
Term t1[]=e1.getTerms(e1.getParts(e1.expression));
Term t2[]=e2.getTerms(e2.getParts(e2.expression));
if(t1.length==t2.length){
result=new Term[t1.length];
for(int i=0;i<t1.length;i++){
result[i]=new Term(1,1);
result[i].setNum(t1[i].getNum()+t2[i].getNum());
result[i].setPow(t1[i].getPow());
if(result[i].getNum()<0)result[i].neg=true;
}
display(result);
}
}
void display(Term t[]){
for(int u=0;u<t.length;u++){
System.out.print(t[u].getNum()+"x"+t[u].getPow()+"\t");
}
}
public static void main(String args[]){
Calculate c=new Calculate();
c.accept();
c.calc();
}
}