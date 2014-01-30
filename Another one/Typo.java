import java.io.*;
public class Typo {
String str="12345";
int digits=5;
public void accept(){
DataInputStream in=new DataInputStream(System.in);
String inp="";
do{
System.out.println(str);
try{
inp=in.readLine();
}
catch(Exception e){}
try{
int n=Integer.parseInt(inp);
if(!inp.equalsIgnoreCase(str)&&!inp.equalsIgnoreCase("y")){System.out.println("Incorrect!");
}
else {str=""+(int)(Math.random()*Math.pow(10,digits));
System.out.println("Correct!");
}
}

catch(Exception e){
if((""+inp.charAt(0)).equalsIgnoreCase("d")){
digits=Integer.parseInt(""+inp.charAt(1));
}
}
}
while(!inp.equalsIgnoreCase("Y"));
}
}