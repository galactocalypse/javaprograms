public class Viv{
public void disp(int i,int x){
if(i-1>x/2)return;
int a=0;
for(int j=i;j<=(x/2)+1;j++){
a=a+j;
if(a==x){
for(int k=i;k<=j;k++){System.out.print(k+" ");}
System.out.println();
}
}
disp(i+1,x);
}
public static void main(String args[]){
Viv v=new Viv();
v.disp(1,9);
}
}