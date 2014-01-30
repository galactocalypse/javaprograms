 import java.awt.*;
    import java.applet.*;
    import java.awt.event.*;
    import java.awt.geom.*;
    public class AnimAfterEternity2 extends Applet implements
Runnable,MouseMotionListener{
        double angle,a,b;
        int x,y,period;
        Color c;
        Thread t;
        float count=0,valve=1,dist;
        int ox,oy;
        boolean flag;
        Point2D
p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,pO,pL1,pR1,pL2,pR2,pL3,pR3;
        boolean rng;

        public void init(){
            t=new Thread(this);
            rng=true;
            p1=p2=p3=p4=p5=p6=p7=p8=p9=p10=pL1=pR1=pL1=pR1=pR2=pL2=pR3=pL3=new
Point2D.Float(0,0);
            x=0;y=0;
            a=100;
            b=40;
            ox=250;
            oy=250-100;
            flag=true;
            angle=0;
            period=10;
            c=getColor();
            addMouseMotionListener(this);
            t.start();
        }
        public Color getColor(){
            int r=(int)(Math.random()*255);
            int b=(int)(Math.random()*255);
            int g=(int)(Math.random()*255);
            return new Color(r,g,b);
        }

        public void paint(Graphics g1){
            Graphics2D g=(Graphics2D)g1;
            g.setColor(c);
            g.draw(new Line2D.Float(p1,p2));
            g.draw(new Line2D.Float(p1,p4));
            g.draw(new Line2D.Float(p2,p3));
            g.draw(new Line2D.Float(p3,p4));
            g.draw(new Line2D.Float(p5,p6));
            g.draw(new Line2D.Float(p5,p8));
            g.draw(new Line2D.Float(p6,p7));
            g.draw(new Line2D.Float(p7,p8));

            g.draw(new Line2D.Float(p1,p5));
            g.draw(new Line2D.Float(p2,p6));
            g.draw(new Line2D.Float(p3,p7));
            g.draw(new Line2D.Float(p4,p8));

            g.draw(new Line2D.Float(p1,pL1));
            g.draw(new Line2D.Float(p4,pL1));
            g.draw(new Line2D.Float(p5,pL1));
            g.draw(new Line2D.Float(p8,pL1));

            g.draw(new Line2D.Float(p2,pR1));
            g.draw(new Line2D.Float(p3,pR1));
            g.draw(new Line2D.Float(p6,pR1));
            g.draw(new Line2D.Float(p7,pR1));


            g.draw(new Line2D.Float(p3,pL2));
            g.draw(new Line2D.Float(p4,pL2));
            g.draw(new Line2D.Float(p7,pL2));
            g.draw(new Line2D.Float(p8,pL2));

            g.draw(new Line2D.Float(p1,pR2));
            g.draw(new Line2D.Float(p2,pR2));
            g.draw(new Line2D.Float(p5,pR2));
            g.draw(new Line2D.Float(p6,pR2));

            g.draw(new Line2D.Float(p1,pL3));
            g.draw(new Line2D.Float(p2,pL3));
            g.draw(new Line2D.Float(p3,pL3));
            g.draw(new Line2D.Float(p4,pL3));

            g.draw(new Line2D.Float(p5,pR3));
            g.draw(new Line2D.Float(p6,pR3));
            g.draw(new Line2D.Float(p7,pR3));
            g.draw(new Line2D.Float(p8,pR3));
        }


        public void run(){
            int d=0,u=1;
            while(rng){
                if(flag){
                    Image img=createImage((int)getWidth(),(int)getHeight());
                    paint(img.getGraphics());
                    getGraphics().drawImage(img,0,0,this);
                    angle=(angle+1)%360;
                   if(d==200)u=-1;
                   if(d==0)u=1;
                   d=d+u;
                    x=(int)(a*Math.cos(Math.toRadians(angle)));
                    y=(int)(b*Math.sin(Math.toRadians(angle)));
                    p1=new Point2D.Float(ox+x,oy+y);

                    x=(int)(a*Math.cos(Math.toRadians((angle+90)%360)));
                    y=(int)(b*Math.sin(Math.toRadians((angle+90)%360)));
                    p2=new Point2D.Float(ox+x,oy+y);

                    x=(int)(a*Math.cos(Math.toRadians((angle+180)%360)));
                    y=(int)(b*Math.sin(Math.toRadians((angle+180)%360)));
                    p3=new Point2D.Float(ox+x,oy+y);

                    x=(int)(a*Math.cos(Math.toRadians((angle+270)%360)));
                    y=(int)(b*Math.sin(Math.toRadians((angle+270)%360)));
                    p4=new Point2D.Float(ox+x,oy+y);

                    x=(int)(a*Math.cos(Math.toRadians(angle)));
                    y=(int)(b*Math.sin(Math.toRadians(angle)))+d;
                    p5=new Point2D.Float(ox+x,oy+y);

                    x=(int)(a*Math.cos(Math.toRadians((angle+90)%360)));
                    y=(int)(b*Math.sin(Math.toRadians((angle+90)%360)))+d;
                    p6=new Point2D.Float(ox+x,oy+y);

                    x=(int)(a*Math.cos(Math.toRadians((angle+180)%360)));
                    y=(int)(b*Math.sin(Math.toRadians((angle+180)%360)))+d;
                    p7=new Point2D.Float(ox+x,oy+y);

                    x=(int)(a*Math.cos(Math.toRadians((angle+270)%360)));
                    y=(int)(b*Math.sin(Math.toRadians((angle+270)%360)))+d;
                    p8=new Point2D.Float(ox+x,oy+y);

                    x=(int)((p1.getX()+p8.getX())/2);
                    y=(int)((p1.getY()+p8.getY())/2);
                    p9=new Point2D.Float(x,y);

                    x=(int)((p2.getX()+p7.getX())/2);
                    y=(int)((p2.getY()+p7.getY())/2);
                    p10=new Point2D.Float(x,y);

                    x=(int)((p9.getX()+p10.getX())/2);
                    y=(int)((p9.getY()+p10.getY())/2);
                    pO=new Point2D.Float(x,y);


x=(int)((pO.getX()+(a*Math.cos(Math.toRadians(angle)))+count));

y=(int)(((p10.getY()-p9.getY())/(p10.getX()-p9.getX()))*(x-p9.getX())+p9.getY());
                    pL1=new Point2D.Float(x,y);


x=(int)(pO.getX()-(a*Math.cos(Math.toRadians(angle))+count));

y=(int)(((p10.getY()-p9.getY())/(p10.getX()-p9.getX()))*(x-p9.getX())+p9.getY());
                    pR1=new Point2D.Float(x,y);

//dist=(float)Math.sqrt(Math.pow((p9.getX()-pR.getX()),2)+Math.pow((p9.getY()-pR.getY()),2));

                    x=(int)((p4.getX()+p7.getX())/2);
                    y=(int)((p4.getY()+p7.getY())/2);
                    p11=new Point2D.Float(x,y);

                    x=(int)((p3.getX()+p6.getX())/2);
                    y=(int)((p3.getY()+p6.getY())/2);
                    p12=new Point2D.Float(x,y);



x=(int)((pO.getX()+(a*Math.cos(Math.toRadians(angle)))+count));

y=(int)(((p12.getY()-p11.getY())/(p12.getX()-p11.getX()))*(x-p11.getX())+p11.getY());
                    pL2=new Point2D.Float(x,y);


x=(int)(pO.getX()-(a*Math.cos(Math.toRadians(angle))+count));

y=(int)(((p12.getY()-p11.getY())/(p12.getX()-p11.getX()))*(x-p11.getX())+p11.getY());
                    pR2=new Point2D.Float(x,y);

                    x=(int)(pO.getX());
                    y=(int)(pO.getY()+(d/2)+count);
                    pL3=new Point2D.Float(x,y);

                    x=(int)pO.getX();
                    y=(int)(pO.getY()-((d/2)+count));
                    pR3=new Point2D.Float(x,y);

                    if(count>20)   valve=-1;
                    if(count<=0)   valve=+1;
                    count=count+(float)(valve*0.01);

                }
    try{t.sleep(period);}catch(Exception e){}
    }
    }

    public void mouseMoved(MouseEvent e)
    {
    int px=(int)e.getX()-ox;
    int py=(int)e.getY()-oy;
    double val=((px*px)/(a*a))+((py*py)/(b*b));
    if(val<1){flag=false;c=getColor();}
    else {flag=true;}
    }
        public void mouseDragged(MouseEvent e){}
    }