import java.io.*;
public class Sum{
    public void findWays(int n){
        int ctr=0;
        for(int i=1;i<=n-3;i++){
            for(int j=i;j<=n-i;j++){
                for(int k=j;k<=n-i-j;k++){
                    for(int l=k;l<=n-i-j-k;l++){
                        if(i+j+k+l==n){System.out.println(n+" = "+i+"+"+j+"+"+k+"+"+l);ctr++;}
                    }
                }
            }
        }
        System.out.println("No. of ways:"+ctr);
    }
    public static void main(String args[]){ 
        Sum s=new Sum();
        s.findWays(input("number : "));
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