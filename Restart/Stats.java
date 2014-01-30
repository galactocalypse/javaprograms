import java.io.*;
public class Stats{
    String st[];
    User loggedUser;
    Article current;
    UList users;
    boolean isLogged;
    AList articles;
    SList usernames,articlenames;
    public Stats(){
        getStats();
    }
    public void getStats(){
        Reader r=new Reader();
        st=r.readArr(MainFiles.stats);
        users=r.getUsers();
        articles=r.getArticles();
        usernames=r.getNames('u');
        articlenames=r.getNames('a');
        isLogged=!st[st.length-1].equalsIgnoreCase("*");
        current=getCurrentArticle();
        loggedUser=getLoggedUser();
    }
    public int getCurrentAID(){
        return current.id;
    }
    public Article getCurrentArticle(){
        Reader r=new Reader();
        return r.getByAID(r.getInt(st[st.length-2]));
    }
    public void setLogged(int id){
        Reader r=new Reader();
        loggedUser=r.getByUID(id);
        st[st.length-1]=""+loggedUser.id;
        isLogged=true;
        Writer w=new Writer();
        w.write(MainFiles.stats,st);
    }
    public void endSession(){
        loggedUser=null;
        isLogged=false;
        st[st.length-1]="*";
        Writer w=new Writer();
        w.write(MainFiles.stats,st);
    }       
    public int getLoggedUID(){
        Reader r=new Reader();
        if(st!=null)return r.getInt(st[st.length-1]);
        return 0;
    }
    public User getLoggedUser(){
        Reader r=new Reader();
        return r.getByUID(getLoggedUID());
    }   
    public int getInt(String s){
        try{
            return Integer.parseInt(s);
        }
        catch(Exception e){}
        return 0;
    }
    public int getLastAID(){return getInt(st[1]);}
    public int getLastUID(){return getInt(st[0]);}
    public void incrementUID(){
        try{
            st[0]=""+(Integer.parseInt(st[0])+1);
            Writer w=new Writer();
            w.write(MainFiles.stats,st);
        }
        catch(Exception e){}
    }
   public void incrementAID(){
       try{
           st[1]=""+(Integer.parseInt(st[1])+1);
           Writer w=new Writer();
           w.write(MainFiles.stats,st);
        }
        catch(Exception e){}
    }
    public String getString(String arr[]){
        String s="";
        for(int i=0;i<arr.length;i++)s=s+" "+arr[i];
        return s;
    }
       
}