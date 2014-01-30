import java.awt.Color;
class gety{
Color c[]={Color.white,Color.yellow,Color.pink,Color.cyan,Color.gray,Color.magenta,Color.orange,Color.black};
String str[]={"white","yellow","pink","cyan","gray","magenta","orange","black"};
void main(){
for(int i=0;i<c.length;i++){
System.out.println(""+str[i]+"\tRED\t"+c[i].getRed());
System.out.println(""+str[i]+"\tGREEN\t"+c[i].getGreen());
System.out.println(""+str[i]+"\tBLUE\t"+c[i].getBlue());
}
}
public static void main(String args[]){
gety o=new gety();
o.main();

}}