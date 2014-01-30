public class EList{
Node root;
    public EList(){root=null;}
    public void add(Element e){
        if(root==null)root=new Node(e);
        else {
            Node p=root;
            while(p.next!=null)p=p.next;
            p.next=new Node(e);
        }
    }
    public void dispNames(){
        if(root==null)return;
        Node p=root;
        while(p!=null){System.out.println(p.e.name);
            p=p.next;    
        }
    }
    public void dispNamesWithNumbers(){
        if(root==null){System.out.println("no root");return;}
        int ctr=1;
        Node p=root;
        while(p!=null){System.out.println(""+ctr+". "+p.e.name);
            p=p.next;    ctr++;
        }
    }
    public EList searchEle(String s){
        EList a=new EList();
        Node p=root;
        while(p!=null){
            if(p.e.name.equalsIgnoreCase(s)){a.add(p.e);
            }p=p.next;}
            return a;
        }
        public void remove(String s){
            Node p=root,q=null;
            if(p==null)return;
            while(p!=null){
                if(p.e.name.trim().equalsIgnoreCase(s.trim())){if(q!=null)q.next=p.next;else root=p.next;}
                q=p;
                p=p.next;
            }
        }
        public int getLength(){
            Node p=root;
            int ctr=0;
            while(p!=null){ctr++;p=p.next;}
            return ctr;
        }
        public Element getElement(int n){
            if(n>getLength())return null;
            int ctr=1;
            Node p=root;
            while(p!=null){
            if(ctr==n)return p.e;
            ctr++;
        }
        return null;
    }
}