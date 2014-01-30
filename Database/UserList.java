import java.io.*;
public class UserList extends ElementList{

      public UserList(){
    super();    
    }
    public  File[] getFiles(){
Node p=root;
if(p==null)return null;
File f[]=new File[getNumberOfNodes()];
int ptr=0;if(f.length==0)return null;
while(p!=null){
f[ptr]=new File(Addresses.useraccounts,""+p.data.id+".dat");
ptr++;
p=p.getNext();
}
return f;
}
    }