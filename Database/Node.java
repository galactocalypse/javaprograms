public class Node{
 Element data;
 Node next,previous;
public Node(){data=null;
next=previous=null;}

public Node(Element e){
data=e;
next=previous=null;
}
public Node(Node n,Node p,Element e){
data=e;
next=n;
previous=p;
}
public Node(Node n,Element e){
data=e;
next=n;
previous=null;
}

Node getNext(){return next;}
Node getPrevious(){return previous;}
void setNext(Node n){next=n;}
void setPrevious(Node n){previous=n;}
Element getData(){return data;}
void setData(Element e){data=e;}}