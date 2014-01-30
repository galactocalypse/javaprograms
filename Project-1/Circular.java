import java.io.*;
public class Circular{
    boolean isCircular(int n){
        int p=n*(n%10);
        int x=nod(n);
        p=(int)(((p%Math.pow(10,x-1))*10)+(int)(p/Math.pow(10,x-1)));
        if(p==n)return true;
        return false;   
    }
    public int nod(int x){
        int c=0;
        while(x>0){c++;x=x/10;}
        return c;
    }
    public static void main(String args[]){
        Circular c=new Circular();
        System.out.println("is circular? :" +c.isCircular(input("number to check")));
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
}