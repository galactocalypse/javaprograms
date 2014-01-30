import java.io.*;
public class SpecialNumbers{
    int m,n;
    public SpecialNumbers(){m=n=0;}
    public SpecialNumbers(int x,int y){
        m=x;
        n=y;
    }
    
    boolean abundant(){
        if(sumOfDivisors(m)>m&&sumOfDivisors(n)>n)return true;
        return false;
    }
    public boolean admirable(int x){
            int sum=sumOfDivisors(x);
            for(int i=1;i<x/2;i++){
                if(x%i==0)
                if(sum-(2*i)==x)
                return true;
            }
            return false;
    }
    public boolean compatible(){
            int sum1=sumOfDivisors(m);
            int sum2=sumOfDivisors(n);
            for(int i=1;i<m/2;i++){
                if(m%i==0&&sum1-(2*i)==n){
                    for(int j=1;j<n/2;j++){
                        if(n%j==0&&sum2-(2*j)==m)return true;
                    }
                }
            }
            return false;
    }
    public int sumOfDivisors(int x){
            int s=0;
            for(int i=2;i<x/2;i++){
                if(x%i==0)s=s+i;
            }
            return s;
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
            SpecialNumbers s=new SpecialNumbers(input("first number:"),input("second number:"));
            System.out.println(s.m+"\nAbundant : "+s.abundant()+"\nAdmirable : "+s.admirable(s.m));
            System.out.println(s.n+"\nAbundant : "+s.abundant()+"\nAdmirable : "+s.admirable(s.n));
            System.out.println(s.m+","+s.n+"\nCompatible : "+s.compatible());
                   
    }
    }