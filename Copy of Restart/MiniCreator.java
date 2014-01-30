import java.io.*;
public class MiniCreator{
public void createNewUser(){
String name,pwd;
Reader r=new Reader();
Writer w=new Writer();
SList u=r.getUserNames();
do{
name=r.input("name(or '*' to cancel creating new account)");
if(name.equals("*"))return;
}while(r.exists(u,name));
do{
pwd=r.input("password(or '*' to cancel creating new account)");
if(pwd.equals("*"))return;
    }while(pwd.length()<5);
    Stats st=new Stats();
    User n=new User(st.getLastUID()+1,name,pwd);
    st.incrementUID();
    
    w.write(new File(r.udirec,st.getLastUID()+".dat"),n.getInfo());
}
public void createNewArticle(){
String name;
int id;
String key[],d[];
Reader r=new Reader();
Stats st=new Stats();
Writer w=new Writer();
name=r.input("name");
String anames[]=r.getArticleNames();
if(r.exists(anames,name)){System.out.println("This article already exists! If you want to edit it, please do so in the edit mode.");return;}
key=trimAll((r.input("keywords separated by commas")).split(","));
d=r.input("description(separate lines by tabs, press enter to stop)").split("\t");
Article a=new Article(st.getLastAID(),name,key,d);
st.incrementAID();
w.write(new File(r.adirec,st.getLastAID()+".dat"),a.getInfo());
}
public String[] trimAll(String s[]){
for(int i=0;i<s.length;i++)s[i]=s[i].trim();
return s;}
public void login(){
Reader r=new Reader();
Stats st=new Stats(); 
String name=r.input("name");
if(!r.userExists(name)){System.out.println("User does not exist.");
return;}
String pwd;
User u=r.getByUName(name);

do{
    pwd=r.input("password(or '*'to abort login)");
    if(pwd.equals(u.pwd)){  
        st.setLogged(u.id);
        System.out.println("User logged in.");
        return;
    }
    else if(pwd.equals("*")){System.out.println("Login aborted."); return;}
        else System.out.println("Incorrect password!");   
    }
    while(st.isLogged()==false);

}
public void logout(){
Stats st=new Stats();
st.endSession();
}
}