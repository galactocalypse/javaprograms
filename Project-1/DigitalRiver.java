import java.io.*;
public class DigitalRiver{
    public int getMeetingPoint(int n){
        int x1=1,x2=3,x3=9,x4=n;
        do{
            int temp=x4;
            if(x1>x4)x4=x4+sod(x4);
            while(x1<x4)x1=x1+sod(x1);
            if(x1==x4)return x1;
            x4=temp;
            if(x2>x4)x4=x4+sod(x4);
            while(x2<x4)x2=x2+sod(x2);
            if(x2==x4)return x2;
            x4=temp;
            if(x3>x4)x4=x4+sod(x4);
            while(x3<x4)x3=x3+sod(x3);
            if(x3==x4)return x3;
            x4=x4+sod(x4);
        }
        while(!meets(x1,x4)&&!meets(x2,x4)&&!meets(x3,x4));
        return x1;
    }
    public boolean meets(int a,int n){  
        if(a>n)return false;    
        if(a==n)return true;
        return meets(a+sod(a),n);
    }
    public int sod(int x){
        int sum=0;
        while(x>0){sum=sum+x%10;x=x/10;}
        return sum;
    }
    public static void main(String args[]){
        DigitalRiver d=new DigitalRiver();
        System.out.println(d.getMeetingPoint(input(" number :")));
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