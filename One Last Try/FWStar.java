import java.io.*;
public class FWStar{
public void disp(int n){
if(n<2){System.out.println("Please enter values greater than or equal to 2.");System.exit(0);}
for(int i=0;i<n+1;i++){
for(int j=0;j<(5*n)-2-i;j++)System.out.print(" ");
for(int j=0;j<(2*i)+1;j++)System.out.print("*");
System.out.println();
}
for(int i=0;i<n;i++){
for(int j=0;j<(3*i);j++)System.out.print(" ");
for(int j=0;j<(10*n)-3-(6*i);j++)System.out.print("*");
System.out.println();
}
for(int i=0;i<n+1;i++){
for(int j=0;j<(3*n)-i-3;j++)System.out.print(" ");
for(int j=0;j<(2*n)+1-(2*i);j++)System.out.print("*");
for(int j=0;j<(6*i)+1;j++)System.out.print(" ");
for(int j=0;j<(2*n)+1-(2*i);j++)System.out.print("*");
System.out.println();
}
}
public static void main(String args[]){
FWStar d=new FWStar();
d.disp(d.input());
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