import java.io.*;
public class WellOrdered{
    public int getNum(){
        int ctr=0;
        for(int i=1;i<8;i++){
            for(int j=i+1;j<9;j++){
                for(int k=j+1;k<=9;k++){
                    ctr++;
                    System.out.print(""+i+j+k+"\t");
                    if(ctr%5==0)System.out.println();
                }
            }
        }
        System.out.println();
        return ctr;
    }
    public static void main(String args[]){
        WellOrdered w=new WellOrdered();
        System.out.println("The total number is : "+w.getNum());
    }
}