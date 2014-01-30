import java.io.*;
public class Dem364567o{
public static void main(String args[]){
try{
File f=new File("c:\\DomainName.txt");
f.createNewFile();
PrintWriter pw=new PrintWriter(new FileWriter(f));
pw.println("Hello!");pw.println("Hello3!");
pw.close();
}catch(Exception e){
System.err.println("Not valid!");
}
    }
}