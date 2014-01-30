import java.io.*;
class CharCount{
String str,s;
DataInputStream in=new DataInputStream(System.in);
int i,j,ctr;
char ch;
CharCount(){
    s="";
    i=j=ctr=0;
    ch=0;
}
    void accept(){
        System.out.println("Enter a string :");
        try{
            str=s=in.readLine();
        }
        catch(Exception e){
            System.out.println("Error!");
            System.exit(0);
        }
    }
    void count(){
        String t;
        s=s.toUpperCase();
        for(i=0;i<s.length();i++){
            ch=s.charAt(i);
            ctr=0;
            for(j=0;j<s.length();j++){
                if(ch==s.charAt(j)){
                    ctr++;
                }
            }
            if(ch==' ')
                t="<space>";
                    else t=""+ch;
            System.out.print(t+" appears "+ctr+" time");
            if(ctr==1)
                System.out.println(".");
                    else System.out.println("s.");
            rem(ch);
            i--;
        }
    }
    void rem(char c){
        String ns="";
        for(j=0;j<s.length();j++){
            if(ch!=s.charAt(j)){
                ns=ns+s.charAt(j);
            }
        }
        s=ns;
    }
    public static void main(){
        CharCount cc = new CharCount();
        Name n=new Name();
        cc.accept();
        cc.count();
        n.display(cc.str);
    }
}