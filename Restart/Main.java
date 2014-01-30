import java.io.*;
public class Main{
    Methods m;
    String m1,m2,m3,m4;
    public Main(){
        m=new Methods();
        m1="1. Login    2. Create New Account    3. Enter as Guest    4. Exit";
        m2="1. Logout    2. Search    3. Add    4. Delete Account    5. Exit";
        m3="1. Search    2. Previous Menu    3. Exit";
        m4="1. Edit    2. Delete    3. Return";
    }
    public int menu(String s){
        return m.r.getInt(m.r.input("choice : "+s));
    }
    public void process(){
        do{
            if(!m.st.isLogged){
                switch(menu(m1)){
                    case 1:m.login();break;
                    case 2:m.createNewUser();break;
                    case 3:
                    System.out.println("Entered as Guest");
                    int ch;
                    do{
                        ch=menu(m3);
                        switch(ch){
                            case 1:m.search();break;
                            case 3:m.logout();System.exit(0);
                            default: break;
                        }
                    }while(ch!=2);
                    break;
                    case 4:m.logout();System.exit(0);
                }
            }
            else{
                switch(menu(m2)){
                    case 1:m.logout();
                    break;
                    case 2:m.search();
                    switch(menu(m4)){
                        case 1:m.edit();System.out.println("Article saved");break;
                        case 2:m.deleteArticle();System.out.println("Article deleted");break;
                        default:break;
                    }
                    break;
                    case 3:m.createNewArticle();m.updateAll();break;
                    case 4:m.deleteUser();System.out.println("User deleted");break;
                    case 5:m.logout();System.out.println("Logged out.");System.exit(0);
                }
            }
        }while(true);  
    }
    public static void main(String args[]){
        Main m=new Main();
        m.process();
    }
}