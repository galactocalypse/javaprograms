import java.io.*;
public class Shuffle{
    int arr[]={1,2,3,4,5,6,7,8};

    public void b(int n){
        if(n<=0)return;
        int x=arr[0];
        for(int i=1;i<arr.length;i++){
            arr[i-1]=arr[i];
        }
        arr[arr.length-1]=x;
        b(n-1);
    }

    public void riffle(int type,int n){
        if(n==0)return;
        int a2[]=new int[arr.length];
        for(int i=0;i<arr.length-1;i+=2){
            if(type==0){a2[i]=arr[(arr.length/2)+(i/2)];
                a2[i+1]=arr[i/2];
            }
            else {a2[i+1]=arr[(arr.length/2)+(i/2)];
                a2[i]=arr[i/2];
            }
        }
        riffle(type,n-1);
    }

    void shuffle(String s){
     try{
         if(s==null||s.length()==0)return;
         if(s.charAt(0)<47&&s.charAt(0)>58)s="1"+s;
         if(s.length()>=2){
            try{
                System.out.println(s);operate(s.charAt(1),Integer.parseInt(""+s.charAt(0)));}catch(Exception e){}
                shuffle(s.substring(2,s.length()));
            }
        }   
    catch(Exception e){
        System.out.println("Invalid input! Program terminating...");
    }

}
   
   void operate(char ch,int n){
       switch(ch){
           case 'b':
           case 'B':
           b(n);    
           break;
           case 'i':
           case 'I':
           riffle(1,n); 
           break;
           case 'o':
           case 'O':    
           riffle(0,n);
           break;
        }
    }
    public void disp(){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public void doIt(String s){
        try{
        if(s==null)return;
        int p1=0,p2=0;
        while(p2<s.length()){
            if(s.charAt(p2)=='(')p1=p2;
            else if(s.charAt(p2)==')')break;
            p2++;
        }
        String p=s.substring(p1+1,p2);
        System.out.println("p:"+p);
        shuffle(p);
        if(p2<s.length())s=s.substring(0,p1)+s.substring(p2+1,s.length());
        else s=s.substring(0,p1);

    System.out.println("s:"+s);
    doIt(s);
    }
    catch(Exception e){
        System.out.println("Invalid input! Program terminating...");
    }
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
        Shuffle s=new Shuffle();
        s.doIt(s.input("string to process"));
        s.disp();
    }
}