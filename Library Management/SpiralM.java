public class SpiralM
{
    public void main(int n)
    {
        int a[][]=new int[n][n];
        int i,k,x=0,j,p,cp=0,rp=0,c=1;
        while(c<=n*n)
        {
            for(i=x;i<n-(2*x);i++)
          {
              a[rp][i]=c++;
              cp=i;
          }
          for(j=x+1;j<n-(2*x);j++)
          {
              a[cp][j]=c++;
              rp=j;
            }
          for(k=cp-1;k>=x;k--)
          {
              a[rp][k]=c++;
              cp=k;
            }
            for(p=rp-1;p>x;p--)
            {
                a[cp][p]=c++;
                rp=p;
            }
            x=rp;
        }
        for(i=0;i<n;i++)
        {
            for(j=0;j<n;j++)
            {
                System.out.print(a[i][j]+"   ");
            }
            System.out.println();
        }
    }
}