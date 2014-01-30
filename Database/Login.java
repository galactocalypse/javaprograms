import java.io.*;
import java.util.*;
public class Login{
static Buffer b;
static boolean isLoggedIn;
static int id;
static String loggedin, loggedout;
public Login(Buffer buff){b=buff;isLoggedIn=false;}
static void login(){
String name=b.r.input("Enter your username : ");
String pwd=b.r.input("Enter your password : ");
User u=(User)(((UserList)(b.users)).search(name));
if(u==null){b.w.sopln("Username does not exist. Please check and re-enter.");return;}
isLoggedIn=true;
loggedin=getTime();
b.w.sopln("[User "+getLoggedUser().name+" logged in"+loggedin+"]");
}
public static User getLoggedUser(){
if(isLoggedIn)return User.getUser(id);
return null;}
static String getTime(){
Date d=new Date();
return ""+d.getHours()+":"+d.getMinutes()+":"+d.getSeconds()+" , "+d.getDay()+"-"+d.getMonth()+"-"+d.getYear();
}
static void logout(){
loggedout=getTime();
b.w.sopln("[User "+getLoggedUser().name+" logged out "+loggedout+"]");
isLoggedIn=false;
}
static User createNewAccount(){
int id,activity;
String name,datejoined,dob,location,email,password;
id=b.st.getLastUserID()+1;
System.out.println("ID : "+id);
String s=null;
name=Reader.input("Enter your username : ");
while(usernameExists(name)){name=Reader.input("Username exists. Please enter another username : ");
    }
do{
password=Reader.input("Enter your password : ");

do{
    s=Reader.input("Please re-enter your password(enter 'x' to change password) : ");
    if(s.equals(password))break;
    }while(!s.equals(password));
    
}while(s.equalsIgnoreCase("x"));

email=Reader.input("Enter your email ID : ");
while(!isValidEmail(email)){email=Reader.input("Invalid address. Please enter a valid email ID.");
}

dob=Reader.input("Enter your date of birth(dd-mm-yyyy) : ");
location=Reader.input("Enter your location : ");
datejoined=getTime();
activity=0;
return new User(id,name,password,email,dob,location,datejoined,activity);
}
public static boolean usernameExists(String s){return false;}
public static boolean isValidEmail(String s){return true;}
public static boolean isValidDate(String s){return true;}

public int loginmenu(){
return b.r.inputInt("Enter choice : 1. Login\t 2. Enter without login\t3. Create new account\t4. Exit");
}
public int databasemenu(){
return b.r.inputInt("Enter choice : 1. Enter encyclopedia\t 2. Enter dictionary\t3. View user profile\t4. Logout\t5. Exit");
}
public void addArticle(){
String name=b.r.input("Enter topic name : ");
String type=b.r.input("Enter article type : ");
String author=getLoggedUser().getName();
String s[]=b.r.input("Enter keywords(separated by commas) : ").split(",");
String res[]=b.r.input("Enter full path of resources(if any), separated by semi-colons : ").split(";");
String d[]=b.r.read(new File(b.r.input("Enter full path of text file storing the description : ")));
b.articles.addAtEnd(new Node(new Article(b.st.getLastArticleID()+1,name,type,author,null,s,res,d)));
}

}