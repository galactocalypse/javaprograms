public class SList {
Node root;
public void add(SElement a){
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
while(p!=null){System.out.println(p.s);
p=p.next;    }}

public SList search(String s){
SList a=new SList();
Node p=root;
while(p!=null){
if(p.s.val.equalsIgnoreCase(s)){a.add(p.s);
}p=p.next;}
return a;
}
public int getLength(){
Node p=root;
int ctr=0;
while(p!=null){ctr++;p=p.next;}
return ctr;}
}