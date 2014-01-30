import java.io.*;
public class Writer{
    public void write(File f,String data[]){
        try{
            data=data;
            PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter(f)));
            for(int i=0;i<data.length;i++)pw.println(data[i]);
            pw.println("eof");
            pw.close();
        }
        catch(Exception e){}
    }
    public void write(File f,String s){
        String s1[]=new String[1];
        s1[0]=s;
        write(f,s1);
    }
}