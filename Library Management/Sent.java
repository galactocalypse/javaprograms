import java.io.*;
public  class Sent
{
    BufferedReader inp=new BufferedReader(new InputStreamReader(System.in));
    String s;
    public void accept()
    {
        try{System.out.println("Enter the String to be computed upon");
        s=inp.readLine();}catch(Exception e){}
    }
    public void compute()
    {
        String temp="",ns="",vs="",fs="";
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='.'||s.charAt(i)=='?'||s.charAt(i)=='!')
            {ns=arrange(temp);fs=fs+ns;System.out.println(temp);}
            temp=temp+s.charAt(i);
            vs=vs+"  "+findV(temp);
        }
        System.out.println("INPUT: "+s);
        System.out.println("OUTPUT: "+fs);
        System.out.println("VOWELS: "+vs);
    }
    public String arrange(String k)
    {   String t="";
        int c=0,i;
        for(i=0;i<k.length();i++)
        if(k.charAt(i)==' ')c++;
        String arr[]=new String[c+1];
        c=0;
        for(i=0;i<k.length();i++)
        {
            if(k.charAt(i)==' ')
            {arr[c++]=t;t="";System.out.println(arr[c]);}
             t=t+k.charAt(i);
        }t="";
        for(i=0;i<arr.length;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[i].compareTo(arr[j]) < 0)
                {   t=arr[i];
                    arr[i]=arr[j];
                    arr[j]=t;
                }
            }
        }
        t="";
        for(i=0;i<arr.length;i++)
        t=t+arr[i];
        return t;
    }

    public String findV(String k)
    {
        String t="",g="";
        int i,c=0;
        for(i=0;i<k.length();i++)
        {
            t=t+k.charAt(i);
            if(k.charAt(i)==' ')
            {
             if(t.charAt(0)=='a'||t.charAt(0)=='e'||t.charAt(0)=='i'||t.charAt(0)=='o'||t.charAt(0)=='u') 
                g=g+t;
                t="";
            }
            
        }
        return g;
   }
   public static void main(String args[])
   {
       Sent ob=new Sent();
       //ob.accept();
       //ob.compute();
       System.out.println(ob.findV("oppp de mon app"));
    }
    }