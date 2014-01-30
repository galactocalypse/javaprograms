public class StringMan{
public String getVows(String str){
String arr[]=str.split(" ");
String s="";
for(int i=0;i<arr.length;i++){
char ch=arr[i].toLowerCase().charAt(0);
if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
s=s+arr[i]+" ";
}
return s.trim();
}
public void compute(String str){
String temp="",fs="",vs="";
for(int i=0;i<str.length();i++){
char ch=str.charAt(i);
temp=temp+ch;
if(i==str.length()-1||ch=='.'||ch=='!'||ch=='?'){
fs=fs+" "+arrange(temp.trim());
vs+=getVows(temp.trim())+" ";
temp="";
}
}
System.out.println("Input : "+str+"\nOutput : "+fs.trim()+"\nVowels : "+vs.trim());
}
public String arrange(String s){
String arr[]=s.split(" ");
String temp="";
for(int i=0;i<arr.length-1;i++){
for(int j=i;j<arr.length;j++){
if(arr[j].toLowerCase().charAt(0)<97||arr[j].toLowerCase().charAt(0)>122)continue;
if(arr[i].toLowerCase().compareTo(arr[j].toLowerCase())>0){temp=arr[i];
arr[i]=arr[j];
arr[j]=temp;
    }
}
}
String res="";
for(int i=0;i<arr.length;i++){
res=res+" "+arr[i];
}
return res.trim();
}
public static void main(String args[]){
StringMan sm=new StringMan();
sm.compute("oppp mon app");
}
}