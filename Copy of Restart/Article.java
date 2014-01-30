public class Article{
String d[];
int id;
String name;
String keywords[];
public Article(int id,String n,String k[],String s[]){
this.id=id;name=n;
keywords=k;
d=s;
}
Article(){name=null;d=null;}
public void disp(){
System.out.println(name);
for(int i=0;i<d.length;i++){
    System.out.println(d[i]);
}
}
boolean lookUp(String s){
for(int i=0;i<keywords.length;i++){
if(keywords[i].equalsIgnoreCase(s))return true;
}
return false;
}
public String getCSV(String s[]){
String str="";
for(int i=0;i<s.length;i++){str=str+s[i];if(i!=s.length-1)str=str+", ";}
return str;}
public String getLSV(String s[]){
String str="";
for(int i=0;i<s.length;i++){str=str+s[i];if(i!=s.length-1)str=str+"\n";}
return str;}

public String[] getInfo(){
String s[]=new String[4];
s[0]=""+id;
s[1]=name;
s[2]=getCSV(keywords);
s[3]=getLSV(d);
return s;}
}