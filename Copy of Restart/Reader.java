import java.io.*;
public class Reader{
static final File adirec=new File("c:\\encyclopedia\\articles");
static final File udirec=new File("c:\\encyclopedia\\users");

/////////////////////////////////////////////////////
public AList readArticleList(){
String names[]=adirec.list();
AList a=new AList();
for(int i=0;i<names.length;i++){
a.add(getArticle(readArr(new File(adirec,""+names[i]))));
}
return a;}
/////////////////////////////////////////////////////////////
public String[] removeExt(String s[]){
for(int i=0;i<s.length;i++)s[i]=getOnlyName(s[i]);
return s;
}

/////////////////////////////////////////////////////////////
public String getOnlyName(String s){
if(s==null)return null;int i;
for(i=s.length()-1;i>=0;i--){
if(s.charAt(i)=='.')break;
}
System.out.println(s.substring(0,i));
return s.substring(0,i);
}


/////////////////////////////////////////////////////////////
public String read(File f){
try{
BufferedReader br=new BufferedReader(new FileReader(f));
String s="",t=null;
while((t=br.readLine())!=null){if(s=="")s=t;else s=s+"\n"+t;}
return s.substring(0,s.length()-4);
    }
    catch(Exception e){}
return null;}

/////////////////////////////////////////////////////////////
public String[] readArr(File f){
String s[]= read(f).split("\n");
return s;
}

/////////////////////////////////////////////////////////////
public String input(String s){
try{
System.out.println("Enter "+s+" : ");
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
return br.readLine();
}
catch(Exception e){}
return null;
}

/////////////////////////////////////////////////////////////
public User getUser(String s[]){
if(s==null)return null;
return new User(getInt(s[0]),s[1],s[2]);
}

/////////////////////////////////////////////////////////////
public Article getArticle(String s[]){
if(s==null)return null;
return new Article(getInt(s[0]),s[1],s[2].split(","),s[3].split("\n"));
}

/////////////////////////////////////////////////////////////
public User getByUID(int id){
return getUser(readArr(new File(udirec,id+".dat")));
}

/////////////////////////////////////////////////////////////
public Article getByAID(int id){
return getArticle(readArr(new File(adirec,id+".dat")));
}

/////////////////////////////////////////////////////////////
public int getInt(String s){
try{
return Integer.parseInt(s);
}catch(Exception e){return 0;}
}

/////////////////////////////////////////////////////////////
public boolean articleExists(String s){
AList u=getArticles();
Node p=u.root;
while(p!=null){if(p.data.name.equalsIgnoreCase(s))return true;p=p.next;}
return false;
}
/////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////////
public boolean userExists(String s){
UList u=getUsers();
Node p=u.root;
while(p!=null){if(p.d.name.equalsIgnoreCase(s))return true;p=p.next;}
return false;
}

/////////////////////////////////////////////////////////////
public UList getUsers(){
UList u=new UList();
String s[]=udirec.list();
for(int i=0;i<s.length;i++)u.add(getUser(readArr(new File(udirec,s[i]))));
return u;}


public AList getArticles(){
AList u=new AList();
String s[]=adirec.list();
for(int i=0;i<s.length;i++)u.add(getArticle(readArr(new File(udirec,s[i]))));
return u;}



/////////////////////////////////////////////////////////////
public SList getUserNames(){
UList u=getUsers();
SList s=new SList();
Node p=u.root;
while(p!=null){s.add(new SElement(p.d.name));p=p.next;}
return s;}
//////////////////////////////////
public SList getArticleNames(){
AList u=getArticles();
SList s=new SList();
Node p=u.root;
while(p!=null){s.add(new SElement(p.data.name));p=p.next;}
return s;}

/////////////////////////////////////////////////////////////
public User getByUName(String s){
if(!userExists(s))return null;
UList u=getUsers();
Node p=u.root;
while(p!=null){if(p.d.name.equalsIgnoreCase(s))return p.d;p=p.next;}
return null;
}
/////////////////////////////////////////////////////////////
public static void main(String args[]){
Reader r=new Reader();
AList a=r.readArticleList();
a.dispNames();
}
/////////////////////////////////////////////////////////////
}