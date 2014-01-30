public class List{
Node root;
public List(){root=null;}
public void add(Value v){
if(root==null){root=new Node(v);return;
}
Node p=root;
while(p.getNext()!=null)p=p.getNext();
p.setNext(new Node(v));
}
public void delete(Value v){
Node p=root;
while(p!=null&!p.getValue().equals(v))p=p.getNext();
p.getPrevious().setNext(p.getNext());
p.getNext().setPrevious(p.getPrevious());
}
public List searchAll(String s){
List l=new List();
Node p=root;
while(p!=null){
if(beginsWith(p.getValue().getString(),s))l.add(p.getValue());
p=p.getNext();}
return l;
}
public boolean beginsWith(String str,String s){
s=s.toUpperCase();
str=str.toUpperCase();
int ctr=0;
while(ctr<(s.length()<str.length()?s.length():str.length())){
if(s.charAt(ctr)==str.charAt(ctr))ctr++;
else break;
}
if(ctr==(s.length()<str.length()?s.length():str.length()))return true;
return false;}
}