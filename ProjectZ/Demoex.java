import java.io.*;
public class Demoex{
static final File f=new File("lines.txt");
public static void main(String args[]){
try{
int n=0;
if(!f.exists())f.createNewFile();
DataInputStream in=new DataInputStream(System.in);
System.out.println("Enter no. of lines :");

n=Integer.parseInt(in.readLine());
String str[]=new String[n];
PrintWriter pw=new PrintWriter(new FileWriter(f));

for(int i=0;i<n;i++){
System.out.println("Enter line :"+(i+1));

str[i]=in.readLine();
pw.println(str[i]);
}
pw.flush();
pw.close();
System.out.println("Done!");
}
catch(Exception e){}
}
}