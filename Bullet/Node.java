public class Node{
Node next;
int val;
public Node(int val, Node n){
this.val=val;
next=n;
}
void setlink(Node n){
next=n;
}
Node getlink(){return next;}
void setVal(int x){
val=x;
}
int getdata(){
return val;
}
}