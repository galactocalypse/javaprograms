public class GrayCode{

public String[] getCode(String str[]){
String rs[]=new String[str.length*2],str2[]=rev(str);
str=mul(str,'0');
str2=mul(str2,'1');
for(int i=0;i<str.length;i++){
rs[i]=str[i];
rs[str.length+i-1]=str2[i];
}
return rs;
}
public String[] rev(String str[]){
String rs[]=new String[str.length];
for(int i=0;i<str.length;i++){
rs[i]=str[str.length-1-i];
}
return rs;
}
public String[] mul(String str[],char ch){
for(int i=0;i<str.length;i++){
str[i]=""+ch+str[i];
}
return str;
}
public static void main(){
GrayCode gc=new GrayCode();
String[] s1={"0","1"};

}

}