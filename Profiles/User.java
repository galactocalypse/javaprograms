public class User extends Element{
String name;
Address a;
String dob;
CList contacts;
EMList emails;
public User(){
a=null;
name=null;
emails=new EMList();
contacts=new CList();
}
public String info(){
String s=name+"\n"+a.line1+"\n"+dob+"\n"+((Contact)(contacts.root.e)).number+"\n"+((Email)(emails.root.e)).id;
return s;}
public void dispInfo(){
System.out.println(info());
}
}