import java.io.*;
public class LatinSquares{
    public void disp(int n){
        if(n<2||n>9)return;
        int arr[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=((i+j)%n)+1;
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
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
        LatinSquares l=new LatinSquares();
        l.disp(input("length of array :"));
    }
}