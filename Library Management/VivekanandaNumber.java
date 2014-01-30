import java.io.*;
public class VivekanandaNumber
{
    public static void main()throws Exception
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number : ");
        int n=Integer.parseInt(in.readLine());
        int a;
        for(int i=1;i<=(n/2)+1;i++)
        {
            a=0;
            for(int j=i;j<=(n/2)+1;j++)
            {
                a+=j;
                if(a==n)
                {
                    System.out.println();
                    for(int k=i;k<=j;k++)
                        System.out.print(k+"  ");
                }
                else if(a>n)
                    break;
                else
                    continue;
            }
        }
    }
}