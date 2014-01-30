import java.io.*;
class SelectionSort{
public static void main(String args[])throws IOException{
int i,j,pos;
String s[]={"I","love","my","country"};
int n=4;
for (i = 0; i <n-1; i++)
{
int min = i;
for (j = i + 1; j <n; j++)
{
if (s[j].length()<s[min].length())
{
min = j;
}
}
if (s[i].length() != s[min].length()) 
{
String swap = s[i];
s[i] = s[min];
s[min] = swap;
}
}
for(i=0;i<4;i++){
System.out.print(s[i]+" ");
}
}
}