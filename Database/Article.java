public class Article extends Element{
String type, data[], dateadded, author,contributors[], keywords[], resources[];//resource ids
public Article(int id,String n){
super(id,n);
}
public Article(int id, String n,String t, String aut,String contrib[],String key[],String res[],String d[]){
super(id,n);
type=t;
author=aut;
contributors=contrib;
keywords=key;
resources=res;
data=d;
}
String[] getString(){
String s[]=new String[7+data.length];
s[0]=""+id;
s[1]=name;
s[2]=type;
s[3]=author;
s[4]=""+Reader.getString(contributors);
s[5]=""+Reader.getString(keywords);
s[6]=""+Reader.getString(resources);
for(int i=7;i<s.length;i++)s[i]=data[i-7];
return s;
}
String disp(){
return name+"\nType : "+type+"\nAuthor : "+author+"\nKeywords : "+Reader.getString(keywords)+"\nDescription : "+Reader.getString(data)+"\nResources : "+Reader.getString(resources)+"\nContributors : "+Reader.getString(contributors);
}
}