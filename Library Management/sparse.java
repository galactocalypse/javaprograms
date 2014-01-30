class sparse
{
public static void main(int n)
{
int a[][]=new int[n][n];
int m=1,c=1,x=0,y=1;
while(c<=n)
{
if(c%2!=0)
{
for(int i=x;i<=n-x-1;i++)
a[x][i]=m++;
for(int i=x+1;i<=n-x-1;i++)
a[i][n-x-1]=m++;
x++;
}
else
{
m--;
for(int i=n-y;i>=y-1;i--)
a[n-y][i]=m++;
for(int i=n-y-1;i>=y;i--)
a[i][y-1]=m++;
y++;
}
c++;
}
for(int i=0;i<n;i++)
{
for(int j=0;j<n;j++)
System.out.print(a[i][j]);
System.out.println();
}
}
}