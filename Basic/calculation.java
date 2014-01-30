import java.io.*;
public class calculation
{
    public void input()throws Exception
    {
          
           DataInputStream in=new DataInputStream(System.in);
            int m[]=new int[5];
           System.out.println("Enter name:");
           String str=in.readLine();
           System.out.println("enter cls;");
           int cls=Integer.parseInt(in.readLine());
           System.out.println("Ente maks of 5 subjects");
           for(int i=0;i<5;i++)
           {
                m[i]=Integer.parseInt(in.readLine());
            }
    }
}