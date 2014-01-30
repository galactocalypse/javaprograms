import java.awt.*;
class Column{
int colnum;
String colname;
int width,height;

int type,STRING=1,NUMBER=2,DATE=3;
Image getTitleImage(Panel p){
Image img=p.createImage(width,height);
return img;
}
Color getBackground(){
return Color.yellow;
}
Color getForeground(){
return Color.black;
}
}