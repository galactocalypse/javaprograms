public class Article extends Element{
    String d[];
    int id;
    String keywords[];
    public Article(int id,String n,String k[],String s[]){
        this.id=id;name=n;
        keywords=k;
        d=s;
    }
    Article(){d=null;}
    public void disp(){
        System.out.println(name);
        for(int i=0;i<d.length;i++){
            System.out.println(d[i]);
        }
    }
    boolean lookUp(String s){
        for(int i=0;i<keywords.length;i++){
            if(keywords[i].trim().equalsIgnoreCase(s.trim()))return true;
        }
        return false;
    }
    int getMatchingTerms(String s[]){
        int ctr=0;
        for(int i=0;i<s.length;i++){
            if(contains(keywords[i].trim().toLowerCase(),s[i].trim().toLowerCase()))ctr++;
        }
        return ctr;
    }
    public boolean contains(String s1,String s2){
        if(s1==null||s2==null)return false;
        for(int i=0;i<s1.length()-s2.length();i++){
            if(s1.substring(i,i+s2.length()).equalsIgnoreCase(s2))return true;
        }
        return false;
    }
    boolean lookUp(String s[]){
        if(getMatchingTerms(s)>0)return true;
        return false;
    }
    public String getCSV(String s[]){
        String str="";
        for(int i=0;i<s.length;i++){str=str+s[i];if(i!=s.length-1)str=str+", ";}
        return str;
    }
    public String getLSV(String s[]){
        String str="";
        for(int i=0;i<s.length;i++){str=str+s[i];if(i!=s.length-1)str=str+"\n";}
        return str;
    }
    public void display(){
        System.out.println("ID : "+id+"Name : "+name+"\nKeywords : "+getCSV(keywords)+"\nDescription :\n"+getLSV(d));
    }
    public String[] getInfo(){
        String s[]=new String[4];
        s[0]=""+id;
        s[1]=name;
        s[2]=getCSV(keywords);
        s[3]=getLSV(d);
        return s;
    }
    }