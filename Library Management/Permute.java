public class Permute{

public void disp(String s1,String s2){
if(s2==null)return;
if(s2.length()==1)System.out.println(s1+s2);
else
for(int i=0;i<s2.length();i++)
disp(s1+s2.charAt(i),s2.substring(0,i)+s2.substring(i+1,s2.length()));
}

public static void main(String args[]){
Permute p=new Permute();
p.disp("","cat");
}    
}