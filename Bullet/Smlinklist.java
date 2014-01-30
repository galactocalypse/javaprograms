class Smlinklist
{
protected Node root;
public Smlinklist()
{
root=null;
}
public void insert_at_beg(int value)
{
Node ndptr;

ndptr=new Node(value,null);
if(root==null)
{
root=ndptr;}
else
{
ndptr.setlink(root);
root=ndptr;
}
}
public void display()
{
Node ndptr=root;
System.out.print(root.getdata()+"--->");
while(ndptr.getlink()!=null)
{
System.out.print(ndptr.getdata()+"--->");
ndptr=ndptr.getlink();
}
}
}




