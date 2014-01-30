import java.io.*;
public class Reader{
static final Addresses a=new Addresses();
static final BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

public static String[] read(File f){
if(f==null)return null;
String s[]=null;
int n=0;
try{
BufferedReader br=new BufferedReader(new FileReader(f));
n=0;
String str=null;
while((str=br.readLine()).equalsIgnoreCase("eof")==false){++n;}
br.close();
if(n==0)return null;    
 br=new BufferedReader(new FileReader(f));
s=new String[n];
int i=0;
 str="eof";
while((str=br.readLine()).equalsIgnoreCase("eof")==false){s[i]=str;i++;}
br.close();
}
catch(Exception e){}
return s;
}

public static final Element convert(String str[],char ch){
if(str==null)return null;
switch(ch){
case 'u':
User u=new User(getInt(str[0]),str[1],str[2],str[3],str[4],str[5],str[6],getInt(str[7]));
return u;
case 'a':
return new Article(getInt(str[0]),str[1],str[2],str[3],str[4].split(","),str[5].split(","),str[6].split(","),str[7].split(","));
}
return null;
}
public static UserList getUsers(){
String s[]=a.useraccounts.list();
UserList u=new UserList();
for(int i=0;i<s.length;i++){
File f=new File(a.useraccounts,s[i]);
u.addAtEnd(new Node(convert(read(f),'u')));
}
return u;
}
public ElementList getElementList(char ele){
String s[]=null;
File add=null;
ElementList e=new ElementList();
switch(ele){
case 'u':
add=a.useraccounts;
break;
case 'a':
add=a.articles;
}
if(add==null)return null;
s=add.list();
if(s==null)return null;
for(int i=0;i<s.length;i++){
File f=new File(a.articles,s[i]);

e.addAtEnd(new Node(convert(read(f),ele)));
}
return e;
}

public static int getInt(String s){
try{return Integer.parseInt(s);}catch(Exception e){return 0;}
}   
public static String input(String s){
System.out.println(s);
try{return br.readLine();}catch(Exception e){return null;
}
}
public static int inputInt(String s){
try{return Integer.parseInt(input(s));
    }
catch(Exception e){
return 0;}
}
public static double inputDouble(String s){
try{return Double.parseDouble(input(s));
    }
catch(Exception e){
return 0;}
}
public static char inputChar(String s){
try{return input(s).charAt(0);
    }
catch(Exception e){
return '\u0000';}
}
public static final String getString(String arr[]){
if(arr==null)return null;
String s="";
for(int i=0;i<arr.length;i++)s=s+arr[i]+" ";
return s;
}
public static boolean has(String arr[],String s){
for(int i=0;i<arr.length;i++)if(arr[i].equalsIgnoreCase(s))return true;
return false;
}
public static int menu(String s){return inputInt("Enter choice : "+s);}
}