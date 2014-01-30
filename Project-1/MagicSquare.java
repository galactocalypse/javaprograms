import java.io.*;
public class MagicSquare{
    int arr[][];
    int n;
    MagicSquare(){
        n=0;
        arr=null;   
    }
    public void accept(){
        DataInputStream in=new DataInputStream(System.in);
        System.out.println("Enter n:");
        try{
            n=Integer.parseInt(in.readLine());
            arr=new int[n][n];
        }
        catch(Exception e){}
    }
    public boolean checkMagic(){
        int s1=0,s2=0;
        int sum=(int)(0.5*n*((n*n)+1));
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                s1=s1+arr[i][j];
                s2=s2+arr[j][i];
            }
            if(s1!=sum||s2!=sum)return false;
        }
        return true;    
    }     
    public void disp(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(arr[i][j]+" ");
            }   
            System.out.println();
        }
    }
    public void generate(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int x=1+((int)(Math.random()*(n*n)));
                do{
                    x=1+((int)(Math.random()*n*n));
            }
                while(isPresent(x));
                arr[i][j]=x;
            }
        }
    }
    public boolean isPresent(int x){
        if(arr==null)return false;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j]==x)return true;
            }
        }
        return false;
    }
    public static void main(String args[]){
        MagicSquare m=new MagicSquare();
        m.accept();
        System.out.println("generating random matrix...");
        m.generate();
        m.disp();
        System.out.println("Is magic square : "+m.checkMagic());
    }
}