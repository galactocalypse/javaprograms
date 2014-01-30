import java.io.*;
public class Reader{
    public Element getElement(String s[], char t){
        if(s==null)return null;
        switch(t){
            case 'a':
            return new Article(getInt(s[0]),s[1],s[2].split(","),s[3].split("\n"));
            case 'u':return new User(getInt(s[0]),s[1],s[2],s[3]);
            default:return null;
        }
    }
    public Article getByAID(int id){
        return (Article)getElement(readArr(new File(MainFiles.articles,id+".dat")),'a');
    }
    public boolean articleExists(String s){
        AList u=getArticles();
        Node p=u.root;
        while(p!=null){if(p.e.name.equalsIgnoreCase(s))return true;p=p.next;
        }
        return false;
    }
    public AList getArticles(){
        String names[]=MainFiles.articles.list();
        AList a=new AList();
        for(int i=0;i<names.length;i++){
            a.add(getElement(readArr(new File(MainFiles.articles,""+names[i])),'a'));
        }
        return a;
    }
    public SList getNames(char ch){
        EList e;
        switch(ch){
            case 'a':
            e=getArticles();break;
            case 'u':
            e=getUsers();break;
            default:return null;
        }
        SList s=new SList();
        Node p=e.root;
        while(p!=null){s.add(new SElement(p.e.name));p=p.next;}
        return s;
    }
    public User getByUID(int id){
        User us=(User)getElement(readArr(new File(MainFiles.users,""+id+".dat")),'u');
        return us;
    }
    public int getInt(String s){
        try{
            return Integer.parseInt(s);
        }catch(Exception e){return 0;}
    }
    public boolean userExists(String s){
        return exists(getUsers(),s);
    }
    public UList getUsers(){
        UList u=new UList();
        String s[]=MainFiles.users.list();
        for(int i=0;i<s.length;i++)u.add(getElement(readArr(new File(MainFiles.users,s[i])),'u'));
        return u;
    }
    public User getByUName(String s){
        if(!userExists(s))return null;
        UList u=getUsers();
        Node p=u.root;
        while(p!=null){if(p.e.name.equalsIgnoreCase(s))return (User)p.e;p=p.next;}
        return null;
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
    public boolean exists(EList a,String s){
        Node p=a.root;
        while(p!=null){
            if(p.e.name.equalsIgnoreCase(s))return true;p=p.next;}
            return false;
        }
}