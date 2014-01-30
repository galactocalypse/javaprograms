public class Traversal{
public String getPost(String s){
String p="";
LinkedList l=new LinkedList();
l.push("(");
s=s+")";
for(int i=0;i<s.length();i++){
char ch=s.charAt(i); 
if(isOperand(ch))p=p+ch;
else if(ch=='(')l.push("(");
else if(isOperator(ch)){
do{
p=p+l.pop();
}
while(preceeds(ch,l.getLastElement().charAt(0)));
l.push(""+ch);
}
else if(ch==')'){
while(l.getLastElement()!="("){
p=p+l.pop();
}
l.pop();
}
}
return p;
}
public boolean isOperand(char ch){return false;}
public boolean isOperator(char ch){return false;}
public boolean preceeds(char c1,char c2){return false;}
}