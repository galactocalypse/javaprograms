public class AutoComplete{
List l;
public AutoComplete(List l){
this.l=l;
}
public List check(String s){
return l.searchAll(s);
}
}