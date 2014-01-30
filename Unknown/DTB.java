class DTB{
public static void main(String args[]){
System.out.println(""+(char)32);
for(int i=0;i<16;i++){
int bs=0,pow=0;
int x=i;
while(x>0){
if(x%2==1){
bs=bs+(int)Math.pow(10,pow);
}
x=x/2;

pow++;
}
System.out.println(i+" : "+bs);
}
}
}