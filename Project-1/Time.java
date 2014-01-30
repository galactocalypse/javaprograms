public class Time{
    int h,m,s;
    Time(){
        h=m=s=0;
    }
    int getSpent(){
        return (3600*h)+(60*m)+s;
    }
    int getRemaining(){
        return (3600*(23-h))+(59*(60-m))+60-s;
    }
}