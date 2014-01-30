import java.util.*;
public class LED implements Runnable{
public void disp(){
Date d=new Date();
String h=""+d.getHours(),m=""+d.getMinutes(),s=""+d.getSeconds();
char n[]=new char[h.length()+m.length()+s.length()+2];

for(int i=0;i<h.length();i++){
n[i]=Integer.parseInt(""+h.charAt(i));
}
n[h.length()]=":";
for(int i=0;i<m.length();i++){
n[i+h.length()]=Integer.parseInt(""+m.charAt(i));
}
n[h.length()+m.length()]=":";
for(int i=0;i<s.length();i++){
n[h.length()+m.length()+i]=Integer.parseInt(""+s.charAt(i));
}

String ss[]=getCS(n);
System.out.println(ss[0]+"\n"+ss[1]+"\n"+ss[2]);
}
public String[] getCS(int n[]){
String str[]=new String[n.length];
str[0]=str[1]=str[2]="";
for(int i=0;i<n.length;i++){
String ts[]=getStrings(n[i]);
str[0]=str[0]+" "+ts[0];
str[1]=str[1]+" "+ts[1];
str[2]=str[2]+" "+ts[2];
}
return str;
}
public String[] getStrings(int num){
String str[]=new String[3];
switch(num){
case 1:
str[0]="   ";
str[1]="  |";
str[2]="  |";
break;
case 2:
str[0]=" _ ";
str[1]=" _|";
str[2]="|_ ";
break;
case 3:
str[0]=" _ ";
str[1]=" _|";
str[2]=" _|";
break;
case 4:
str[0]="   ";
str[1]="|_|";
str[2]="  |";
break;
case 5:
str[0]=" _ ";
str[1]="|_ ";
str[2]=" _|";
break;
case 6:
str[0]=" _ ";
str[1]="|_ ";
str[2]="|_|";
break;
case 7:
str[0]=" _ ";
str[1]="  |";
str[2]="  | ";
break;
case 8:
str[0]=" _ ";
str[1]="|_|";
str[2]="|_|";
break;
case 9:
str[0]=" _ ";
str[1]="|_|";
str[2]=" _|";
break;
case 0:
str[0]=" _ ";
str[1]="| |";
str[2]="|_|";
break;
}
return str;
}
public void run(){
for(int i=0;i<10;i++){
disp();
try{Thread.sleep(1000);
}
catch(Exception e){}
}
}
public static void main(String args[]){
LED l=new LED();
Thread t=new Thread(l);
t.start();
}
}