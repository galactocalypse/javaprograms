class SpiralMatrix
{
public static void main(int m)
{
int n=m,arr[][]=new int[n][n],ptr=1,ox=0,oy=0;
while(n>0)
{
arr[ox][oy]=ptr;
for(int i=0;i<n-1;i++,ptr++)
{
arr[ox][oy+i]=ptr;
arr[ox+i][oy+n-1]=ptr+n-1;
arr[ox+n-1][oy+n-1-i]=ptr+n-1+n-1;
arr[ox+n-1-i][oy]=ptr+n-1+n-1+n-1;
}
ptr+=(n*3)-3;
n=n-2;
ox=++oy;
}
for(int i=0;i<m;i++)
{
for(int j=0;j<m;j++)
System.out.print(arr[i][j]+"\t");
System.out.println();
}
}
}