import java.io.*;
public class Reader{

    public int getInt(String s){
        try{
            return Integer.parseInt(s);
        }catch(Exception e){return 0;}
    }
    public String[] removeExt(String s[]){
        for(int i=0;i<s.length;i++)s[i]=getOnlyName(s[i]);
        return s;
    }
    public String getOnlyName(String s){
        if(s==null)return null;int i;
        for(i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='.')break;
        }
        System.out.println(s.substring(0,i));
        return s.substring(0,i);
    }
    public String read(File f){
        try{
            BufferedReader br=new BufferedReader(new FileReader(f));
            String s="",t=null;
            while((t=br.readLine())!=null){if(s=="")s=t;else s=s+"\n"+t;}
            br.close();br=null;
            return s.substring(0,s.length()-4);
        }
        catch(Exception e){}
        return null;
    }
    public String[] readArr(File f){
        if(f==null)return null;String s= read(f);
        if(s==null)return null;
        return s.split("\n");
    }
    public String input(String s){
        try{
            System.out.println("Enter "+s+" : ");
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            return br.readLine();
        }
        catch(Exception e){}
        return null;
    }
}