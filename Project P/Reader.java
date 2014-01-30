import java.io.*;
public class Reader {
Record1 r[];
void store() throws Exception{
File f=new File("data.txt");
f.createNewFile();
BufferedReader in=new BufferedReader(new FileReader(f));
String str="";
int i=0;
r=new Record1[10];
while((str=in.readLine())!=null){
r[i]=new Record1();
r[i].name=str;
r[i].dob=in.readLine();
r[i].numbers=in.readLine();
str=in.readLine();
r[i].disp();
i++;
}
in=null;
}
}