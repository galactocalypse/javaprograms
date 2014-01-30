import java.io.*;
public class Pattern1 {
public void disp(int n){
for(int i=1;i<=n;i++){
for(int j=1;j<=n;j++){
if(j<=n-i)System.out.print(" ");
else System.out.print(n-j+1);
}
System.out.println();
}
}
public int accept(){
System.out.print("Enter a number:");
DataInputStream in=new DataInputStream(System.in);
try{return Integer.parseInt(in.readLine());
}
catch(Exception e){return 0;}
}
public static void main(String args[]){
Pattern1 p = new Pattern1();
p.disp(p.accept());
}
}