import java.io.*;
public class ListUser{
    public static void main(String args[]){
        DBList d=new DBList();
        do{
            switch(menu()){
                case 1:d.insert_beg(input("value to  insert : "));break;
                case 2:d.dele_beg();break;
                case 3:d.dele_end();break;  
                case 4:d.disp_list();break;
                case 5:System.exit(0);
                default:System.out.println("invalid input");
            }
        }
        while(cont());
    }
    public static boolean cont(){
        return input("1 to continue : ")==1;
    }       
    public static int menu(){
        return input("choice:\n1. Insert at beginning\n2. Delete from beginning\n3. Delete from end\n4. Display list\n5. Exit");
    }
    public static int input(String s){  
        DataInputStream in=new DataInputStream(System.in);
        System.out.println("enter "+s); 
        try{
            return Integer.parseInt(in.readLine());
        }
        catch(Exception e){
            return 0;
        }
    }
}