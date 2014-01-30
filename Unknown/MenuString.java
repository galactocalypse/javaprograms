import java.io.*;
public class MenuString {
public static void main(String args[])throws Exception{
int freq=0;
BufferedReader buf=new BufferedReader(new InputStreamReader(System.in));
System.out.println("***MENU***\n1.Search Frequency\n2.Remove consonants");
switch (Integer.parseInt(buf.readLine())){
case 1:
System.out.println("Enter the sentence :");
String s=buf.readLine();
System.out.println("Enter the word :");
String w=buf.readLine();
String sarr[]=s.split(" ");
for(int i=0;i<sarr.length;i++){
if(sarr[i].equalsIgnoreCase(w))freq++;
}
System.out.println("Frequency : "+freq);
break;
case 2:
System.out.println("Enter the sentence : ");
String s2=buf.readLine();
String ns="";
for(int i=0;i<s2.length();i++){
if(!((s2.toLowerCase().charAt(i)!='a')&&(s2.toLowerCase().charAt(i)!='e')&&(s2.toLowerCase().charAt(i)!='i')&&(s2.toLowerCase().charAt(i)!='o')&&(s2.toLowerCase().charAt(i)!='u'))){
ns+=s2.charAt(i);
}
}
System.out.println("The new string is : "+ns);
break;
default :System.out.println("Request under process");
}
}
}
