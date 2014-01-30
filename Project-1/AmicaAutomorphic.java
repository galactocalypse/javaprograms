import java.io.*;
public class AmicaAutomorphic{
    int m,n;
    boolean automorphic(int x){
        for(int i=1;i<3;i++){       
            if((i*x*x)%Math.pow(10,nod(x))==x)return true;
        }
        return false;
    }
    public int nod(int x){
        int c=0;
        while(x>0){c++;x=x/10;}
        return c;}

    public int sumOfDivisors(int x){
        int s=0;
        for(int i=1;i<=x/2;i++){
            if(x%i==0)s=s+i;
        }
        return s;
    }   
    public boolean amicable(){  
        if(sumOfDivisors(m)==n&&sumOfDivisors(n)==m){
            return true;
        }
            return false;
    }
    public String accept(String s){
       DataInputStream in=new DataInputStream(System.in);
       try{
           System.out.println("Enter "+s+":");
           return in.readLine();
        }
        catch(Exception e){return null;}
    } 
    public static void main(String args[]){
        AmicaAutomorphic a=new AmicaAutomorphic();
        try{
        a.m=Integer.parseInt(a.accept("first number"));
        a.n=Integer.parseInt(a.accept("second number"));
        System.out.println("is automorphic : "+a.automorphic(Integer.parseInt(a.accept("number"))));   
        System.out.println("is amicable : "+a.amicable());
    }
    catch(Exception e){}
    }
}