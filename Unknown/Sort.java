import java.io.*;
public class Sort {
int arr[];
Sort(){
arr=new int[5];
}
public void accept(){
DataInputStream in=new DataInputStream(System.in);
for(int i=0;i<arr.length;i++){
System.out.println("Enter element "+i+" : ");
try{
arr[i]=Integer.parseInt(in.readLine());
}
catch(Exception e){}
}
}
public void sortBub(){
for(int i=0;i<arr.length-1;i++){
for(int j=i+1;j<arr.length;j++){
System.out.println("i : "+i+"\tj : "+j);
if(arr[j]<arr[i]){
int t=arr[i];
arr[i]=arr[j];
arr[j]=t;
}
disp();
}
}
}
public void sortSel(){
for(int i=0;i<arr.length-1;i++){
int min=i;
for(int j=i+1;j<arr.length;j++){
System.out.println("i : "+i+"\tj : "+j);
if(arr[j]<arr[min]){min=j;
}
}
disp();
if(i!=min){int t=arr[min];arr[min]=arr[i];arr[i]=t;}
}
}
public void disp(){
for(int i=0;i<arr.length;i++)System.out.print("\t"+arr[i]);
System.out.println();
}
public static void main(String args[]){
Sort b=new Sort();
b.accept();
b.disp();
b.sortSel();
b.disp();
}
}