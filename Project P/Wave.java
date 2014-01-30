class Wave{
Wave(int w,int pd,int a){
this.w=w;
this.pd=pd;
this.a=a;
}
int w,pd,a;
int getY(int t){
return (int)(Math.sin(Math.toRadians((w*t)))*a);
}
}