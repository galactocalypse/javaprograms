import java.util.*;
public class Member{
int id;
String name;
int borrowedbookid;
String dateborrowed;
boolean hasbook;
public Member(int id,String name){
this.id=id;
this. name=name;
}
boolean canBorrow(){
return !hasbook;
}
void borrow(int bid){
borrowedbookid=bid;
hasbook=true;
Date d=new Date();
dateborrowed=""+d.getDate()+"."+d.getMonth()+"."+d.getYear();
}
void returnbook(){
hasbook=false;
dateborrowed=null;
borrowedbookid=0;
}
}