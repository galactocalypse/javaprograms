class Data{
int type,STRING=101,NUMBER=102,DATE=103;
String value;
boolean hasVal=false;
boolean isValid(Data d){
String s=d.value;
if(d.type==102){
for(int i=0;i<s.length();i++){
if(!Character.isDigit(s.charAt(i))){return false;}
}
}
else if(d.type==103){
try{String date=""+s.substring(0,2),month=s.substring(3,2),yr=s.substring(6,2);
int n1=Integer.parseInt(date);
int n2=Integer.parseInt(month);

int n3=Integer.parseInt(yr);

if(n1<=0||n1>31)throw new Exception();

}
catch(Exception e){return false;} 
}
return true;
}
}