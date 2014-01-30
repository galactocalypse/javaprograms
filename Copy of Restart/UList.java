public class UList{
Node root;
public void add(User a){
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
while(p!=null){System.out.println(p.d.name);
p=p.next;    }}

public UList search(String s){
UList a=new UList();
Node p=root;
while(p!=null){
if(p.d.name.equalsIgnoreCase(s)){a.add(p.d);
}p=p.next;}
return a;
}
public int getLength(){
Node p=root;
int ctr=0;
while(p!=null){ctr++;p=p.next;}
return ctr;}
}