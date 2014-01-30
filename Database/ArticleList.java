public class ArticleList extends ElementList{
public ArticleList(){
    super();    
    }
    public ElementList searchAll(String s){//by id
      ElementList e=new ElementList();
      Node p=root;
      while(p!=null){
          if(Reader.has(((Article)p.getData()).keywords,s)){
             e.addAtEnd(p);
    }
}
return e;
}
}