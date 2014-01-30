import java.io.*;
public class DEMO{
String name;
int marks[];
int cls;
int markslength;
DEMO(int markslength){
this.markslength=markslength;
marks=new int[markslength];
}
DEMO(){
marks=new int[5];
}
public void input()throws Exception{
name=inp("name");
cls=Integer.parseInt(inp("class"));
for(int i=0;i<marks.length;i++){
marks[i]=Integer.parseInt(inp("marks"+(i+1)+" : "));
}
}
public String inp(String s)throws Exception{
System.out.println("Enter "+s+" : ");
return (new DataInputStream(System.in)).readLine();
}
public void disp(){
System.out.println("Name : "+name+"\nClass : "+cls);
for(int i=0;i<marks.length;i++){
System.out.println("Marks "+(i+1)+" : "+marks[i]);
}
}
public static void main(String args[])throws Exception {
DEMO d=new DEMO(5);
d.input();
d.disp();
}
}