
public class User extends Element{
    int id;
    String pwd;
    String location;
    public User(int i,String n,String p,String loc){
        super(n);
        id=i;
        pwd=p;
        location=loc;
    }
    public void dispUInfo(){
        System.out.println("Name: "+name);
        System.out.println("Location: "+location);
    }
    public String[] getInfo(){
        String s[]=new String[4];
        s[0]=""+id;
        s[1]=name;
        s[2]=pwd;
        s[3]=location;
        return s;
    }
}