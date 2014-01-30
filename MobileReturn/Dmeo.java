public class Dmeo {

public String[] sort(String s[]){
for(int i=0;i<s.length-1;i++){
s[i]=s[i].toLowerCase();
for(int j=i+1;j<s.length;j++){

if(s[j].length()<s[i].length()){
	String t=s[i];
	s[i]=s[j];
	s[j]=t;
}

	else if(s[j].length()==s[i].length()){
	int ptr=0;
	while((s[i].charAt(ptr)==s[j].charAt(ptr))&&(ptr<(s[i].length()<s[j].length()?s[j].length():s[i].length())))ptr++;
		if(s[j].length()-1==ptr){String t=s[i];
	s[i]=s[j];
	s[j]=t;
	}
else if(s[i].length()-1==ptr)continue;
else if(s[j].charAt(ptr)<s[i].charAt(ptr)){
String t=s[i];
s[i]=s[j];
s[j]=t;
}
}
}
}
return s;

}
public void disp(String s[]){
for(int i=0;i<s.length;i++){
System.out.println(s[i]);
}
}
public static void main(String args[]){
Dmeo d=new Dmeo();
String s[]=args[0].split(" ");
d.disp(d.sort(s));
}
}