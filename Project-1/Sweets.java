import java.io.*;
public class Sweets{
    public int findChild(int n,int m){
        int arr[]=new int[n];
        int ptr=0;
        do{
            for(int i=0;i<m;i++){
                ptr=(ptr+1)%arr.length;
                while(arr[ptr]==1)ptr=(ptr+1)%arr.length;
            }
            arr[ptr]=1;
            while(arr[ptr]==1)ptr=(ptr+1)%arr.length;
        }   
        while(!gameOver(arr));
        for(int i=0;i<arr.length;i++){if(arr[i]==0)ptr=i;}
        return ptr+1;
    }
    public boolean gameOver(int arr[]){
        int sum=0;
        for(int i=0;i<arr.length;i++)sum+=arr[i];
        if(sum!=arr.length-1)return false;
        return true;
    }
    
   public String input(String s){
       DataInputStream in=new DataInputStream(System.in);
       try{
           System.out.println("Enter "+s+":");
           return in.readLine();
        }
        catch(Exception e){return null;}
    }    
    public static void main(String args[]){
        Sweets s=new Sweets();
        try{
            int n=Integer.parseInt(s.input("n"));
            int m=Integer.parseInt(s.input("m"));
            System.out.println("Sweet goes to child "+s.findChild(n,m));
        }
        catch(Exception e){}
    }
}