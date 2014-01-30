import java.io.*;
public class MOP{
    public int mop(int x){
        return (x<=5)?x:((x%5==0)?5+mop(x/5):((x%3==0)?3+mop(x/3):((x%2==0)?2+mop(x/2):1+mop(x-1))));
    }
    public static void main(String args[]){
        MOP m=new MOP();    
        for(int x=1;x<160;x++){System.out.print("MOP of "+x+" : "+m.mop(x)+"\t\t");
        if(x%5==0)System.out.println();}
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