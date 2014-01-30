import java.io.*;
public class VerticalHistogram{
    public void disp(int arr[]){
        int a=getMax(arr);
        for(int i=0;i<a;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[j]>=(a-i))System.out.print("* ");
                else System.out.print("  ");
            }
            System.out.println();
        }
        for(int i=0;i<arr.length;i++)System.out.print(i+" ");
        System.out.println();
    }
    public int getMax(int arr[]){
        int x=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>x)
            x=arr[i];
        }
        return x;
    }
    public int[] populate(){
        DataInputStream in=new DataInputStream(System.in);
        int arr[]=new int[10];
        System.out.println("Enter number of entries: ");
        try{
            int n=Integer.parseInt(in.readLine());  
            for(int i=0;i<n;i++){
                System.out.println("Enter value "+i+" : ");
                int x=Integer.parseInt(""+in.readLine().charAt(0));
                arr[x]++;
            }
        }
        catch(Exception e){}
        return arr;
    }
    public static void main(String args[]){
        VerticalHistogram v=new VerticalHistogram();
        v.disp(v.populate());
    }
}