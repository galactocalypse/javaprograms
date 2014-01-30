import java.io.*;
public class Stats{
final File sf=new File("c:\\encyclopedia\\stats.dat");
String st[];
User loggedUser;
public Stats(){
st=getStats();
}
public void setLogged(int id){
Reader r=new Reader();
loggedUser=r.getByUID(id);
st[st.length-1]=""+loggedUser.id;
Writer w=new Writer();
w.write(sf,st);
}
public void endSession(){
loggedUser=null;
st[st.length-1]="*";
Writer w=new Writer();
w.write(sf,st);
}
public boolean isLogged(){
if(st[st.length-1].equalsIgnoreCase("*"))return false;
System.out.println("is logged in");
return true;
}
public int getLoggedUID(){
return loggedUser.id;
/**try{
return Integer.parseInt(st[st.length-1]);
}catch(Exception e){}
return 0;**/}
public User getLoggedUser(){
Reader r=new Reader();
return r.getByUID(getLoggedUID());
}
public String[] getStats(){
Reader r=new Reader();
String s[]=r.readArr(sf);
return s;
    }
public int getInt(String s){
try{
return Integer.parseInt(s);
}
catch(Exception e){}
return 0;}
public int getLastAID(){
return getInt(st[1]);
}public int getLastUID(){
return getInt(st[0]);
}
public void incrementUID(){
try{
st[0]=""+(Integer.parseInt(st[0])+1);
Writer w=new Writer();
w.write(sf,st);
    }
catch(Exception e){}}
public void incrementAID(){
try{
st[1]=""+(Integer.parseInt(st[1])+1);
Writer w=new Writer();
w.write(sf,st);
    }
catch(Exception e){}}
public static void main(String args[]){
Stats s=new Stats();
System.out.println(s.st[s.st.length-1]);}
}