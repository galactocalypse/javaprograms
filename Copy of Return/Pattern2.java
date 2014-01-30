import java.io.*;
public class Pattern2{
public static void disp(int n){
for(int i=0;i<n;i++){
for(int j=0;j<n-i-1;j++){
System.out.print(" ");
}

for(int j=0;j<=i;j++){
System.out.print((i+1)+" ");
}
System.out.println();}
}
public int accept(){
System.out.print("Enter a number:");
DataInputStream in=new DataInputStream(System.in);
try{return Integer.parseInt(in.readLine());
}
catch(Exception e){return 0;}
}
public static void main(String args[]){
Pattern2 p = new Pattern2();
p.disp(p.accept());
}
}