class Name{
int r,i,j;
void display(String str){
r=(int)((str.length()-1)/2);
int i=0;
while(i<str.length()){
if(i!=r){
for(j=0;j<r;j++)
System.out.print(" ");
System.out.println(str.charAt(i));
}
else {System.out.println(str);}
i++;
}
}
}