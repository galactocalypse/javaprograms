import java.io.*;
public class Matrix{
    public int[][] rotate(int arr[][],int times){
        if(times==0)return arr;
        int a[][]=new int[arr.length][arr.length];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                a[j][arr.length-1-i]=arr[i][j];
            }
        }
        return rotate(a,times-1);
    }
    public int[][] reflectX(int arr[][]){
        for(int i=0;i<1+arr.length/2;i++){  
            for(int j=0;j<arr.length;j++){
                int t=arr[i][j];
                arr[i][j]=arr[arr.length-1-i][j];
                arr[arr.length-1-i][j]=t;
            }
        }
        return arr;
    }
    public int[][] reflectY(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<1+arr.length/2;j++){
                int t=arr[i][j];
                arr[i][j]=arr[i][arr.length-1-j];
                arr[i][arr.length-1-j]=t;
            }
        }
        return arr;
    }
    public int input(String s){
        System.out.println("enter "+s);
        DataInputStream in=new DataInputStream(System.in);
        try{return Integer.parseInt(in.readLine());}
        catch(Exception e){return 0;}
    }
    public int[][] acceptArr(int n){
        int arr[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=input("element ("+i+","+j+") : ");
            }
        }
        return arr;
    }
    public void disp(int arr[][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[i][j]+" \t ");
            }
            System.out.println();
        }
    }
    public int[][] generate(int n){
        int arr[][]=new int[n][n];  
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=1+(int)(Math.random()*n*n);
            }
        }
        return arr;
    }
    public int menu(){
        return input("choice :\n 1. Rotate by 90\n 2. Rotate by 180\n 3. Rotate by 270\n 4. Reflect about X axis\n 5. Reflect about Y axis\n 6. Exit");
    }
    public boolean cont(){      
        return input("1 to continue : ")==1;
    }
    public static void main(String args[]){
        Matrix m=new Matrix();
        int a[][]=m.generate(m.input("order of matrix : "));
        m.disp(a);
        do{
            switch(m.menu()){
                case 1:a=m.rotate(a,1);break;
                case 2:a=m.rotate(a,2);break;
                case 3:a=m.rotate(a,3);break;
                case 4:a=m.reflectX(a);break;
                case 5:a=m.reflectY(a);break;
                case 6:System.exit(0);
                default:System.out.println("invalid input!");
            }
            m.disp(a);
        }while(m.cont());
    }
}