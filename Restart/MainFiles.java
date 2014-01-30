import java.io.*;
public class MainFiles{
    public static final File root=new File("C:\\Encyclopedia");
    public static final File articles=new File(root,"articles");
    public static final File users=new File(root,"users");
    public static final File stats=new File(root,"stats.dat");
    public MainFiles(){
        checkFiles();
        createStats();
    }
    public void checkFiles(){
        try{
            if(!root.exists())root.mkdir();
            if(!articles.exists())articles.mkdir();
            if(!users.exists())users.mkdir();
            if(!stats.exists())root.createNewFile();
        }
        catch(Exception e){}
    }
    public void createStats(){
        int x[]=getInt(removeExt(users.list()));
        int uid=0;
        if(x==null||x.length==0)uid=1000;
            else {for(int i=0;i<x.length;i++){
                if(x[i]>uid)uid=x[i];
            }
        }
        x=getInt(removeExt(articles.list()));
        int aid=0;
        if(x==null||x.length==0)aid=1000;
        else{for(int i=0;i<x.length;i++){
             if(x[i]>aid)aid=x[i];}
            }
         String s=""+uid+","+aid+",*,*";
         Writer w=new Writer();
         w.write(stats,s.split(","));
    }
    public int[] getInt(String arr[]){
        int x[]=new int[arr.length];
        for(int i=0;i<x.length;i++){
        try{x[i]=Integer.parseInt(arr[i]);
            }catch(Exception e){}
        }
        return x;
    }
    public String[] removeExt(String s[]){
        for(int i=0;i<s.length;i++){
            int ch=s[i].length()-1;
            while(s[i].charAt(ch)!='.')ch=ch-1;
            s[i]=s[i].substring(0,ch);
        }
        return s;
    }
}