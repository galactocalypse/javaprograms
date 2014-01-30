import java.io.*;
class BinSearch {
int i,arr[],temp,s,hi,low,mid;
DataInputStream in=new DataInputStream(System.in);
BinSearch(int n){
arr=new int[n];
}
BinSearch(){
System.out.println("Enter array length : ");
try{
int x=Integer.parseInt(in.readLine());
if(x==0){
System.out.println("Error!");
System.exit(0);
}
arr=new int[x];
}
catch(Exception e){
System.out.println("Invalid Entry!");
System.exit(0);
}
}
void accept(){
for(i=0;i<arr.length;i++){
System.out.print("Enter element "+(i+1)+" : ");
try{
arr[i]=Integer.parseInt(in.readLine());
}
catch(Exception e){
System.out.println("Invalid Entry!");
System.exit(0);
}
}
}

void search(){
System.out.println("Enter search term : ");
try{
s=Integer.parseInt(in.readLine());
}
catch(Exception e){}
hi=arr.length-1;
low=0;
if(hi!=0)mid=(low+hi)/2;
for(;;mid=(low+hi)/2){
if(arr[mid]==s){
System.out.println("Element "+s+" found at : array["+mid+"]");
temp=s;
break;
}else{ if(arr[mid]<s){
low=mid;mid=(low+hi)/2;}
else {hi=mid;mid=(low+hi)/2;}
}
}
}
void bubble(){
for(i=0;i<arr.length-1;i++){
if(arr[i]>arr[i+1]){
temp=arr[i];
arr[i]=arr[i+1];
arr[i+1]=arr[i];
}
}
}
public void finalize()throws Throwable{
super.finalize();
}
public static void main(String args[])throws Throwable{
BinSearch b=new BinSearch();
b.accept();
b.bubble();
b.search();
b.finalize();
}
}