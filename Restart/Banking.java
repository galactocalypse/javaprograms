 import java.io.*;

public class Banking                                                                                                    

{

                public static void main(String[] args){

                                String codes="DWITG";

                                BankAccount C=new BankAccount();

                                BankAccount P=new BankAccount();

                                BankAccount S=new BankAccount();

                                BankAccount L=new BankAccount();

 

                                C.ownersName="Jeffery Gardener";

                                P.ownersName="Jeffery Gardener";

                                S.ownersName="Jeffery Gardener";

                                L.ownersName="Jeffery Gardener";

 

                                C.accountNumber=1001;

                                P.accountNumber=1002;

                                S.accountNumber=1003;

                                L.accountNumber=1004;

                               

                                System.out.println("WARNING!Invalid transaction type terminates program!");

                                for(int x=0;x<25;x++){

                                                int type1=0;

    int transType=0;

    int type2=0;

    double amount=0;

    boolean cheater=false;

 

    String actionTaken="";

    String acct1="";

    String acct2="";

    DataInputStream cr=new DataInputStream(System.in);

    System.out.print("Please enter a valid transaction type.(D,W,I,TorG):");

try{transType=cr.readLine().charAt(0);}catch(Exception e){}

 

if(codes.indexOf(transType)<0){

break;}

 

System.out.print("Please enter the amount:");
try{
amount=Double.parseDouble(cr.readLine());
    }catch(Exception e){}
System.out.print("Please enter the account type(C,P,SorL:)");
try{
type1=(cr.readLine()).charAt(0);
    }catch(Exception e){}

if(transType=='T'){

System.out.print("Which amount do you want to transfer funds to?");
try{
type2=cr.readLine().charAt(0);
    }catch(Exception e){}

}

                               

                                if(transType=='D'){

                                                actionTaken=(actionTaken+"deposited");

                                                if(type1=='C'){

                                                                C.deposit(amount);

                                                                acct1=(acct1+"primary savings");

}

                                                if(type1=='P'){

                                                                P.deposit(amount);

                                                                acct1=(acct1+"primary savings");

}

                                                if(type1=='S'){

                                                                S.deposit(amount);

                                                                acct1=(acct1+"primary savings");

}

                                                if(type1=='L'){

                                                                L.deposit(amount);

                                                                acct1=(acct1+"primary savings");

}

                                }

                                if(transType=='W'){

                                                actionTaken=(actionTaken+"withdrew");

 

                                                if(type1=='C'){

                                                                acct1="checking";

                                                                if(amount<=C.getBalance()){



                                                                }

                                                                else{

                                                                                P.withdraw(amount-C.getBalance()+15);

                                                                                C.withdraw(C.getBalance());

                                                                                cheater=true;

                                                                }

                                                }

                               if(type1=='P'){

                                                                acct1="primary savings";

                                                                if(amount<=P.getBalance()){

                                                                                P.withdraw(amount);

                                                                }

                                                                else{

                                                                                System.out.println("Insufficient funds");

                                                                                cheater=true;

                                                                }

                                                }

 

                                if(type1=='S'){

                                                                acct1="student loan";

                                                                if(amount<=S.getBalance()){

                                                                                S.withdraw(amount);

                                                                }

                                                                else{

                                                                                System.out.println("Insufficient funds");

                                                                                cheater=true;

                                                                }

                                                }

                                if(type1=='L'){

                                                                acct1="car loan repayment";

                                                                if(amount<=L.getBalance()){

                                                                                L.withdraw(amount);

                                                                }

                                                                else{

                                                                                System.out.println("Insufficient funds");

                                                                                cheater=true;

                                                                }

                                                }

                                }

                                if(transType=='I'){

                                                actionTaken=(actionTaken+"collected");

                                               

                                                if((type1=='P')&&(P.getBalance()>=500))             {

                                                                double temp=(P.getBalance()*(amount/100));

                                                                P.deposit(temp);

acct1 ="primary savings";

}

                                               

                                                if((type1=='S')&&(S.getBalance()>=500))              {

                                                                double temp=(S.getBalance()*(amount/100));

                                                                S.deposit(temp);

acct1 ="student loan";

}

                                                if((type1=='L')&&(L.getBalance()>=500))              {

                                                                double temp=(L.getBalance()*(amount/100));

                                                                L.deposit(temp);

acct1 ="car loan repayment";

}

                                                }

                                if(transType=='T'){

                                                actionTaken=(actionTaken+"transferred");

                                               

                                                if((type1=='C')){

                                                                if(type2=='P'){

                                                                                C.withdraw(amount);

                                                                                P.deposit(amount);

                                                                                acct1 ="checking";

                                                                                acct2="primary savings";

                                                                }

                                                                if(type2=='S'){

                                                                                C.withdraw(amount);

                                                                                S.deposit(amount);

                                                                                acct1 ="checking";

                                                                                acct2="student loan";

                                                                }

                                                                if(type2=='L'){

                                                                                C.withdraw(amount);

                                                                                L.deposit(amount);

                                                                                acct1 ="checking";

                                                                                acct2="car loan repayment";

                                                                }

                                                }

                               

                                                if((type1=='P')){

                                                                if(type2=='S'){

                                                                                P.withdraw(amount);

                                                                                S.deposit(amount);

                                                                                acct1 =" primary savings";

                                                                                acct2=" student loan";

                                                                }

                                                                if(type2=='L'){

                                                                                P.withdraw(amount);

                                                                                L.deposit(amount);

                                                                                acct1 =" primary savings";

                                                                                acct2=" car loan repayment";

                                                                }

                                                                if(type2=='C'){

                                                                                P.withdraw(amount);

                                                                                C.deposit(amount);

                                                                                acct1 =" primary savings";

                                                                                acct2=" checking";

                                                                }

                                                }

                                                if((type1=='S')){

                                                                if(type2=='P'){

                                                                                S.withdraw(amount);

                                                                                P.deposit(amount);

                                                                                acct1 =" student loan";

                                                                                acct2=" primary savings";

                                                                }

                                                                if(type2=='C'){

                                                                                S.withdraw(amount);

                                                                                C.deposit(amount);

                                                                                acct1 =" student loan";

                                                                                acct2="checking";

                                                                }

                                                                if(type2=='L'){

                                                                                S.withdraw(amount);

                                                                                L.deposit(amount);

                                                                                acct1 =" student loan";

                                                                                acct2="car loan repayment";

                                                                }

                                                }

                                                if((type1=='L')){

                                                                if(type2=='P'){

                                                                                L.withdraw(amount);

                                                                                P.deposit(amount);

                                                                                acct1 =" car loan repayment";

                                                                                acct2="primary savings";

                                                                }

                                                                if(type2=='S'){

                                                                                L.withdraw(amount);

                                                                                S.deposit(amount);

                                                                                acct1 =" car loan repayment";

                                                                                acct2=" student loan";

                                                                }

                                                                if(type2=='C'){

                                                                                L.withdraw(amount);

                                                                                C.deposit(amount);

                                                                                acct1 =" car loan repayment";

                                                                                acct2=" checking";

                                                                }

                                                }

                                }

                if(transType=='G'){

                                actionTaken=(actionTaken+"got");

                                if(type1=='C'){

                                                double temp=C.getBalance();

System.out.println("Your balance in checking is $"+temp);

                                }

                                if(type1=='P'){

                                                double temp=P.getBalance();

System.out.println("Your balance in checking is $"+temp);

                                }

                                if(type1=='S'){

                                                double temp=S.getBalance();

System.out.println("Your balance in checking is $"+temp);

                                }

                                if(type1=='L'){

                                                double temp=L.getBalance();

System.out.println("Your balance in checking is $"+temp);

                                }

                                action(actionTaken,amount,acct1,acct2,cheater);

                }

                System.out.println("Account Information");

                System.out.println("C.accountNumber      C.ownersName        C.getBalance()");

                System.out.println("P.accountNumber      P.ownersName        P.getBalance()");

                System.out.println("S.accountNumber      S.ownersName        S.getBalance()");

                System.out.println("L.accountNumber      L.ownersName        L.getBalance()");

}
    }
 


public static void action (String actionTaken, double amount, String acct1, String acct2, boolean cheater){

                if((cheater=true)&&(acct1.equals("checking"))){

                                System.out.println("You TRIED to overdraw your account!Your primary savings account has been debited $15.00 and the difference was covered")             ;

                }

                if(actionTaken.equals("withdrew")){

                                System.out.println("You "+actionTaken+"$"+amount+"from your"+acct1+"account");

                }

                if(actionTaken.equals("deposited")){

                                System.out.println("You "+actionTaken+"$"+amount+"into your"+acct1+"account");

                }

                if(actionTaken.equals("got")){

                                System.out.println("You "+actionTaken+"the balance in your"+acct1+"account");

                }

                if(actionTaken.equals("transferred")){

                                System.out.println("You "+actionTaken+"$"+amount+"from "+acct1+"to"+acct2+".");

                }

                if(actionTaken.equals("collected")){

                                if(cheater==false){

                                                System.out.println("You "+actionTaken+amount+"percent interest on your "+acct1+"account");

                                }

                                else if(cheater==true){

                                                System.out.println("Interest not paid-insufficient balance");

                                }

                }

}

}

                               