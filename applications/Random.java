public class Random {
Random(){
for(int i=0;i<11;i++){
if(((int)(Math.random()*100)%2==0))
System.out.println("O.K.");
else System.out.println("Not O.K.");
}
}
}