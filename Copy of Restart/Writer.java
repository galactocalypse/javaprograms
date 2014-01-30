import java.io.*;
public class Writer{
static final File direc=new File("c:\\encyclopedia\\articles\\");
public void write(File f,String data[]){
try{
PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter(f)));
for(int i=0;i<data.length;i++)pw.println(data[i]);
pw.println("eof");
pw.close();
    }
    catch(Exception e){}
}
public void write(File f,String s){
String s1[]=new String[1];
s1[0]=s;
write(f,s1);
}
public void writeArticle(Article a){
try{File f=new File(direc,""+a.id+".dat");
f.createNewFile();
write(f,a.d);
    }
catch(Exception e){}}
public void writeArticleList(AList a){
if(a==null)return;
Node p=a.root;
while(p!=null){
writeArticle(p.data);p=p.next;
    }
}

}