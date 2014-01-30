public class Grid{
int r,c,g[][];
public Grid(){
r=c=0;
g=null;
}
public Grid(int r,int c){
this.r=r;
this.c=c;
g=new int[r][c];
populate();
disp();
}
public int getNeighbours(int x,int y){
int ctr=0;
for(int i=0;i<3;i++){
if(g[(r+x-1)%r][(c+y-1+i)%c]==1)ctr++;
if(g[(r+x+1-i)%r][(c+y-1)%c]==1)ctr++;
if(g[(r+x-1+i)%r][(c+y+1)%c]==1)ctr++;
if(g[(r+x+1)%r][(c+y+1-i)%c]==1)ctr++;
}
return ctr;
}

void updateState(){
Grid gr=this;
for(int i=0;i<r;i++){
for(int j=0;j<c;j++){
int x=getNeighbours(i,j);
if(g[i][j]==1&&(x<2||x>3))g[i][j]=0;
else if(x==3)gr.g[i][j]=1;
}
}
disp();
g=gr.g;
}
void populate(){
g=new int[r][c];
g[0][2]=g[2][0]=g[1][2]=g[3][2]=g[2][3]=g[2][0]=g[3][3]=g[2][1]=g[0][0]=1;
}
public void disp(){
for(int i=0;i<r;i++){
for(int j=0;j<c;j++){
System.out.print(g[i][j]);
}
System.out.println();
}
}
}