import java.io.*;
public class ElementList{
 Node root;
public ElementList(){
root=null;
}
void addAtEnd(Node n){
if(n==null)return;
Node p=root;
if(p==null){root=new Node();root=n;return;}
while(p.getNext()!=null)p=p.getNext();
p.setNext(n);
System.out.println("Added to list : "+p.data.name);
dispNames();    }
    
Node getLastNode(){
if(root==null)return null;
Node p=root;
while(p.getNext()!=null)p=p.getNext();
return p;
}

      public Element search(String s){//by id
      Node p=root;
      while(p!=null){
          if(p.getData().getName().equalsIgnoreCase(s)){
             return p.getData();
    }
}
return null;
}
      public ElementList searchAll(String s){//by id
      ElementList e=new ElementList();
      Node p=root;
      while(p!=null){
          if(p.getData().getName().equalsIgnoreCase(s)){
             e.addAtEnd(p);
    }
}
return e;
}
public void delete(String name){
Node p=root;
while(p!=null){
if(p.getData().getName().equalsIgnoreCase(name)){
p.getPrevious().setNext(p.getNext());
p.getNext().setPrevious(p.getPrevious());
p=p.getNext();
}
}
      }
      public void addAtEnd(ElementList e){
    Node p=getLastNode(),q=e.root;
    while(q!=null){
        q.setPrevious(p);
        p.setNext(q);
        p=q;
        q=q.getNext();
}
    }
    public void dispNames(){
    Node p=root;
    if(p==null)return;    
    while(p!=null){
        Element e=p.getData();
            
            Writer.sopln(e.getName());
            p=p.getNext();
        }
}
public  int getNumberOfNodes(){
Node p=root;
if(root==null)return 0;
int ctr=0;
while(p!=null){ctr++;p=p.getNext();}
return ctr;}

    }