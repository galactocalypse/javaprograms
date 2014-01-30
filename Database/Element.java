import java.io.*;
public class Element{
static int id;
static String name;
public Element(int id,String name){
this.id=id;
this.name=name;
}
public Element(){id=0;name=null;}
public Element(int i){id=i;name=null;}
public String getName(){return name;}
public int getId(){return id;}
String[] getString(){return null;}
}