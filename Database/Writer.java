import java.io.*;

public final class Writer{

public static final void write(String s[],File f){
try{
PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter(f)));
for(int i=0;i<s.length;i++)pw.println(s[i]);
pw.println("eof");
pw.close();
System.out.println("Write to file :"+f.toString());
}catch(Exception e){}
    }
    public void writeElements(ElementList u){
        if(u==null)return;
    Node p=u.root;
    
    while(p!=null){
        Element u1=p.data;
        if(u1==null)return;
    write(u1.getString(),new File(Addresses.useraccounts,""+u1.id+".dat"));
}}

public static final void sop(String s){System.out.print(s);}

public static final void sopln(String s){System.out.println(s);}

public static final void createDirectory(File f){
try{
if(f.exists()&&f.isDirectory())return;
f.mkdir();
}
catch(Exception e){}
}

public static final void createFile(File f){
try{
//if(f.exists()&&!f.isDirectory())return;
f.createNewFile();}
catch(Exception e){}
}

public static final void createDirectories(File f[]){
for(int i=0;i<f.length;i++)createDirectory(f[i]);
}

public static final void createFiles(File f[]){
for(int i=0;i<f.length;i++){createFile(f[i]);
    }}

}
