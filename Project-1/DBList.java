public class DBList{    
    Node start;
    DBList(){
        start=null;
    }
    public void insert_beg(int x){
        Node nd=new Node(x,start);
        start=nd;
    }
    void dele_beg(){
        start=start.getNext();
    }
    void dele_end(){
        if(start==null)return;
        Node p=start,q=null;
        while(p.getNext()!=null){q=p;
            p=p.getNext();
        }
        q.setNext(null);
    }
    void disp_list(){
        Node p=start;
        while(p!=null){System.out.println(p.getData());p=p.getNext();}
    }
}