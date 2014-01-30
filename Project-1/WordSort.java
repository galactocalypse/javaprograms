import java.io.*;
public class WordSort{
    String str;
    public void arrangewords(boolean b){
        String arr[]=str.split(" ");
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                boolean g=isGreater(arr[i],arr[j]);
                if((g&&b)||(!g&&!b)){
                    String t=arr[i];
                    arr[i]=arr[j];
                    arr[j]=t;
                }
            }
        }
        str=arr[0];
        for(int i=1;i<arr.length;i++)str=str+" "+arr[i];
    }
    public String swapwords(){
        String arr[]=str.split(" ");
        String s=arr[0];
        for(int i=1;i<arr.length;i++){
            s=arr[i]+" "+s;
        }
        return s;
    }
    public boolean isGreater(String s1, String s2){
        s1=s1.toUpperCase();
        s2=s2.toUpperCase();
        int ptr=0,min=((s1.length()<s2.length())?s1.length():s2.length());
        while(ptr<min&&s1.charAt(ptr)==s2.charAt(ptr))ptr++;
        if(ptr==min){
            if(min==s1.length())return false;
            return true;
        }
        if(s1.charAt(ptr)<s2.charAt(ptr))return false;
        return true;
    }
    public int countduplicatewords(){
        int ctr=0;
        String arr[]=str.split(" ");
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]==null)continue;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]==null)continue;
                else if(arr[i].equalsIgnoreCase(arr[j])){
                    for(int k=j+1;k<arr.length;k++){if(arr[k].equalsIgnoreCase(arr[j]))arr[k]=null;}
                    arr[j]=null;
                    ctr++;
                }
            }
        }
        return ctr;
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
    public static void main(String args[]){
        WordSort w=new WordSort();
        w.str=input("a string : ");
        w.arrangewords(true);
        System.out.println("Swapped words : \n"+w.swapwords());
        System.out.println("Arranged : "+w.str);
        System.out.println("Duplicate words : "+w.countduplicatewords());
    }
}