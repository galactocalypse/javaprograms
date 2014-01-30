import java.io.*;
public class Student{
    String name;
    int age,eng,mat,sci;
public Student(String n,int a,int e,int m,int s){
    name=n;
    age=a;
    eng=e;
    mat=m;
    sci=s;
}
public Student(){
    name=null;
    age=mat=eng=sci=0;
}
public void accept(){
    name=input("name");
    age=(int)inputNum("age");
    eng=(int)inputNum("marks in English");
    mat=(int)inputNum("marks in Maths");
    sci=(int)inputNum("marks in Science");
}
public String input(String s){
    DataInputStream in=new DataInputStream(System.in);
    try{
        System.out.println("Enter "+s+":");
        return in.readLine();
    }
    catch(Exception e){return null;}
}
public double inputNum(String s){
    try{return Double.parseDouble(input(s));
    }catch(Exception e){
        return 0;
    }
}
public void disp(Student s){
    if(s==null){System.out.println("record empty.");return;}
    System.out.println("Name:"+s.name+"\nAge:"+s.age+"\nEnglish:"+s.eng+"\nMaths:"+s.mat+"\nScience:"+s.sci);
}
public void displayAllRecords(File f){
    try{
        BufferedReader br=new BufferedReader(new FileReader(f));
        String s=null;
        while((s=br.readLine())!=null){
            String arr[]=s.split("\t");
            try{
                disp(new Student(arr[0],Integer.parseInt(arr[1]),Integer.parseInt(arr[2]),Integer.parseInt(arr[3]),Integer.parseInt(arr[4])));
            }
            catch(Exception ee){}
        }
    }
    catch(Exception e){}
}
public void writeToFile(Student s,File f,boolean b){
    try{
        PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter(f,b)));
        pw.println(s.name+"\t"+s.age+"\t"+s.eng+"\t"+s.mat+"\t"+s.sci);
        pw.close();
    }catch(Exception e2){}
}
public void writeToFile(Student s[],File f,boolean b){
    for(int i=0;i<s.length;i++)
        writeToFile(s[i],f,b);
}
public Student modify(String n,File f){
    try{
        int x=0;
        BufferedReader br=new BufferedReader(new FileReader(f));
        String s=null;
        int error=0;
        while((s=br.readLine())!=null)++x;
        br.close();
        br=new BufferedReader(new FileReader(f));
        Student st[]=new Student[x];
        x=0;
        while((s=br.readLine())!=null){
            String arr[]=s.split("\t");
            st[x]=new Student(arr[0],Integer.parseInt(arr[1]),Integer.parseInt(arr[2]),Integer.parseInt(arr[3]),Integer.parseInt(arr[4]));
            if(st[x].name.equalsIgnoreCase(n))error=x;
        }
        br.close();
        System.out.println("enter new info:");
        accept();
        st[error]=this;
        writeToFile(st,f,false);
    }catch(Exception e){}return null;
}
public void search(String n,File f){
    try{
        BufferedReader br=new BufferedReader(new FileReader(f));
        String s=null;
        boolean found=false;
        while((s=br.readLine())!=null){
            if(s.toUpperCase().startsWith(n.toUpperCase())){
                String arr[]=s.split("\t");
                disp(new Student(arr[0],Integer.parseInt(arr[1]),Integer.parseInt(arr[2]),Integer.parseInt(arr[3]),Integer.parseInt(arr[4])));found=true;}
            }   
            if(!found)System.out.println("record not found!");
        }   
        catch(Exception e){}
}
public int menu(){
    System.out.println("1.Insert\n2.Search\n3.Modify\n4.Display\n5.Exit");
    return (int)inputNum("choice");
}
public boolean cont(){
    return (inputNum("1 to continue...")==1);
}
public static void main(String args[]){
    Student s=new Student();
    File f=new File("stud.dat");
    do{
        switch(s.menu()){
            case 1:
            s.accept();
            s.writeToFile(s,f,true);
            break;
            case 2:
            s.search(s.input("name to search"),f);
            break;
            case 3:
            s.modify(s.input("name"),f);
            break;
            case 4:
            s.displayAllRecords(f);
            break;
            default:
            System.exit(0);
        }
    }while(s.cont());
}
}