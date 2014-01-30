public class SpiralMM
{    public void main(int n)
   {   int a[][]=new int[n][n];
       int i,j,cp=0,rp=0,q=0,c=1,x=0;
       while(c<=(n*n))
       {   if(rp==1) q=1;//when the path is traversed once
           for(i=cp+q;i<n-x;i++)//goes right
         {  a[rp][i]=c++;cp=i;}
         for(i=rp+1;i<n-x;i++)//goes down
         {  a[i][cp]=c++;rp=i;}
         for(i=cp-1;i>=x;i--)//goes left
         {  a[rp][i]=c++;cp=i;}
         for(i=rp-1;i>x;i--)//goes up
         {  a[i][cp]=c++;rp=i;}
       x++;//reduces the area of the array to be traversed
       }
       //display
       System.out.println("Spiral matrix of order :"+n+"\n");
       for(i=0;i<n;i++)
       {    for(j=0;j<n;j++)
               System.out.print(a[i][j]+"\t");
           System.out.println();
       }
   }
}