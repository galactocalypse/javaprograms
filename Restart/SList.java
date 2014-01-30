public class SList extends EList{
public SList searchSElement(String s){
    SList a=new SList();
    Node p=root;
    while(p!=null){
        if(p.e.name.equalsIgnoreCase(s)){a.add(p.e);
        }p=p.next;}
        return a;
    }
}