import java.io.* ;
class menupattern {
public static void main (String args[])throws IOException { int i,j,c=1;
BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
System.out.println("***MENU***");
System.out.println("1 for flyod's triangle");
System.out.println("2 for surprise pattern");

switch(Integer.parseInt(buf.readLine())){
case 1:
System.out.println("enter number of lines");
int lines=Integer.parseInt(buf.readLine());


for (i=1;i<=lines;i++)
{
for (j=1;j<=i;j++)
{
System.out.print (c);
c++;
    }
    System.out.println();
}
break;
case 2:
System.out.println("Enter lines");
int lines2=Integer.parseInt(buf.readLine());
int i3,j4;
for (i3=1;i3<=lines2;i3++)
{
for(j4=1;j4<=i3;j4++)
{
System.out.print("*"+i3);
}
System.out.println();
}
break;
default :
System.out.println("wrong");
}}}

