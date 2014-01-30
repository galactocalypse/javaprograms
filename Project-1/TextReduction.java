import java.io.*;
public class TextReduction{ 
    public int getChar(int a,int b){
        if(a+b<=26)return a+b+96;
        return Math.abs(a-b)+97;
    }
    boolean check(String s){
        if(s.length()>12)return false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)<97||s.charAt(i)>122)return false;
        }
        return true;
    }
    public String getReduced(String s){
        if(s==null)return null;
        if(s.length()<=1||!check(s))return s;
        String t="";
        for(int i=0;i<s.length()-1;i+=2){
            t=t+(char)getChar(s.charAt(i)-96,s.charAt(i+1)-96);
        }
        if(s.length()%2==1)t=t+s.charAt(s.length()-1);
        System.out.println(s);
        return getReduced(t);
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
        TextReduction t=new TextReduction();
        String s=t.input("string to reduce : ");
        System.out.println(t.getReduced(s));
    }
}