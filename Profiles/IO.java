public class IO{
public User inputUser(){
Reader r=new Reader();
User u=new User();
u.name=r.input("name");
u.dob=r.input("date of birth");
u.a=new Address(r.input("address"));
Contact c=new Contact(r.input("phone number"));
Email e=new Email(r.input("email id"));
u.contacts.addAtEnd(c);
return u;
}
public boolean saveUser(User u){

return false;
}
}