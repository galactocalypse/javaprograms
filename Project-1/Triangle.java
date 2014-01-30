import java.io.*;
public class Triangle{
    public void disp(int n){
        for(int i=1;i<=n;i++){
            int k=0;
            for(int j=1;j<=i;j++){
                System.out.print(" "+(i+j+k-1)+" ");
                k=k+n-j-1;
            }
            System.out.println();
        }
    }
    public static int input(String s){  
        DataInputStream in=new DataInputStream(System.in);
        System.out.println("enter "+s); 
        try{
            return Integer.parseInt(in.readLine());
        }
        catch(Exception e){
            return 0;
        }
    }
    public static void main(String args[]){
        Triangle t=new Triangle();
        t.disp(input("n : "));
    }
}