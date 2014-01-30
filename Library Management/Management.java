import java.io.*;
public class Management{
Member m[];
Book b[];

void load(){
try{
String[] files=new File("c:\\Library").list();
File f=new File("c:\\Library\\books.txt");
String books[]=read(f);
b=new Book[books.length];
for(int j=0;j<books.length;j++){
b[j]=new Book(j+1,books[j],true);
System.out.println(b[j].name);
}

for(int i=0;i<files.length;i++)System.out.println(files[i]);
m=new Member[files.length-1];
int ptr=0;
for(int i=0;i<files.length-1;i++){
System.out.println("reading file : "+files[i]);
if(files[i].equalsIgnoreCase("Books.txt")==false) {
m[ptr]=getMember(new File("c:\\Library",files[i]));
ptr++;
}

}
System.out.println("done successfully");    
}
    catch(Exception e){System.out.println("prob");}
}
Member getMember(File f)throws Exception{
String[] str=read(f);
for(int i=0;i<str.length;i++)System.out.println(str[i]);
Member m=new Member(Integer.parseInt(str[0]),str[1]);
m.borrowedbookid=Integer.parseInt(str[3]);
m.dateborrowed=str[2];
if(str[4].equalsIgnoreCase("true"))m.hasbook=true;
else m.hasbook=false;
return m;
}
void write(String s, File f) throws Exception {
PrintWriter pw=new PrintWriter(new FileWriter(f,true));
pw.println(s);
pw.close();
}
String[] read(File f)throws Exception {
BufferedReader br=new BufferedReader(new FileReader(f));
String s=null,temp=null;
while((temp=br.readLine())!=null){if(s==null)s=temp;else s=s+";"+temp;}
return s.split(";");
}
String input(String s) throws Exception{
System.out.println(s);
DataInputStream in=new DataInputStream(System.in);
return in.readLine();
}
int inputNum(String s)throws Exception{
return Integer.parseInt(input(s));
}

void borrow()throws Exception{
int member=inputNum("enter member id : ");
int book=inputNum("enter book id : ");
for(int i=0;i<m.length;i++){
if(m[i].id==member){
m[i].borrow(book);
for(int j=0;j<b.length;j++){
if(b[j].id==book)b[j].available=false;
}
System.out.println("User"+member+" borrowed book "+book);
return;}
}
System.out.println("invalid book or member id");
}
void store()throws Exception {
File bks=new File("c:\\Library","books.txt");
bks.delete();
bks.createNewFile();
for(int i=0;i<b.length;i++){
write(b[i].name,bks);
}
for(int i=0;i<m.length;i++){
if(m[i]!=null)
{File f=new File("c:\\Library","m"+m[i].id+".dat");
f.delete();
f.createNewFile();
write(""+m[i].id,f);
write(m[i].name,f);
write(m[i].dateborrowed==null?null:m[i].dateborrowed,f);
write(""+m[i].borrowedbookid,f);

write(""+m[i].hasbook,f);
    }
}
System.out.println("data storage complete.");
}
void returnbook()throws Exception{
int member=inputNum("enter member id : ");
int book=inputNum("enter book id : ");
for(int i=0;i<m.length;i++){
if(m[i].id==member){
m[i].returnbook();
for(int j=0;j<b.length;j++){
if(b[j].id==book)b[j].available=true;
}
System.out.println("User"+member+" returned book "+book);
return;}
}
System.out.println("invalid book or member id");
}
void displayAvailableBooks(){
for(int i=0;i<b.length;i++){
System.out.println(b[i].id+" : "+b[i].name);
}
}
}