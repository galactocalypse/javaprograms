public class Node{
protected Node prev,next;
protected Value v;
public Node(){next=prev=null;
v=null;}
public Node(Node n,Node p, Value val){
next=n;
prev=p;
v=val;
}
public Node(Value val){
next=null;
prev=null;
v=val;
}
public void setNext(Node n){}
public void setPrevious(Node n){}
public void setValue(Value v){}
public Value getValue(){return v;}
public Node getNext(){return next;}
public Node getPrevious(){return prev;}
}