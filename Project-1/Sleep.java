import java.io.*;
public class Sleep{
    Time t1,t2;
    public int count(){
        int sum1=t1.getRemaining();
        int sum2=t2.getSpent();
        return (sum1+sum2);
    }
    public static void main(String args[]){
        Sleep s=new Sleep();
        Time a=new Time(),b=new Time();
        System.out.println("Enter sleeping time");
        a.h=input("hh : ");
        a.m=input("mm : ");
        a.s=input("ss : ");
        System.out.println("Enter time of waking up");
        b.h=input("hh : ");
        b.m=input("mm : ");
        b.s=input("ss : ");
        s.t1=a;
        s.t2=b;
        System.out.println(s.count());
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