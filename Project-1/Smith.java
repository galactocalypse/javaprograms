import java.io.*;
public class Smith{
    public boolean isPrime(int n){
        for(int i=2;i<n/2;i++){if(n%i==0)return false;}
        return true;
    }
    public int sod(int x){
        int sum=0;
        while(x>0){sum=sum+(x%10);x=x/10;}
        return sum;
    }
    public int sumOfFactors(int n){
        int sum=0;
        for(int i=2;i<n/2;i++){
            if(n%i==0&&isPrime(i)){
                int x=n;
                while(x%i==0){sum=sum+sod(i);x=x/i;
                }
            }
        }
        return sum;
    }
    public boolean isSmith(int n){
        if(sumOfFactors(n)==sod(n))return true;return false;
    }
    public static void main(String args[]){
        Smith s=new Smith();
        int x=input("number to check : ");
        System.out.println("Is "+x+" Smith:"+s.isSmith(x));
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