import java.io.*;
public class Main{
public static void main(String args[]){
try{
Management m=new Management();
m.load();
switch(menu()){
case 1:
m.borrow();
break;
case 2:
m.returnbook();
break;
case 3:
m.displayAvailableBooks();
break;
case 4:
System.exit(0);

}
    }
    catch(Exception e){}
}
static int menu(){
DataInputStream in=new DataInputStream(System.in);
System.out.println("Enter choice : 1. Borrow 2. Return 3. Display Available Books 4. Exit");
try{return Integer.parseInt(in.readLine());}catch(Exception e){}
return 0;}
}