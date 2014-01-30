import java.io.*;
public class Buffer{
ElementList users,articles,resources,words;
final Reader r;
final Writer w;
final Addresses a;
final Stats st;
public Buffer(){
users=new UserList();
articles=new ArticleList();
resources=new ResourceList();
words=new WordList();
r=new Reader();
w=new Writer();
a=new Addresses();
st=new Stats();
load();
}

public void load(){
checkMainDirectories();
checkMainFiles();
users=r.getUsers();
users.dispNames();
articles=r.getElementList('a');
}
public void refresh(){
store();
load();
}
public void store(){
//w.writeElements(r.getElementList('r'));
//w.writeElements(r.getElementList('w'));
//w.writeElements(r.getElementList('a'));
w.createFiles(r.getUsers().getFiles());
ElementList e=r.getElementList('u');
if(e==null){System.out.println("Empty elemnt list.");return;}
w.writeElements(e);

}
public void checkMainDirectories(){
w.createDirectories(a.getMainDirectoryList());
}
public void checkMainFiles(){
w.createFiles(a.getMainFileList());
}
}