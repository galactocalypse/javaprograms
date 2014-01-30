import java.util.*;
class Expression {
String expression;
Term te[];
Expression(){}

String[] getParts(String s){
return s.split(" ");
}

Term convert(String s){
Term term=new Term(1,1);
if(s.charAt(0)=='-')term.neg=true;
String s1="";
for(int i=1;i<s.length();i++){
s1+=s.charAt(i);
}
s=s1;
switch(s.length()){
case 1://x  ||  1
try{
int x=Integer.parseInt(s);
if(term.neg)
term.setNum(-x);
else term.setNum(x);
term.setPow(0);
}
catch(Exception e){
if(term.neg)
term.setNum(-1);
else term.setNum(1);
term.setPow(1);
}
break;
case 2://2x   || x2
try{//2X
int x=Integer.parseInt(""+s.charAt(0));
if(term.neg)
term.setNum(-x);
else term.setNum(x);
term.setPow(1);
}
catch(Exception e){//x2
if(term.neg)
term.setNum(-1);
else term.setNum(1);
term.setPow(Integer.parseInt(""+s.charAt(1)));
}
break;
case 3://  2x3
int x=Integer.parseInt(""+s.charAt(0));
if(term.neg)
term.setNum(-x);
else term.setNum(x);
term.setPow(Integer.parseInt(""+s.charAt(2)));
break;
}
return term;
}

Term[] getTerms(String s[]){
Term terms[]=new Term[s.length];
for(int i=0;i<s.length;i++){
terms[i]=convert(s[i]);
}
return terms;
}


void display(){
Term t[]=getTerms(getParts("+2x2 +5x +8"));
for(int i=0;i<t.length;i++){
System.out.println(t[i].getNum()+"x"+t[i].getPow());
}
}

}