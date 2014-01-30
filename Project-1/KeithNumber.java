import java.io.*;
public class KeithNumber{
    public boolean checkKeith(int n, int arr[]){
        int next=sum(arr);
        if(next==n)return true;
        if(next>n)return false;
        return checkKeith(n,addToTop(arr,next));
    }
    public int sum(int arr[]){
        int s=0;
        for(int i=0;i<arr.length;i++){
            s=s+arr[i];
        }
        return s;
    }
    public int[] addToTop(int a[],int x){
        for(int i=1;i<a.length;i++){
            a[i-1]=a[i];
        }
        a[a.length-1]=x;
        return a;
    }
    public static int[] input(String s){  
        DataInputStream in=new DataInputStream(System.in);
        System.out.println("enter "+s); 
        try{
            String s1=in.readLine();
            int arr[]=new int[s1.length()];
            for(int i=0;i<arr.length;i++)arr[i]=getInt(s1.charAt(i));
        }
        catch(Exception e){}
        return null;
    }
    public static int getInt(char ch){
        try{ return Integer.parseInt(""+ch);}
        catch(Exception e){
        return 0;}
    }
    static int getNum(int arr[]){
        int sum=0;
        for(int i=0;i<arr.length;i++)sum=(sum*10)+arr[arr.length-1-i];
        return sum;
    }
    public static void main(String args[]){
        KeithNumber k=new KeithNumber();
        int a[]=input("number : ");
        int x=getNum(a);
        System.out.println("Is "+x+" Keith :"+k.checkKeith(x,a));
}
}