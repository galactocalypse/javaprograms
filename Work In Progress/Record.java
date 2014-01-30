public class Record{
Data d[];
public String[] getData(){
String str[]=new String[d.length];
for(int i=0;i<str.length;i++){
str[i]=d[i].getVal();
}
return str;
}
public void clear(int i){
d[i].val="";
}
public void clearAll(){
for(int i=0;i<d.length;i++)clear(i);
}

}