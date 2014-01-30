import java.awt.*;
import java.io.*;
public class Record{

public Image image=null;
public String password="";
public String description="";
public String caption="";
public String hint="";
public int level=0;
public int noOfTries=5;
public int tried=0;
public Record(){}

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
DataInputStream in=new DataInputStream(new FileInputStream(new File("file1.txt")));
int n=0;
String s="";
for(int k=0;k<i;k++){
s=in.readLine();
}
in.close();
return s;
}

public String getDesc(int i)throws Exception{
DataInputStream in=new DataInputStream(new FileInputStream(new File("file2.txt")));
int n=0;
String s="";
for(int k=0;k<i;k++){
s=in.readLine();
}
in.close();
return s;
}
public String getHint(int i)throws Exception{
DataInputStream in=new DataInputStream(new FileInputStream(new File("file3.txt")));
int n=0;
String s="";
for(int k=0;k<i;k++){
s=in.readLine();
}
in.close();
return s;
}

public String getCap(int i)throws Exception{
DataInputStream in=new DataInputStream(new FileInputStream(new File("file4.txt")));
int n=0;
String s="";
for(int k=0;k<i;k++){
s=in.readLine();
}
in.close();
return s;
}
}