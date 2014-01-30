public class EList{
Node root;
public void addAtEnd(Element e){
Node nd=new Node(e);
Node p=root;
if(p==null)root=nd;
else{
while(p.next!=null)p=p.next;
p.next=nd;
}
}
}