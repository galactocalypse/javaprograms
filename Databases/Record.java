public class Record{
java.util.Date dob;
String name;
String phno;
String address;
public Record(String str[]){
new Record(str[0],str[1],str[2],str[3],str[4],str[5]);
}
public Record(String name,String address,String phno,String date,String mth,String yr){
this.name=name;
address=address;
phno=phno;
dob=new java.util.Date(Integer.parseInt(date),Integer.parseInt(mth),Integer.parseInt(yr));
}
public String accept(String str){
java.io.DataInputStream in=new java.io.DataInputStream(System.in);
System.out.print("\nEnter the "+str+" : ");
try{
return in.readLine();
}
catch(Exception e){System.err.println(e.getMessage());
return null;
}
}
public void input(){
name=accept("name");
phno=accept("name");
address=accept("address");
dob=new java.util.Date(Integer.parseInt(accept("date")),Integer.parseInt(accept("month")),Integer.parseInt(accept("year")));
System.out.println("Inputs taken.");
}
}