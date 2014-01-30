import java.io.*;

class Inpt{
public static String input(String str){
DataInputStream in=new DataInputStream(System.in);
try{
System.out.println("Enter "+str+" : ");
return in.readLine();
}
catch(Exception e){
return null;
}
}
public static void takeno(){
try{
String name=input("name");

int cls=Integer.parseInt(input("class"));
}
catch(Exception e){
System.err.println("Invalid inpt!");
}
}
}
