public class Main{
static Buffer b;
static Login l;
public static void main(String args[]){
b=new Buffer();
l=new Login(b);
do{
    if(!l.isLoggedIn){
        switch(loginmenu()){
            case 1:
            l.login();
            continue;
            
            case 2:
            b.users.addAtEnd(new Node(l.createNewAccount()));
            b.users.dispNames();
            b.refresh();
            break;
            default:
            System.exit(0);
        }
    }
    else {
        switch(choicemenu()){
            case 1:
            openEncyclopedia();
            break;
            
            case 2:
            openDictionary();
            break; 
            
            case 4:
            System.exit(0);
        }
    }
}
    while(cont());

    
    }
        static void openEncyclopedia(){
            do{
                switch(encmenu()){
                    case 1 : 
                    Element e=b.articles.search(b.r.input("Enter search term : "));
                    if(e==null)System.out.println("No article found. Recheck the spelling and try again or try another term.");
                    else artmenu((Article)e);
                    break;
                    
                    case 2:
                    return;
                    
                    case 3 :
                    System.exit(0);
                }    
            }while(enccont());
        }
        
public static void artmenu(Article a){
System.out.println(a.disp());
do{
switch(artmenu()){
case 1:
break;
case 2:
break;
case 3:
return;
case 4:
System.exit(0);
    }
}
while(artcont());
}
    static void openDictionary(){
    
}
static int artmenu(){
return b.r.inputInt("Enter choice : 1. Modify\t2. Delete\t3. Previous Menu\t4. Exit");
}
static int loginmenu(){
return b.r.inputInt("Enter choice : 1. Login\t2. Create New Account\tPress any other key to exit.");
}
static int mainmenu(){
return b.r.inputInt("Enter choice : 1. Search\t2. Add\t3. View Profile\t4. Logout");
}
static int choicemenu(){
return b.r.inputInt("Enter choice : 1. Encyclopedia\t2. Dictionary\t3. Previous Menu\t 4. Exit");
}
static boolean cont(){
char ch=b.r.inputChar("Enter 'y' to continue..");
return ch=='y'||ch=='Y';
}
static boolean enccont(){
char ch=b.r.inputChar("Enter 'y' to continue in encyclopedia..");
return ch=='y'||ch=='Y';
}
static boolean diccont(){
char ch=b.r.inputChar("Enter 'y' to continue in dictionary..");
return ch=='y'||ch=='Y';
}
static int encmenu(){
return b.r.menu("1. Search\t2. Previous Menu\t 4. Exit");
}
static boolean artcont(){
char ch=b.r.inputChar("Enter 'y' to continue viewing the article : ");
return ch=='y'||ch=='Y';
}
}