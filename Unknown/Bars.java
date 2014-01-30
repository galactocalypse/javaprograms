class Bars{
int lim,ptr,dir,blocks;
Bars(int blocks,int dir){
this.blocks=blocks;
this.dir=dir;
changeLim();
ptr=0;
}
void changeLim(){
lim=(int)(Math.random()*blocks);
}
void process(){
if(dir==0){
if(ptr>lim){dir=1;ptr--;}
else ptr++;
}
else {if(ptr<1){lim=(int)(Math.random()*20);ptr=0;dir=0;}
else ptr--;
}
}
}