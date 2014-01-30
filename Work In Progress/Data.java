public class Data{
String val;
public void setVal(String s){
val=s;
}
String getVal(){return val;}
double getNumVal(){
try{
return Double.parseDouble(val);}
catch(Exception e){System.err.println("Invalid argument! Cannot return double type.!");
return 0;}
}
}