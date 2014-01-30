public class BankAccount{
String ownersName;
int accountNumber;
double balance;
public void deposit(double d){balance+=d;}
public double getBalance(){return balance;}
public void withdraw(double amt){if(balance>=amt)balance-=amt;}
}