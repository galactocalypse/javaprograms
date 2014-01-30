public final class Stats{
public static String st[];
public Stats(){
st=null;
update();
display();
}
public void display(){
Writer.sopln(Reader.getString(st));
}
public static final void update(){String s[]=Reader.read(Addresses.stats);

st=s;}
public static final int getLastUserID(){return Reader.getInt(st[0]);}
public static final int getNoOfUsers(){return Reader.getInt(st[1]);}
public static final int getLastArticleID(){return Reader.getInt(st[2]);}
public static final int getNoOfArticles(){return Reader.getInt(st[3]);}
public static final String getLastLoggedInTime(){return st[4];}
}