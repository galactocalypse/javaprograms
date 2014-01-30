import java.io.*;
public class tj{
public static void main(String args[])throws IOException{
BufferedReader ob=new BufferedReader(new InputStreamReader(System.in));
int count=0;
int x[]=new int[10];
System.out.println("Enter your name lolzzzzzzzzzzzz");
String s=ob.readLine();
System.out.println("enter your marks...like it matterz to me haaan");
for(int i=0;i<5;i++)
{
x[i]=Integer.parseInt(ob.readLine());
}
for(int k=100;k>0;k--)
{for(int j=0;j<5;j++)
{
if(k==x[j])
{
System.out.println(x[j]);
count++;
} }
if(count ==4)
{
break;
}
}
}
}