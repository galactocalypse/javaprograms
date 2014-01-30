public class Node{
    protected int data;
    protected Node next;
    public Node(int x,Node n){
        data=x;next=n;
    }
    public Node(){
        data=0;next=null;
    }
    public Node(int x){data=x;}
    public Node(Node n){next=n;data=0;}
    public void setNext(Node n){next=n;}
    public void setData(int x){data=x;}
    public int getData(){return data;}
    public Node getNext(){return next;}
}