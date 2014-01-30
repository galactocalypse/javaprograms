import java.io.*;
class Testing{
public static void main(String args[]){
Buffer b=new Buffer();
Login l=new Login(b);
User user=new User(10,"Adarsh","dilemma","ada","a","Dff","gfs",5);
UserList u=new UserList();
u.addAtEnd(new Node(user));
User u2=new User(101,"YaGNIK","dilemma","ada","a","Dff","gfs",5);
u.addAtEnd(new Node(u2));
u.dispNames();

    }
    
}