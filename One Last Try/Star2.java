import java.io.*;
public class Star2{
public void disp(int n){
for(int i=0;i<n-1;i++){
for(int j=0;j<(2*n)-i-2;j++)System.out.print(" ");
for(int j=0;j<(2*i)+1;j++)System.out.print("*");
System.out.println();
}
for(int i=0;i<n-1;i++){
for(int j=0;j<i;j++)System.out.print(" ");
for(int j=0;j<(4*n)-3-(2*i);j++)System.out.print("*");
System.out.println();
}
for(int i=0;i<n-1;i++){
for(int j=0;j<n-i-2;j++)System.out.print(" ");
for(int j=0;j<n-i;j++)System.out.print("*");
for(int j=0;j<(4*i)+1;j++)System.out.print(" ");
for(int j=0;j<n-i;j++)System.out.print("*");
System.out.println();
}
}public static void main(String args[]){
Star2 s=new Star2();
s.disp(s.input());
}
int input(){
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
try{
System.out.println("Enter edge length : ");
return Integer.parseInt(br.readLine());
    }
    catch(Exception e){
System.out.println("Invalid input");
return -1;
}
}
}