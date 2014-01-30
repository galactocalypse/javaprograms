import java.io.*;
import java.util.*;
public class FileManager{
File data;
Record[] db;
public String[] getFileData(File f){
try{
DataInputStream in=new DataInputStream(new FileInputStream(f));
String str[]=new String[150];
String temp="";
int i=0;
while((temp=in.readLine())!=null){
str[i]=temp;
i++;
}
in.close();
String fs[]=new String[i];
for(int j=0;j<i;j++){
fs[j]=str[j];
}
return fs;
}
catch(Exception e){return null;
}
}
public Record[] getRecs(){
String str[]=getFileData(data);
Record rec[]=new Record[str.length/6];
for(int i=0;i<rec.length;i+=7){
rec[i]=new Record(str[i],str[i+1],str[i+2],str[i+3],str[i+4],str[i+5]);
}
return rec;
}
}
