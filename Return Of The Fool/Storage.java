import java.io.*;
public class Storage{
public boolean write(String s,File f){
try{
PrintWriter pw=new PrintWriter(new FileWriter(f));
pw.println(s);
pw.close();
return true;
}
catch(Exception e){return false;}
}
public String read(File f){
try{
BufferedReader br=new BufferedReader(new FileReader(f));
String str="",s;
while((s=br.readLine())!=null)str=str+"\n"+s;
br.close();
return str;
}
catch(Exception e){return null;}
}
public String[] readParts(File f){
try{
BufferedReader br=new BufferedReader(new FileReader(f));
String str="",s;
while((s=br.readLine())!=null)str=str+"\n"+s;
br.close();
return str.split("\n");
}
catch(Exception e){return null;}
}
public static void main(String args[]){
try{
File f=new File("c:\\this.txt");
f.createNewFile();
Storage s=new Storage();
s.write("Hello1",f);
System.out.println("Output1 : "+s.read(f));
s.write("Hello2!",f);
System.out.println("Output2 : "+s.read(f));
s.write("Hello3",f);
System.out.println("Output3 : "+s.read(f));
}
catch(Exception e){}
}
public List getValues(File f){
List m=new List();
String str[]=readParts(f);
for(int i=0;i<str.length;i++){
if(str[i].startsWith("Name")){
m.add(new Value(str[i].substring(4,str[i].length()-4)));
}
}

return m;}
}