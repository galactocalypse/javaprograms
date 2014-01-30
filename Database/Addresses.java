import java.io.*;
public final class Addresses{
public static final int useridstart=1000;
public static final File root=new File("c:\\Encyclopedia\\");
public static final File useraccounts=new File("c:\\Encyclopedia\\Users\\");
public static final File dictionary=new File("c:\\Encyclopedia\\Dictionary\\");
public static final File articles=new File("c:\\Encyclopedia\\Articles\\");
public static final File resources=new File("c:\\Encyclopedia\\Resources\\");
public static final File stats=new File("c:\\Encyclopedia\\","stats.dat");
public static final File getUserAccount(User u){
return new File(useraccounts,""+u.id+".dat");
}
public static final File getArticle(Article a){
return new File(articles,""+a.id+".dat");
}
public static final File[] getMainDirectoryList(){
File f[]=new File[5];
f[0]=root;
f[1]=useraccounts;
f[2]=dictionary;
f[3]=articles;
f[4]=resources;
return f;
}
public static final File[] getMainFileList(){
File f[]=new File[1];
f[0]=stats;
return f;
}
}