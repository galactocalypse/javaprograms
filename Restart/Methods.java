import java.io.*;
public class Methods{
    Reader r;
    MainFiles mf;
    Writer w;
    Stats st;
    public Methods(){
        mf=new MainFiles();
        r=new Reader();
        w=new Writer();
        st=new Stats();
    }
    public void createNewUser(){
        String name,pwd,loc;
        SList u=r.getNames('u');
        do{
            name=accept("desired username(or '*' to cancel creating new account)","Invalid entry!");
            if(name.equals("*"))return;
            if(r.exists(u,name))System.out.println("User already exists!");
        }while(r.exists(u,name));
        do{
            pwd=r.input("password(or '*' to cancel creating new account)");
            if(pwd.equals("*"))return;
        }while(pwd.length()<5);
        do{
            loc=accept("location","invalid entry");
        }while(loc.length()<2);
        User n=new User(st.getLastUID()+1,name,pwd,loc);
        st.users.add(n);
        st.incrementUID(); 
        w.write(new File(MainFiles.users,st.getLastUID()+".dat"),n.getInfo());
        System.out.println("New User added : "+name);
    }
    public String accept(String s1,String s2){
        String n=null;
        do{n=r.input(s1);if(n==null)System.out.println(s2);}while(n==null);
        return n;
    }
    public void createNewArticle(){
        String name;
        String key[],d[];
        name=accept("name","Invalid entry!");
        SList anames=r.getNames('a');
        if(r.exists(anames,name)){System.out.println("This article already exists! If you want to edit it, please do so in the edit mode.");return;}
        key=trimAll((r.input("keywords separated by commas")+" , "+name).split(","));
        d=r.input("description(separate lines by tabs, press enter to stop)").split("\t");
        st.incrementAID();
        Article a=new Article(st.getLastAID(),name,key,d);
        w.write(new File(MainFiles.articles,st.getLastAID()+".dat"),a.getInfo());
        st.articles.add(a);
        System.out.println("Article added.");
    }
    public String[] trimAll(String s[]){
        for(int i=0;i<s.length;i++)s[i]=s[i].trim();
        return s;
    }
    public void login(){
        String name=r.input("name");
        if(!r.userExists(name)){System.out.println("User does not exist.");
            return;
        }
        String pwd;
        User u=r.getByUName(name);
        int ctr=0;
        do{
            pwd=r.input("password(or '*'to abort login)");
            ctr++;
            if(pwd.equals(u.pwd)){  
                st.setLogged(u.id);
                System.out.println("User logged in.");
                return;
            }
            else if(pwd.equals("*")){System.out.println("Login aborted."); return;}
            else System.out.println("Incorrect password!");   
        }
        while(st.isLogged==false&&ctr<3);
        if(!st.isLogged)System.out.println("Three failed attempts. Please try later.");
    }
    public void logout(){
        st.endSession();
    }
    public void search(){
        AList a=st.articles.search(r.input("search term(separate multiple terms with commas)").split(","));
        if(a==null||a.root==null){System.out.println("no results for searched term.");return;}
        a.dispNamesWithNumbers();
        Article art=(Article)a.getElement(r.getInt(r.input("article number")));
        art.display();
        st.current=art;
    }
    public void edit(){
        Article a=st.current;
        if(a==null)return;
        String name=r.input("name(or enter '*' to retain old name)");
        if(name.equals("*"))name=a.name;
        String key[]=r.input("keywords separated by commas(or enter '*' to retain old list)").split(",");
        if(key==null)key=a.keywords;
        else if(key[0].equals("*"))key=a.keywords;
        String d[]=r.input("description, separate different lines using <tab> (or enter '*' to retain old description)").split("\t");
        if(d==null)d=a.d;
        else if(d[0].equals("*"))d=a.d;
        a=new Article(a.id,name,key,d);
        w.write(new File(MainFiles.articles,a.id+".dat"),a.getInfo());
    }
    public void deleteArticle(){
        try{
            File f=new File(MainFiles.articles,st.current.id+".dat");
            System.out.println("id :"+st.current.id+"\nFile:"+f.getName());
            st.articles.remove(st.current.name);
            f.delete();
        }catch(Exception e){return;}
    }
    public void deleteUser(){
        try{
            int ctr=0;
            do{
                String pwd=r.input("password(or '*'to cancel deletion)");
                ctr++;
                if(pwd.equals(st.loggedUser.pwd)){  
                    File f=new File(MainFiles.users,st.loggedUser.id+".dat");
                    st.users.remove(st.loggedUser.name);
                    logout();
                    f.delete();
                    System.out.println("Account deleted!");

                    return;
                }
                else if(pwd.equals("*")){System.out.println("Deletion canceled."); return;}
                else System.out.println("Incorrect password! Try again.");   
            }while(ctr<3);    
            System.out.println("Three failed attempts. Please try later.");
        }
        catch(Exception e){return;}
    }
    public void updateAll(){
        r=new Reader();
        w=new Writer();
        st=new Stats();
    }
}