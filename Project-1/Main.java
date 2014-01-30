import java.io.*;
public class Main{
public static void main(String args[]){ 
String s="1. AmicaAutomorphic\t\t2. Circular Number\n3. DBList\t\t\t4. Digital River\n5. Employee\t\t\t6. Keith Number\n7. Latin Square\t\t\t8. Lojban\n9. Magic Square\t\t\t10. Matrix\n11. MOP\t\t\t\t12. Roman Numerals\n13. Shuffle\t\t\t14. Sleep\n15. Smith Number\t\t16. Special Number\n17. String Processing\t\t18. Student\n19. Sum\t\t\t\t20. Sweets\n21. Text Reduction\t\t22. Triangle\n23. Vertical Histogram\t\t24. Well Ordered Numbers\n25. Word Sort";
AmicaAutomorphic am=new AmicaAutomorphic();
Circular c=new Circular();
ListUser lu=new ListUser();
DigitalRiver dr=new DigitalRiver();
Employee e=new Employee();
KeithNumber k=new KeithNumber();
LatinSquares ls=new LatinSquares();
Lojban l=new Lojban();
MagicSquare m=new MagicSquare();
Matrix mx=new Matrix();
MOP mop=new MOP();
Roman r=new Roman();
Shuffle sh=new Shuffle();
Sleep slp=new Sleep();
Smith sm=new Smith();
SpecialNumbers sn=new SpecialNumbers();
StringProcessing sp=new StringProcessing();
Student st=new Student();
Sum sum=new Sum();
Sweets sw=new Sweets();
TextReduction tr=new TextReduction();
Triangle t=new Triangle();
VerticalHistogram v=new VerticalHistogram();
WellOrdered wo=new WellOrdered();
WordSort ws=new WordSort();
do{
System.out.println(s);
switch(input("choice")){
case 1:am.main(null);break;
case 2:c.main(null);break;
case 3:lu.main(null);break;
case 4:dr.main(null);break;
case 5:e.main(null);break;
case 6:k.main(null);break;
case 7:ls.main(null);break;
case 8:l.main(null);break;
case 9:m.main(null);break;
case 10:mx.main(null);break;
case 11:mop.main(null);break;
case 12:r.main(null);break;
case 13:sh.main(null);break;
case 14:slp.main(null);break;
case 15:sm.main(null);break;
case 16:sn.main(null);break;
case 17:sp.main(null);break;
case 18:st.main(null);break;
case 19:sum.main(null);break;
case 20:sw.main(null);break;
case 21:tr.main(null);break;
case 22:t.main(null);break;
case 23:v.main(null);break;
case 24:wo.main(null);break;
case 25:ws.main(null);break;
default:System.out.println("Inval;id choice!");
}
}while(input("1 to continue")==1);
}
public static int input(String s){
DataInputStream in=new DataInputStream(System.in);
System.out.println("Enter "+s+" : ");
try{
return Integer.parseInt(in.readLine());
    }
    catch(Exception e){return 0;
    }
}
}