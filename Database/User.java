import java.io.*;
import java.util.*;
public class User extends Element{
static int activity;
String password,email,dob,location,datejoined;
public User(int i,String n,String pwd,String e,String d,String loc,String dj,int a){
super(i,n);
password=pwd;
email=e;
dob=d;
location=loc;
datejoined=dj;
activity=a;
}
public User(){}
public String[] getString(){
String s[]=new String[8];
s[0]=""+id;
s[1]=name;
s[2]=password;
s[3]=email;
s[4]=dob;
s[5]=location;
s[6]=datejoined;
s[7]=""+activity;
return s;
}
static User getUser(int xid){
File f=new File(Addresses.useraccounts,""+xid+".dat");
String s[]=Reader.read(f);
User u=(User)Reader.convert(s,'u');
System.out.println(Reader.getString(u.getString()));
return u;
}
public static boolean usernameExists(String s){return false;}
public static boolean isValidEmail(String s){return true;}
public static boolean isValidDate(String s){return true;}
static String getCurrentDate(){
Date d=new Date();
return ""+d.getHours()+":"+d.getMinutes()+":"+d.getSeconds()+" , "+d.getDay()+"-"+d.getMonth()+"-"+d.getYear();
}
}