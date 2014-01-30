public class NumberToWords{
static final String[] ones={"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
static final String[] tens={"Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
static final String[] vens={"Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
public static String getForTwo(int x){
//2 digit nos
if(x<10)return ones[x];
else if(x>10&&x<20)return vens[x-11];
else return tens[(x/10)-1]+" "+ones[x%10];
}
public static String get(int x,String str){
if(str.length()==0&&x==0)return "Zero";
if(x>=1000000000)return get(x%1000000000,str+" "+getForTwo(x/1000000000)+" Arab ");
if(x>=10000000)return get(x%10000000,str+" "+getForTwo(x/10000000)+" Crore ");
else if(x>=100000)return get(x%100000,str+" "+getForTwo(x/100000)+" Lakh ");
else if(x>=1000)return get(x%1000,str+" "+getForTwo(x/1000)+" Thousand ");
else if(x>=100)return get(x%100,str+" "+getForTwo(x/100)+" Hundred ");
else if(x>0)return str+getForTwo(x);
return str;
}
public static void main(){
System.out.println("0 : "+get(0,""));
}
}