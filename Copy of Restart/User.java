import java.io.*;
public class User{
String name;
int id;
String pwd;
public User(int i,String n,String p){
id=i;
name=n;
pwd=p;
}
public void dispUInfo(){
System.out.println("Name: "+name);
}
public String[] getInfo(){
String s[]=new String[3];
s[0]=""+id;
s[1]=name;
s[2]=pwd;
return s;
}
}