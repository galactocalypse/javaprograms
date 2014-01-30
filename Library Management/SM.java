public class SM {
public int[][] spiral(int n){
int arr[][]=new int [n][n];
int t=0,ptr=1;
while(ptr<(n*n)){
for(int i=0;i<n-(2*t);i++){
arr[t][t+i]=ptr+i;
arr[t+i][n-t-1]=ptr+n-(2*t)-1+i;
arr[n-t-1][n-t-i-1]=ptr+((n-(2*t)-1)*2)+i;
arr[n-t-1-i][t]=ptr+((n-(2*t)-1)*3)+i;
}
ptr=ptr+((n-(2*t)-1)*4);
t++;
arr[t][t]=ptr;
}
return arr;
}

void disp(int arr[][]){
for(int i=0;i<arr.length;i++){
for(int j=0;j<arr.length;j++){
System.out.print(arr[i][j]+"\t");
}
System.out.println();
}
}
public static void main(String args[]){
SM sm=new SM();
sm.disp(sm.spiral(7));
}
}