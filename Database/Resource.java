public class Resource extends Element{
String address;
String dateadded,contributor,type;
public Resource(int id,String n){
super(id,n);
dateadded=contributor=type=null;
}
String[] getString(){return null;}

}