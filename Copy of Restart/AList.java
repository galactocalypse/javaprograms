public class AList{
Node root;
public void add(Article a){
Node n=new Node(a);
if(root==null)root=n;
else{
Node p=root;
while(p.next!=null)p=p.next;
p.next=n;
}
}
public void dispNames(){
if(root==null)return;
Node p=root;
while(p!=null){System.out.println(p.data.name);
p=p.next;    }}

public AList search(String s){
AList a=new AList();
Node p=root;
while(p!=null){
if(p.data.lookUp(s)){a.add(p.data);
}p=p.next;}
return a;
}

}