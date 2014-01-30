import java.io.*;
public class teeTEE {
BufferedReader ob=new BufferedReader(new InputStreamReader(System.in));
void printee()throws IOException
{      int flag=0,i,j,k;
System.out.println("Enter an odd positive number");
int num= Integer.parseInt(ob.readLine());
int d=num-1;
while(flag==0)
{
if(num>0&&num<21)
{if(num%2!=0)
{flag=1;
int c=(num+1)/2;
for(i=1;i<=num;i++)
{
System.out.print("t");
}
System.out.println();
for(j=1;j<=d;j++)
{
for(k=1;k<c;k++)
{
System.out.print(" ");
}
System.out.print("t");
System.out.println();
}}
}if(flag==0)
{System.out.println("Enter the number again..r u blind..crazy insane???");
num=Integer.parseInt(ob.readLine());
    }
}}}