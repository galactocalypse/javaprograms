import java.io.*;
public class Lojban{
    public int read(String s){
        int x=0;
        if(s.length()%2!=0||s.length()>8)return -1;
        for(int i=0;i<s.length()-1;i+=2){
            x=(10*x)+getNum(s.substring(i,i+2));
        }
        if(x>1000)return -1;
        return x;
    }
    public int getNum(String s){
        String arr[]={"no","pa","re","ci","vo","mu","xa","ze","bi","so"};   
        for(int i=0;i<arr.length;i++){
            if(s.equalsIgnoreCase(arr[i]))return i;
        }
        return 0;
    }
    public static void main(String args[]){
        Lojban l=new Lojban();
        System.out.println(l.read(input("string : ")));
    }
    public static String input(String s){  
        DataInputStream in=new DataInputStream(System.in);
        System.out.println("enter "+s); 
        try{
            return in.readLine();
        }
        catch(Exception e){
            return null;
        }
    }
}