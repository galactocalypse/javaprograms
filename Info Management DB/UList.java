public class UList extends EList{
public User search(String s){
    Node p=root;
    while(p!=null){
        if(p.e.name.equalsIgnoreCase(s)){return (User)p.e;
        }p=p.next;}
        return null;
    }
}