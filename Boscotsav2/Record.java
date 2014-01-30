import java.awt.*;
import java.io.*;
import java.security.*;
import java.util.Hashtable;
public class Record implements Runnable{
Thread t=new Thread(this);
public Image image=null;
boolean running=true;
public String password="";
int score=0;
int levelsCrossed=0;
public String description="";
public String caption="";
File filex=new File("filex.txt");
public String hint="";
public int level=0;
public int noOfTries=5;
public int tried=0;
File file1=new File("file1.txt");
File file2=new File("file2.txt");
File file3=new File("file3.txt");
File file4=new File("file4.txt");
/**
	AccessController.doPrivileged(new PrivilegedAction() {
	    public Object run() {
		String path = 
		    System.getProperty("user.home") +
		    File.separator + 
		    ".score";

		filex = new File(path);
		return null;
	    }
	});
**/
public Record(){try{
if(!file1.exists())file1.createNewFile();
if(!file2.exists())file2.createNewFile();
if(!file3.exists())file3.createNewFile();
if(!file4.exists())file4.createNewFile();
t.start();
}
catch(Exception e){}
}

public Record(Image image,int level) throws Exception{
this.image=image;
this.level=level;
this.hint=getHint(level);
this.password=getPass(level);
this.caption=getCap(level);
this.description=getDesc(level);
}
public Image getImage(){
return image;
}
public String getCaption(){return caption;}
public String getHint(){return hint;}
public String getPassword(){return password;}

public String getPass(int i)throws Exception{
DataInputStream in=new DataInputStream(new FileInputStream(file1));
int n=0;
String s="";
for(int k=0;k<i;k++){
s=in.readLine();
}
in.close();
return s;
}

public String getDesc(int i)throws Exception{
DataInputStream in=new DataInputStream(new FileInputStream(file2));
int n=0;
String s="";
for(int k=0;k<i;k++){
s=in.readLine();
}
in.close();
return s;
}
public String getHint(int i)throws Exception{
DataInputStream in=new DataInputStream(new FileInputStream(file3));
int n=0;
String s="";
for(int k=0;k<i;k++){
s=in.readLine();
}
in.close();
return s;
}

public String getCap(int i)throws Exception{
DataInputStream in=new DataInputStream(new FileInputStream(file4));
int n=0;
String s="";
for(int k=0;k<i;k++){
s=in.readLine();
}
in.close();
return s;
}/**
public void save(int score,int levelsCrossed,File f){
try{
PrintWriter pw=new PrintWriter(new FileWriter(f));
java.util.Date dt=new java.util.Date();
pw.println("Score : "+score);
pw.println("Levels crossed : "+levelsCrossed);
pw.println("Time : "+dt.getHours()+":"+dt.getMinutes());
pw.flush();
pw.close();
}
catch(Exception e){}
}
**/
public void save()throws Exception{
PrintWriter pw=new PrintWriter(new FileWriter(filex));
java.util.Date dt=new java.util.Date();
pw.println("Score : "+score);
pw.println("Levels crossed : "+levelsCrossed);
pw.println("Time : "+dt.getHours()+":"+dt.getMinutes());
pw.flush();
pw.close();
}
public void run(){
while(running){
try{
save();
}
catch(Exception e){}
try{t.sleep(2000);levelsCrossed++;
}
catch(Exception e){}
}

}
public void destroy(){
try{save();}catch(Exception e){}
t=null;
running=false;
}
}