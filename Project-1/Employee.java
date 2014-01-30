import java.io.*;
public class Employee{
    String name;
    int age;
    double salary;
    public Employee(String n,int a,double s){
        name=n;
        age=a;
        salary=s;
    }
    public Employee(){
        name=null;
        age=0;
        salary=0.0;
    }
    public void accept(){
        name=input("name");
        age=(int)inputNum("age");
        salary=inputNum("salary");
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
    public void disp(Employee e){
        if(name==null){System.out.println("record empty.");return;}
        System.out.println("Name:"+e.name+"\nAge:"+e.age+"\nSalary:"+e.salary);
    }
    public void displayAllRecords(File f){
        try{
            BufferedReader br=new BufferedReader(new FileReader(f));
            String s=null;
            while((s=br.readLine())!=null){
                String arr[]=s.split("\t");
                try{disp(new Employee(arr[0],Integer.parseInt(arr[1]),Double.parseDouble(arr[2])));
                }
                catch(Exception ee){}
            }
        }
        catch(Exception e){}
    }   
    public void writeToFile(Employee e,File f){
        try{PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter(f,true)));
            pw.println(e.name+"\t"+e.age+"\t"+e.salary);
            pw.close();
        }catch(Exception e2){}
    }
    public void search(String n,File f){
        try{
            BufferedReader br=new BufferedReader(new FileReader(f));
            String s=null;
            while((s=br.readLine())!=null){
                if(s.toUpperCase().startsWith(n.toUpperCase())){
                    String res[]=s.split("\t");
                    System.out.println("Record found!\nName:"+res[0]+"\nAge:"+res[1]+"\nSalary:"+res[2]);
                    return;}
                }
            }
            catch(Exception e){System.out.println("Record not found!");
            }
    }
    public boolean cont(){
        return input("'y' to continue").equalsIgnoreCase("y");
    }
    public int menu(){
        return (int)inputNum("choice:\n1. Add a record\n2. Display All Records\n3. Search all records on the basis of name\n4. Exit");
    }
    public static void main(String args[]){
        Employee e=new Employee();
        File f=new File("EMP.DAT");
        do{
            switch(e.menu()){
                case 1:e.accept();e.writeToFile(e,f);break;
                case 2:e.displayAllRecords(f);break;
                case 3:e.search(e.input("search term"),f);break;
                case 4:System.exit(0);
                default:System.out.println("Invalid choice.");
            }
        }while(e.cont());
    }
}