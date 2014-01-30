public class AList extends EList{
public AList search(String s[]){
    AList a=new AList();
    Node p=root;
    if(p==null){return null;}
    while(p!=null){
        if(((Article)p.e).lookUp(s)){a.add((Article)p.e);
        }p=p.next;}
        return a;
    }
}