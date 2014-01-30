import java.io.*;
public class Permutation
{
public static void main()throws Exception
{
BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter a string containing exactly 4 characters. Anything more or less will make you suffer.");
String s=in.readLine();
String a[]=new String[4];
for(int x=0;x<4;x++)
{
a[x]="";
a[x]+=s.charAt(x);
}
for(int i=0;i<4;i++)
{
for(int j=0;j<4;j++)
{
if(j==i)
continue;
for(int k=0;k<4;k++)
{
if(k==i||k==j)
continue;
for(int l=0;l<4;l++)
{
if(l==i||l==j||l==k)
continue;
System.out.println(a[i]+a[j]+a[k]+a[l]);
}
}
}
}
}
}
