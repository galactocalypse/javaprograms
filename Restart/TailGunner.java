import java.awt.*;
import java.net.*;
import java.util.*;
import java.applet.AudioClip;
import java.applet.Applet;
class TGPoint {
  double xo, yo, zo;  
  double xt, yt, zt;    
  double xp, yp, zp;    
  public TGPoint(double x, double y, double z) {
    this.xo = x;
    this.yo = y;
    this.zo = z;
    this.xt = x;
    this.yt = y;
    this.zt = z;
    this.xp = x;
    this.yp = y;
    this.zp = z;
  }
  public void transform(double ax, double ay, double az, double m, double dx, double dy, double dz) {
    double x, y, z, c, s;
    x = this.xo; y = this.yo; z = this.zo;
    c = Math.cos(ax);
    s = Math.sin(ax);
    this.xt = x;
    this.yt = y * c - z * s;
    this.zt = y * s + z * c;
    x = this.xt; y = this.yt; z = this.zt;
    c = Math.cos(ay);
    s = Math.sin(ay);
    this.xt = x * c - z * s;
    this.yt = y;
    this.zt = x * s + z * c;
    x = this.xt; y = this.yt; z = this.zt;
    c = Math.cos(az);
    s = Math.sin(az);
    this.xt = x * c - y * s;
    this.yt = x * s + y * c;
    this.zt = z;
    this.xt *= m; this.yt *= m; this.zt *= m;
    this.xt += dx; this.yt += dy; this.zt += dz;
  }
  public void project(TGPoint v) {
    double d;
    d = v.zt - this.zt; 
    if (d != 0) {
      this.xp = (v.zt * this.xt - v.xt * this.zt) / d;
      this.yp = (v.zt * this.yt - v.yt * this.zt) / d;
      this.zp = (v.zt * this.zt) / d;
    }
    else {
      this.xp = 0.0;
      this.yp = 0.0;
      this.zp = 0.0;
    }
  }
}
class TGFace {
  Vector indices;
  public TGFace() {
    this.indices = new Vector();
  }
  public void addIndice(int i) {
    this.indices.addElement(new Integer(i));
  }
}
class TGObject {
  Vector vertices;      
  Vector faces;
  double ax, ay, az;   
  double m;
  double dx, dy, dz;
  Vector polygons;     
  Vector angles;       
  Vector depths;        
  static Vector list = new Vector();
  public TGObject() {
    this.vertices = new Vector();
    this.ax = this.ay = this.az = 0.0;
    this.m = 1.0;
    this.dx = this.dy = this.dz = 0.0;
    this.faces = new Vector();
    this.polygons = new Vector();
    this.angles = new Vector();
    this.depths = new Vector();
  }
  public TGObject(TGObject o) {
    int i;
    this.vertices = new Vector();
    for (i = 0; i < o.vertices.size(); i++)
      this.vertices.addElement(o.vertices.elementAt(i));
    this.ax = o.ax; this.ay = o.ay; this.az = o.az;
    this.m = o.m;
    this.dx = o.dx; this.dy = o.dy; this.dz = o.dz;
    this.faces = new Vector();
    for (i = 0; i < o.faces.size(); i++)
      this.faces.addElement(o.faces.elementAt(i));
    this.polygons = new Vector();
    this.angles = new Vector();
    this.depths = new Vector();
  }
  public void addVertice(TGPoint v) {
    this.vertices.addElement(v);
  }
  public void addFace(TGFace f) {
    this.faces.addElement(f);
  }
  public void render(TGPoint v, double mag, int xoffset, int yoffset) {
    int i, j, k;
    Integer index;
    Polygon polygon;
    TGPoint point;
    TGPoint[] p;
    TGFace face;
    double angle;
    double d1;
    Double d2;
    boolean inserted;
    for (i = 0; i < this.vertices.size(); i++) {
      point = (TGPoint) this.vertices.elementAt(i);
      point.transform(this.ax, this.ay, this.az, this.m, this.dx, this.dy, this.dz);
      point.project(v);
    }
    this.polygons.removeAllElements();
    this.angles.removeAllElements();
    this.depths.removeAllElements();
    d1 = 0;
    for (i = 0; i < this.faces.size(); i++) {
      polygon = new Polygon();
      face = (TGFace) this.faces.elementAt(i);
      for (j = 0; j < face.indices.size(); j++) {
        index = (Integer) face.indices.elementAt(j);
        k = index.intValue();
        point = (TGPoint) this.vertices.elementAt(k);
        polygon.addPoint((int) Math.round((mag * point.xp) + xoffset),
               (2 * yoffset) - Math.round((int) (mag * point.yp) + yoffset));
        if (j == 0 || point.zp > d1)
          d1 = point.zp;
      }
      p = new TGPoint[3];
      index = (Integer) face.indices.elementAt(0);
      p[0] = (TGPoint) this.vertices.elementAt(index.intValue());
      index = (Integer) face.indices.elementAt(1);
      p[1] = (TGPoint) this.vertices.elementAt(index.intValue());
      index = (Integer) face.indices.elementAt(2);
      p[2] = (TGPoint) this.vertices.elementAt(index.intValue());
      angle = calcAngle(p, v);
      if (angle < Math.PI / 2) {
        k = 0;
        inserted = false;
        do {
          if (k < this.polygons.size()) {
            d2 = (Double) this.depths.elementAt(k);
            if (d1 < d2.doubleValue()) {
              this.polygons.insertElementAt(polygon, k);
              this.angles.insertElementAt(new Double(angle), k);
              this.depths.insertElementAt(new Double(d1), k);
              inserted = true;
            }
          }
          k++;
        } while (k < this.polygons.size() && !inserted);
        if (!inserted) {
              this.polygons.addElement(polygon);
              this.angles.addElement(new Double(angle));
              this.depths.addElement(new Double(d1));
        }
      }
    }
    this.insert();
  }
  private double calcAngle(TGPoint p[], TGPoint v) {
    TGPoint a, b, m, n;
    double s, t, u;
    double dot, div;
    double angle;
    a = new TGPoint(p[1].xt - p[0].xt, p[1].yt - p[0].yt, p[1].zt - p[0].zt);
    b = new TGPoint(p[2].xt - p[1].xt, p[2].yt - p[1].yt, p[2].zt - p[1].zt);
    s =   a.yt * b.zt - b.yo * a.zt;
    t = -(a.xt * b.zt - b.xo * a.zt);
    u =   a.xt * b.yt - b.xo * a.yt;
    n = new TGPoint(s, t, u);
    m = new TGPoint(v.xt - p[1].xt, v.yt - p[1].yt, v.zt - p[1].zt);
    dot = m.xo * n.xt + m.yt * n.yt + m.zt * n.zt;
    div = Math.sqrt(m.xt * m.xt + m.yt * m.yt + m.zt * m.zt) *
          Math.sqrt(n.xt * n.xt + n.yt * n.yt + n.zt * n.zt);
    if (div == 0)
      return 0;
    angle = Math.acos(dot / div);
    return angle;
  }
  public static void reset() {
    list.removeAllElements();
  }
  private void insert() {
    int i;
    boolean inserted;
    TGObject o;
    i = 0;
    inserted = false;
    do {
      if (i < list.size()) {
        o = (TGObject) list.elementAt(i);
        if (this.dz < o.dz) {
          list.insertElementAt(this, i);
          inserted = true;
        }
      }
      i++;
    } while (i < list.size() && !inserted);
    if (!inserted)
      list.addElement(this);
  }
}
class TGShip extends TGObject {
  int     type;        // Type of ship.
  int     color;       // Color index.
  double  speed;       // Speed.
  double  a1, a2;      // Angles for movement along x- and y-axises.
  double  c1, c2;      // Change values for above angles.
  double  dist1;       // Distance from player.
  double  dist2;       // Last distance from player.
  boolean sounded;     // Sound effect played flag.
  boolean exploding;    // Explosion flag.
  int     counter;      // Counter for explosions.
  public TGShip() {
    this.vertices = new Vector();
    this.ax = this.ay = this.az = 0.0;
    this.m = 1.0;
    this.dx = this.dy = this.dz = 0.0;
    this.faces = new Vector();
    this.polygons = new Vector();
    this.angles = new Vector();
    this.depths = new Vector();
    this.type = 0;
    this.color = 0;
    this.speed = 0;
    this.a1 = 0;
    this.a2 = 0;
    this.c1 = 0;
    this.c2 = 0;
    this.dist1 = 0;
    this.dist2 = 0;
    this.sounded = false;
    this.exploding = false;
    this.counter = 0;
  }
  public TGShip(TGObject o) {
    int i;
    this.vertices = new Vector();
    for (i = 0; i < o.vertices.size(); i++)
      this.vertices.addElement(o.vertices.elementAt(i));
    this.ax = o.ax; this.ay = o.ay; this.az = o.az;
    this.m = o.m;
    this.dx = o.dx; this.dy = o.dy; this.dz = o.dz;
    this.faces = new Vector();
    for (i = 0; i < o.faces.size(); i++)
      this.faces.addElement(o.faces.elementAt(i));
    this.polygons = new Vector();
    this.angles = new Vector();
    this.depths = new Vector();
    this.type = 0;
    this.color = 0;
    this.speed = 0;
    this.a1 = 0;
    this.a2 = 0;
    this.c1 = 0;
    this.c2 = 0;
    this.dist1 = 0;
    this.dist2 = 0;
    this.sounded = false;
    this.exploding = false;
    this.counter = 0;
  }
}
class TGDebris extends TGShip {
  double rx, ry, rz;    // Change values for rotation.
  double mx, my, mz;    // Change values position.
  boolean active;       // Active flag.
  public TGDebris() {
    this.vertices = new Vector();
    this.ax = this.ay = this.az = 0.0;
    this.m = 1.0;
    this.dx = this.dy = this.dz = 0.0;
    this.faces = new Vector();
    this.polygons = new Vector();
    this.angles = new Vector();
    this.depths = new Vector();
    this.rx = 0; this.ry = 0; this.rz = 0;
    this.mx = 0; this.my = 0; this.mz =  0;
    this.active = false;
  }
  public TGDebris(TGShip s, int i) {
    int j;
    TGPoint point;
    TGFace face;
    Integer index;
    this.vertices = new Vector();
    face = (TGFace) s.faces.elementAt(i);
    for (j = 0; j < face.indices.size(); j++) {
      index = (Integer) face.indices.elementAt(j);
      point = (TGPoint) s.vertices.elementAt(index.intValue());
      this.addVertice(point);
    }
    face = new TGFace();
    for (j = 0; j < this.vertices.size(); j++)
      face.addIndice(j);
    this.addFace(face);
    face = new TGFace();
    for (j =  this.vertices.size() - 1; j >= 0; j--)
      face.addIndice(j);
    this.addFace(face);
    this.polygons = new Vector();
    this.angles = new Vector();
    this.depths = new Vector();
    this.ax = s.ax; this.ay = s.ay; this.az = s.az;
    this.m = s.m;
    this.dx = s.dx; this.dy = s.dy; this.dz = s.dz;
    this.color = s.color;
  }
}
public class TailGunner extends Applet implements Runnable {
  Thread loadThread;
  Thread loopThread;
  static final int DELAY =  50;    // Milliseconds between screen updates.
  static final int MAG   = 100;    // Magnification for 3D objects.
  static final int DEMO = 1;    // Game states.
  static final int PLAY = 2;
  static final int END  = 3;
  static final int    NUM_TYPES      =     4;
  static final int    NUM_COLORS     =     6;
  static final int    NUM_SHIPS      =     6;
  static final int    START_DISTANCE = -1000;
  static final int    SOUND_DISTANCE =  -150;
  static final int    END_DISTANCE   =     0;
  static final int    MAX_HORIZONTAL =   100;
  static final int    MAX_VERTICAL   =    30;
  static final int    MIN_SPEED      =     2;
  static final int    MAX_SPEED      =     8;
  static final double MAX_TURN       = Math.PI / 100;
  static final int    EXPLODE_COUNT  = 100;
  static final int    MAX_DEBRIS   = 20;
  static final int    DEBRIS_COUNT = 50;
  static final double MAX_SPIN     = Math.PI / 20;
  static final int DEMO_DISTANCE = -40;
  static final int DEMO_COUNT    = 400;
  static final int BLAST_COUNT   =   5;
  static final int END_COUNT     = 200;
  static final int MAX_SHAKE     =   5;
  static final int NUM_STARS     =  20;
  static final int SHIELD_START  = 100;
  static final int TARGET_WIDTH  =  60;
  static final int TARGET_HEIGHT =  40;
  boolean loaded = false;
  boolean firing;
  boolean paused;
  boolean sound;
  int     gameState;
  int     blastCounter;
  int     endCounter;
  int     mx, my;
  int     score;
  int     high;
  int     shields;
  TGObject[] types    = new TGObject[NUM_TYPES];
  double[]   typefrq  = {.30, .30, .20, .20};
  int[]      typepts  = {125, 150, 100, 250};
  double[]   typespd  = {1.15, 1.35, 1.00, 1.75};
  double[]   typetrn  = {1.15, 1.15, 1.00, 1.25};
  int[]      typedmg  = {2, 4, 5, 3};
  String[]   typenme = { "F15 Fighter", "F17A Advanced Tactical Fighter", "F21 Fighter/Bomber", "SF-111 Interceptor" };
  TGShip[] ships = new TGShip[NUM_SHIPS];
  TGDebris[] debris = new TGDebris[MAX_DEBRIS];
  int debrisIndex = 0;
  TGPoint viewpoint;
  int scrnWidth;
  int scrnHeight;
  int starsX[] = new int[NUM_STARS];
  int starsY[] = new int[NUM_STARS];
  double starsAngle[] = new double[NUM_STARS];
  double starsRadius[] = new double[NUM_STARS];
  double starsMinRadius[] = new double[NUM_STARS];
  int demoIndex;
  int demoCounter;
  Dimension offDimension;
  Image offImage;
  Graphics offGraphics;
  Font font = new Font("Helvetica", Font.BOLD, 12);
  FontMetrics fm = getFontMetrics(font);
  int fontWidth = fm.getMaxAdvance();
  int fontHeight = fm.getHeight();
  Font smallFont = new Font("Dialog", font.PLAIN, 10);
  FontMetrics smallFm = getFontMetrics(font);
  int smallFontWidth = fm.getMaxAdvance();
  int smallFontHeight = fm.getHeight();
  AudioClip blastSound;
  AudioClip debrisSound;
  AudioClip explodeSound;
  AudioClip fireSound;
  AudioClip passingSound;
  AudioClip targetedSound;
  public String getAppletInfo() {
    return("PROGARMMED BY DEBAYAN ROY");
  }
  public void init() {
    Frame frame;
    Object parent;
    Dimension d;
    Graphics g;
    TGFace face;
    int i;
    parent = getParent();
    while (!(parent instanceof Frame))
       parent = ((Component) parent).getParent();
    frame = (Frame) parent;
    frame.setCursor(Frame.CROSSHAIR_CURSOR);
    types[0] = new TGObject();
    types[0].addVertice(new TGPoint(-2,  1,   5));    // Fuselage.
    types[0].addVertice(new TGPoint( 2,  1,   5));
    types[0].addVertice(new TGPoint( 0,  0, -10));
    types[0].addVertice(new TGPoint(-2, -1,   5));
    types[0].addVertice(new TGPoint( 2, -1,   5));
    types[0].addVertice(new TGPoint(-1, -1,   7));
    types[0].addVertice(new TGPoint( 1, -1,   7));
    face = new TGFace();
    face.addIndice(0);
    face.addIndice(1);
    face.addIndice(2);
    types[0].addFace(face);
    face = new TGFace();
    face.addIndice(6);
    face.addIndice(5);
    face.addIndice(3);
    face.addIndice(2);
    face.addIndice(4);
    types[0].addFace(face);
    face = new TGFace();
    face.addIndice(4);
    face.addIndice(2);
    face.addIndice(1);
    types[0].addFace(face);
    face = new TGFace();
    face.addIndice(0);
    face.addIndice(2);
    face.addIndice(3);
    types[0].addFace(face);
    face = new TGFace();
    face.addIndice(0);
    face.addIndice(5);
    face.addIndice(6);
    face.addIndice(1);
    types[0].addFace(face);
    face = new TGFace();
    face.addIndice(1);
    face.addIndice(6);
    face.addIndice(4);
    types[0].addFace(face);
    face = new TGFace();
    face.addIndice(0);
    face.addIndice(3);
    face.addIndice(5);
    types[0].addFace(face);
    types[0].addVertice(new TGPoint(5,  0,  -2));  // Port wing.
    types[0].addVertice(new TGPoint(5, -1,  -2));
    types[0].addVertice(new TGPoint(5,  0, -12));
    face = new TGFace();
    face.addIndice(1);
    face.addIndice(7);
    face.addIndice(9);
    face.addIndice(2);
    types[0].addFace(face);
    face = new TGFace();
    face.addIndice(2);
    face.addIndice(9);
    face.addIndice(8);
    face.addIndice(4);
    types[0].addFace(face);
    face = new TGFace();
    face.addIndice(7);
    face.addIndice(1);
    face.addIndice(4);
    face.addIndice(8);
    types[0].addFace(face);
    face = new TGFace();
    face.addIndice(7);
    face.addIndice(8);
    face.addIndice(9);
    types[0].addFace(face);
    types[0].addVertice(new TGPoint(10,  3, -7));
    face = new TGFace();
    face.addIndice(7);
    face.addIndice(10);
    face.addIndice(9);
    types[0].addFace(face);
    face = new TGFace();
    face.addIndice(9);
    face.addIndice(10);
    face.addIndice(8);
    types[0].addFace(face);
    face = new TGFace();
    face.addIndice(7);
    face.addIndice(8);
    face.addIndice(10);
    types[0].addFace(face);
    types[0].addVertice(new TGPoint(-5,  0,  -2));  // Starboard wing.
    types[0].addVertice(new TGPoint(-5, -1,  -2));
    types[0].addVertice(new TGPoint(-5,  0, -12));
    face = new TGFace();
    face.addIndice(0);
    face.addIndice(2);
    face.addIndice(13);
    face.addIndice(11);
    types[0].addFace(face);
    face = new TGFace();
    face.addIndice(2);
    face.addIndice(3);
    face.addIndice(12);
    face.addIndice(13);
    types[0].addFace(face);
    face = new TGFace();
    face.addIndice(0);
    face.addIndice(11);
    face.addIndice(12);
    face.addIndice(3);
    types[0].addFace(face);
    face = new TGFace();
    face.addIndice(11);
    face.addIndice(13);
    face.addIndice(12);
    types[0].addFace(face);
    types[0].addVertice(new TGPoint(-10,  3, -7));
    face = new TGFace();
    face.addIndice(11);
    face.addIndice(13);
    face.addIndice(14);
    types[0].addFace(face);
    face = new TGFace();
    face.addIndice(14);
    face.addIndice(13);
    face.addIndice(12);
    types[0].addFace(face);
    face = new TGFace();
    face.addIndice(14);
    face.addIndice(12);
    face.addIndice(11);
    types[0].addFace(face);
    types[1] = new TGObject();
    types[1].addVertice(new TGPoint(-1, -1,  7));    // Fuselage.
    types[1].addVertice(new TGPoint( 1, -1,  7));
    types[1].addVertice(new TGPoint( 2,  1,  3));
    types[1].addVertice(new TGPoint(-2,  1,  3));
    types[1].addVertice(new TGPoint( 3, -1,  3));
    types[1].addVertice(new TGPoint( 0,  0, -7));
    types[1].addVertice(new TGPoint(-3, -1,  3));
    face = new TGFace();
    face.addIndice(0);
    face.addIndice(1);
    face.addIndice(2);
    face.addIndice(3);
    types[1].addFace(face);
    face = new TGFace();
    face.addIndice(5);
    face.addIndice(3);
    face.addIndice(2);
    types[1].addFace(face);
    face = new TGFace();
    face.addIndice(4);
    face.addIndice(2);
    face.addIndice(1);
    types[1].addFace(face);
    face = new TGFace();
    face.addIndice(6);
    face.addIndice(0);
    face.addIndice(3);
    types[1].addFace(face);
    face = new TGFace();
    face.addIndice(6);
    face.addIndice(5);
    face.addIndice(4);
    face.addIndice(1);
    face.addIndice(0);
    types[1].addFace(face);
    types[1].addVertice(new TGPoint( 9,   3,  -1));    // Port wing.
    types[1].addVertice(new TGPoint( 9, 2.5,  -1));
    types[1].addVertice(new TGPoint( 9,   3, -10));
    types[1].addVertice(new TGPoint(12,   1,  -3));
    types[1].addVertice(new TGPoint(12,   1, -10));
    face = new TGFace();
    face.addIndice(2);
    face.addIndice(7);
    face.addIndice(9);
    face.addIndice(5);
    types[1].addFace(face);
    face = new TGFace();
    face.addIndice(8);
    face.addIndice(4);
    face.addIndice(5);
    face.addIndice(9);
    types[1].addFace(face);
    face = new TGFace();
    face.addIndice(7);
    face.addIndice(10);
    face.addIndice(11);
    face.addIndice(9);
    types[1].addFace(face);
    face = new TGFace();
    face.addIndice(11);
    face.addIndice(10);
    face.addIndice(8);
    face.addIndice(9);
    types[1].addFace(face);
    face = new TGFace();
    face.addIndice(2);
    face.addIndice(4);
    face.addIndice(8);
    face.addIndice(7);
    types[1].addFace(face);
    face = new TGFace();
    face.addIndice(7);
    face.addIndice(8);
    face.addIndice(10);
    types[1].addFace(face);
    types[1].addVertice(new TGPoint( -9,   3,  -1));    // Starboard wing.
    types[1].addVertice(new TGPoint( -9, 2.5,  -1));
    types[1].addVertice(new TGPoint( -9,   3, -10));
    types[1].addVertice(new TGPoint(-12,   1,  -3));
    types[1].addVertice(new TGPoint(-12,   1, -10));
    types[1].addFace(face);
    face = new TGFace();
    face.addIndice(3);
    face.addIndice(5);
    face.addIndice(14);
    face.addIndice(12);
    types[1].addFace(face);
    face = new TGFace();
    face.addIndice(5);
    face.addIndice(6);
    face.addIndice(13);
    face.addIndice(14);
    types[1].addFace(face);
    face = new TGFace();
    face.addIndice(12);
    face.addIndice(14);
    face.addIndice(16);
    face.addIndice(15);
    types[1].addFace(face);
    face = new TGFace();
    face.addIndice(13);
    face.addIndice(15);
    face.addIndice(16);
    face.addIndice(14);
    types[1].addFace(face);
    face = new TGFace();
    face.addIndice(3);
    face.addIndice(12);
    face.addIndice(13);
    face.addIndice(6);
    types[1].addFace(face);
    face = new TGFace();
    face.addIndice(12);
    face.addIndice(15);
    face.addIndice(13);
    types[1].addFace(face);
    types[2] = new TGObject();
    types[2].addVertice(new TGPoint( 1, -.5,  7));    // Fuselage.
    types[2].addVertice(new TGPoint(-1, -.5,  7));
    types[2].addVertice(new TGPoint( 3,   0,  2));
    types[2].addVertice(new TGPoint(-3,   0,  2));
    types[2].addVertice(new TGPoint( 1, 1.5,  5));
    types[2].addVertice(new TGPoint(-1, 1.5,  5));
    types[2].addVertice(new TGPoint( 2,   1,  1));
    types[2].addVertice(new TGPoint(-2,   1,  1));
    types[2].addVertice(new TGPoint( 0,   0, -9));
    face = new TGFace();
    face.addIndice(0);
    face.addIndice(4);
    face.addIndice(5);
    face.addIndice(1);
    types[2].addFace(face);
    face = new TGFace();
    face.addIndice(4);
    face.addIndice(6);
    face.addIndice(7);
    face.addIndice(5);
    types[2].addFace(face);
    face = new TGFace();
    face.addIndice(0);
    face.addIndice(6);
    face.addIndice(4);
    types[2].addFace(face);
    face = new TGFace();
    face.addIndice(0);
    face.addIndice(2);
    face.addIndice(6);
    types[2].addFace(face);
    face = new TGFace();
    face.addIndice(1);
    face.addIndice(5);
    face.addIndice(3);
    types[2].addFace(face);
    face = new TGFace();
    face.addIndice(3);
    face.addIndice(5);
    face.addIndice(7);
    types[2].addFace(face);
    face = new TGFace();
    face.addIndice(0);
    face.addIndice(1);
    face.addIndice(3);
    face.addIndice(2);
    types[2].addFace(face);
    face = new TGFace();
    face.addIndice(6);
    face.addIndice(8);
    face.addIndice(7);
    types[2].addFace(face);
    face = new TGFace();
    face.addIndice(2);
    face.addIndice(8);
    face.addIndice(6);
    types[2].addFace(face);
    face = new TGFace();
    face.addIndice(3);
    face.addIndice(7);
    face.addIndice(8);
    types[2].addFace(face);
    face = new TGFace();
    face.addIndice(2);
    face.addIndice(3);
    face.addIndice(8);
    types[2].addFace(face);
    types[2].addVertice(new TGPoint(12, 1, -10));  // Port wing.
    face = new TGFace();
    face.addIndice(6);
    face.addIndice(9);
    face.addIndice(8);
    types[2].addFace(face);
    face = new TGFace();
    face.addIndice(2);
    face.addIndice(8);
    face.addIndice(9);
    types[2].addFace(face);
    face = new TGFace();
    face.addIndice(2);
    face.addIndice(9);
    face.addIndice(6);
    types[2].addFace(face);
    types[2].addVertice(new TGPoint(-12, 1, -10));  // Starboard wing.
    face = new TGFace();
    face.addIndice(7);
    face.addIndice(8);
    face.addIndice(10);
    types[2].addFace(face);
    face = new TGFace();
    face.addIndice(3);
    face.addIndice(10);
    face.addIndice(8);
    types[2].addFace(face);
    face = new TGFace();
    face.addIndice(3);
    face.addIndice(7);
    face.addIndice(10);
    types[2].addFace(face);
    types[3] = new TGObject();
    types[3].addVertice(new TGPoint(-1,  0,  4));    // Fuselage.
    types[3].addVertice(new TGPoint(-2, .5,  5));
    types[3].addVertice(new TGPoint(-1, -1,  7));
    types[3].addVertice(new TGPoint( 1, -1,  7));
    types[3].addVertice(new TGPoint( 2, .5,  5));
    types[3].addVertice(new TGPoint( 1,  0,  4));
    types[3].addVertice(new TGPoint( 2, -1,  5));
    types[3].addVertice(new TGPoint( 1, -1,  4));
    types[3].addVertice(new TGPoint(-1, -1,  4));
    types[3].addVertice(new TGPoint(-2, -1,  5));
    types[3].addVertice(new TGPoint( 0,  1, -5));
    types[3].addVertice(new TGPoint( 0, -1, -5));
    face = new TGFace();
    face.addIndice(0);
    face.addIndice(1);
    face.addIndice(4);
    face.addIndice(5);
    types[3].addFace(face);
    face = new TGFace();
    face.addIndice(1);
    face.addIndice(2);
    face.addIndice(3);
    face.addIndice(4);
    types[3].addFace(face);
    face = new TGFace();
    face.addIndice(0);
    face.addIndice(1);
    face.addIndice(4);
    face.addIndice(5);
    types[3].addFace(face);
    face = new TGFace();
    face.addIndice(0);
    face.addIndice(5);
    face.addIndice(10);
    types[3].addFace(face);
    face = new TGFace();
    face.addIndice(2);
    face.addIndice(9);
    face.addIndice(8);
    face.addIndice(11);
    face.addIndice(7);
    face.addIndice(6);
    face.addIndice(3);
    types[3].addFace(face);
    face = new TGFace();
    face.addIndice(3);
    face.addIndice(6);
    face.addIndice(4);
    types[3].addFace(face);
    face = new TGFace();
    face.addIndice(6);
    face.addIndice(7);
    face.addIndice(5);
    face.addIndice(4);
    types[3].addFace(face);
    face = new TGFace();
    face.addIndice(2);
    face.addIndice(1);
    face.addIndice(9);
    types[3].addFace(face);
    face = new TGFace();
    face.addIndice(1);
    face.addIndice(0);
    face.addIndice(8);
    face.addIndice(9);
    types[3].addFace(face);
    types[3].addVertice(new TGPoint(9,  0, -12));  // Port wing.
    face = new TGFace();
    face.addIndice(5);
    face.addIndice(12);
    face.addIndice(10);
    types[3].addFace(face);
    face = new TGFace();
    face.addIndice(7);
    face.addIndice(11);
    face.addIndice(12);
    types[3].addFace(face);
    face = new TGFace();
    face.addIndice(5);
    face.addIndice(7);
    face.addIndice(12);
    types[3].addFace(face);
    face = new TGFace();
    face.addIndice(12);
    face.addIndice(11);
    face.addIndice(10);
    types[3].addFace(face);
    types[3].addVertice(new TGPoint(-9,  0, -12));    
    face = new TGFace();
    face.addIndice(0);
    face.addIndice(10);
    face.addIndice(13);
    types[3].addFace(face);
    face = new TGFace();
    face.addIndice(13);
    face.addIndice(11);
    face.addIndice(8);
    types[3].addFace(face);
    face = new TGFace();
    face.addIndice(13);
    face.addIndice(8);
    face.addIndice(0);
    types[3].addFace(face);
    face = new TGFace();
    face.addIndice(13);
    face.addIndice(10);
    face.addIndice(11);
    types[3].addFace(face);
    viewpoint = new TGPoint(0, 0, 10);
    g = getGraphics();
    d = size();
    scrnWidth = d.width;
    scrnHeight = d.height;
    g.setFont(font);
    fm = g.getFontMetrics();
    fontWidth = fm.getMaxAdvance();
    fontHeight = fm.getHeight();
    g.setFont(smallFont);
    smallFm = g.getFontMetrics();
    smallFontWidth = smallFm.getMaxAdvance();
    smallFontHeight = smallFm.getHeight();
    for (i = 0; i < NUM_STARS; i++)
      initStar(i);
    high = 0;
    sound = true;
    initGame();
    initDemo();
  }
  public void initGame() {
    int i;
    gameState = PLAY;
    paused = false;
    firing = false;
    blastCounter = 0;
    score = 0;
    shields = SHIELD_START;
    for (i = 0; i < NUM_SHIPS; i++)
      initShip(i);
    for (i = 0; i < MAX_DEBRIS; i++)
      debris[i] = new TGDebris();
  }
  public void endGame() {
    gameState = END;
    endCounter = END_COUNT;
  }
  public void start() {
    if (loopThread == null) {
      loopThread = new Thread(this);
      loopThread.start();
    }
    if (!loaded && loadThread == null) {
      loadThread = new Thread(this);
      loadThread.start();
    }
  }
  public void stop() {
    if (loopThread != null) {
      loopThread.stop();
      loopThread = null;
    }
    if (loadThread != null) {
      loadThread.stop();
      loadThread = null;
    }
  }
  public void run() {
    long startTime;
    Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
    startTime = System.currentTimeMillis();
    if (!loaded && Thread.currentThread() == loadThread) {
      loadSounds();
      loaded = true;
      loadThread.stop();
    }
    while (Thread.currentThread() == loopThread) {
      if (!paused && (gameState == PLAY || gameState == END)) {
        TGObject.reset();
        updateStars();
        updateShips();
        updateDebris();
        if (blastCounter > 0)
          blastCounter--;
      }
      if (!paused && gameState == END && --endCounter <= 0)
          initDemo();
      if (!paused && gameState == DEMO)
        updateDemo();
      repaint();
      try {
        startTime += DELAY;
        Thread.sleep(Math.max(0, startTime - System.currentTimeMillis()));
      }
      catch (InterruptedException e) {
        break;
      }
    }
  }
  public void loadSounds() {
    try {
      blastSound    = getAudioClip(new URL(getDocumentBase(), "blast.au"));
      debrisSound   = getAudioClip(new URL(getDocumentBase(), "debris.au"));
      explodeSound  = getAudioClip(new URL(getDocumentBase(), "explode.au"));
      fireSound     = getAudioClip(new URL(getDocumentBase(), "fire.au"));
      passingSound  = getAudioClip(new URL(getDocumentBase(), "passing.au"));
      targetedSound = getAudioClip(new URL(getDocumentBase(), "targeted.au"));
    }
    catch (MalformedURLException e) {}
    blastSound.play();    blastSound.stop();
    debrisSound.play();   debrisSound.stop();
    explodeSound.play();  explodeSound.stop();
    fireSound.play();     fireSound.stop();
    passingSound.play();  passingSound.stop();
    targetedSound.play(); targetedSound.stop();
  }
  public void initStar(int i) {
    starsAngle[i] = Math.random() * 2 * Math.PI;
    starsRadius[i] = Math.max(scrnWidth, scrnHeight) / 2 +
      Math.random() * Math.min(scrnWidth, scrnHeight) / 4;
    starsMinRadius[i] = starsRadius[i] / (Math.random() * 9 + 1);
  }
  public void updateStars() {
    int i;
    for (i = 0; i < NUM_STARS; i++) {
      if((starsRadius[i] *= .95) < starsMinRadius[i])
        initStar(i);
      starsX[i] = (int) (scrnWidth / 2  + starsRadius[i] * Math.sin(starsAngle[i]));
      starsY[i] = (int) (scrnHeight / 2 + starsRadius[i] * Math.cos(starsAngle[i]));
    }
  }
  public void initShip(int i) {
    int j;
    double r, f;
    r = Math.random();
    f = 0;
    j = -1;
    do {
      j++;
      f += typefrq[j];
    } while (f < r && j < NUM_TYPES - 1);
    ships[i] = new TGShip(types[j]);
    ships[i].type = j;
    ships[i].dz = START_DISTANCE;
    ships[i].ax = 0;
    ships[i].ay = 0;
    ships[i].az = 0;
    ships[i].color = (int) (Math.random() * NUM_COLORS);
    ships[i].speed = MIN_SPEED + Math.random() * (MAX_SPEED - MIN_SPEED);
    ships[i].speed *= typespd[ships[i].type];
    ships[i].a1 = Math.random() * 2 * Math.PI;
    ships[i].a2 = Math.random() * 2 * Math.PI;
    ships[i].c1 = Math.random() * MAX_TURN - 2 * MAX_TURN;
    ships[i].c1 *= typetrn[ships[i].type];
    ships[i].c2 = Math.random() * MAX_TURN - 2 * MAX_TURN;
    ships[i].c2 *= typetrn[ships[i].type];
    ships[i].dist1 = ships[i].dz;
    ships[i].dist2 = ships[i].dz;
    ships[i].exploding = false;
  }
  public void updateShips() {
    int i;
    double sx, sy;
    for (i = 0; i < NUM_SHIPS; i++) {
      if (ships[i].exploding) {
        if (ships[i].counter == EXPLODE_COUNT) {
          if (sound)
            explodeSound.play();
          explodeShip(i);
          score += typepts[ships[i].type];
          if (score > high)
            high = score;
        }
        if (--ships[i].counter <= 0)
          initShip(i);
      }
      else {
        ships[i].a1 += ships[i].c1;
        if (ships[i].a1 > 2 * Math.PI)
          ships[i].a1 -= 2 * Math.PI;
        ships[i].a2 += ships[i].c2;
        if (ships[i].a2 > 2 * Math.PI)
          ships[i].a2 -= 2 * Math.PI;
        sx = Math.sin(ships[i].a1);
        sy = Math.sin(ships[i].a2);
        ships[i].dx = MAX_HORIZONTAL * sx;
        ships[i].dy = MAX_VERTICAL   * sy;
        ships[i].ax = -sy * Math.PI / 6;
        ships[i].az =  sx * Math.PI / 6;
        ships[i].dz += ships[i].speed;
        ships[i].dist2 = ships[i].dist1;
        ships[i].dist1 = Math.sqrt(Math.pow(ships[i].dx, 2) + Math.pow(ships[i].dy, 2) + Math.pow(ships[i].dz, 2));
        if (ships[i].dz > SOUND_DISTANCE && !ships[i].sounded) {
            ships[i].sounded = true;
            if (sound)
              passingSound.play();
        }
        if (ships[i].dz > END_DISTANCE) {
          if (gameState != END && Math.random() < .5) {
            if (sound)
              blastSound.play();
            shields -= typedmg[ships[i].type];
            if (shields < 0) {
              shields = 0;
              endGame();
            }
            blastCounter = BLAST_COUNT;
          }
          if (gameState == PLAY)
            initShip(i);
          else
            ships[i] = new TGShip();
        }
        ships[i].render(viewpoint, MAG, scrnWidth / 2, scrnHeight / 2);
      }
    }
  }
  public void explodeShip(int i) {
    int j;
    for (j = 0; j < ships[i].faces.size(); j += 2) {
      debris[debrisIndex] = new TGDebris(ships[i], j);
      debris[debrisIndex].rx = Math.random() * MAX_SPIN - 2 * MAX_SPIN;
      debris[debrisIndex].ry = Math.random() * MAX_SPIN - 2 * MAX_SPIN;
      debris[debrisIndex].rz = Math.random() * MAX_SPIN - 2 * MAX_SPIN;
      debris[debrisIndex].mx = Math.random() * ships[i].speed / 2 - ships[i].speed / 4;
      debris[debrisIndex].my = Math.random() * ships[i].speed / 2 - ships[i].speed / 4;
      debris[debrisIndex].mz = ships[i].speed +
        Math.random() * ships[i].speed / 2 - ships[i].speed / 4;
      debris[debrisIndex].counter = DEBRIS_COUNT;
      debris[debrisIndex].active = true;
      if (++debrisIndex >= MAX_DEBRIS)
        debrisIndex = 0;
    }
  }
  public void updateDebris() {
    int i;
    for (i = 0; i < MAX_DEBRIS; i++)
      if (debris[i].active) {
        debris[i].ax += debris[i].rx;
        if (debris[i].ax > 2 * Math.PI)
          debris[i].ax -= 2 * Math.PI;
        debris[i].ay += debris[i].ry;
        if (debris[i].ay > 2 * Math.PI)
          debris[i].ay -= 2 * Math.PI;
        debris[i].az += debris[i].rz;
        if (debris[i].az > 2 * Math.PI)
          debris[i].az -= 2 * Math.PI;
        debris[i].dx += debris[i].mx;
        debris[i].dy += debris[i].my;
        debris[i].dz += debris[i].mz;
        if (debris[i].dz > END_DISTANCE) {
          if (sound && Math.abs(debris[i].dx) < MAG / 2 && Math.abs(debris[i].dy) < MAG / 2)
            debrisSound.play();
          debris[i].active = false;
        }
        else
          debris[i].render(viewpoint, MAG, scrnWidth / 2, scrnHeight / 2);
        if (--debris[i].counter <= 0)
          debris[i].active = false;
      }
  }
  public void initDemo() {
    int i;
    gameState = DEMO;
    demoIndex = 0;
    for (i = 1; i < NUM_SHIPS; i++)
      ships[i] = new TGShip();
    setDemo();
  }
  public void setDemo() {
    ships[0] = new TGShip(types[demoIndex]);
    ships[0].ax = 0;
    ships[0].ay = 0;
    ships[0].a1 = Math.PI / 200;
    ships[0].a2 = Math.PI / 50;
    ships[0].dz = START_DISTANCE;
    ships[0].color = demoIndex;
    ships[0].speed = MAX_SPEED;
    demoCounter = DEMO_COUNT;
  }
  public void updateDemo() {

    if (--demoCounter <= 0) {
      if (++demoIndex >= NUM_TYPES)
        demoIndex = 0;
      setDemo();
    }
    ships[0].ax += ships[0].a1;
    if (Math.abs(ships[0].ax) > Math.PI / 6)
      ships[0].a1 = -ships[0].a1;
    ships[0].ay += ships[0].a2;
    if (ships[0].ay > 2 * Math.PI)
      ships[0].ay -= 2 * Math.PI;
    if (ships[0].dz < DEMO_DISTANCE)
      ships[0].dz += ships[0].speed;
    else
      ships[0].speed = 0;
    ships[0].dist2 = ships[0].dist1;
    ships[0].dist1 = Math.abs(ships[0].dz);
    TGObject.reset();
    ships[0].render(viewpoint, MAG, scrnWidth / 2, scrnHeight / 2);
  }
  public boolean mouseMove(Event e, int x, int y) {
    mx = x;
    my = y;
    return true;
  }
  public boolean mouseDown(Event e, int x, int y) {
    if (!paused && gameState == PLAY) {
      mx = x;
      my = y;
      firing = true;
    }
    if (loaded && gameState == DEMO)
      initGame();
    return true;
  }
  public boolean keyDown(Event e, int key) {
    if (key == 109) {
      if (sound) {
        blastSound.stop();
        debrisSound.stop();
        explodeSound.stop();
        fireSound.stop();
        passingSound.stop();
        targetedSound.stop();
      }
      sound = !sound;
    }
    if (key == 112) {
      if (!paused && sound) {
        blastSound.stop();
        debrisSound.stop();
        explodeSound.stop();
        fireSound.stop();
        passingSound.stop();
        targetedSound.stop();
      }
      paused = !paused;
      firing = false;
    }
    if (loaded && key == 115 && gameState != PLAY)
      initGame();
    return true;
  }
  public Color getColor(int index, int c) {
    if (blastCounter > 0) {
      c = 255 - c;
      return new Color(c, c, c);
    }
    if (index == 0)
      return new Color(c, c / 2, c / 2);
    if (index == 1)
      return new Color(c / 2, c, c / 2);
    if (index == 2)
      return new Color(c / 2, c / 2, c);
    if (index == 3)
      return new Color(0, c, c);
    if (index == 4)
      return new Color(c, 0, c);
    if (index == 5)
      return new Color(c, c, 0);
    return Color.black;
  }
  public void paint(Graphics g) {
    update(g);
  }
  public void update(Graphics g) {
    int i, j;
    int c;
    int xtrans = 0, ytrans = 0;
    int range = 0, speed = 0;
    int x, y;
    int w, h;
    String s;
    TGShip shape, victim;
    Double angle;
    Polygon polygon;
    Dimension d;
    boolean targeted;
    d = size();
    scrnWidth = d.width;
    scrnHeight = d.height;
    if (offGraphics == null || d.width != offDimension.width || d.height != offDimension.height) {
      offDimension = d;
      offImage = createImage(d.width, d.height);
      offGraphics = offImage.getGraphics();
    }
    offGraphics.setColor(Color.black);
    if (blastCounter > 0)
      offGraphics.setColor(Color.white);
    offGraphics.fillRect(0, 0, d.width, d.height);
    if (blastCounter > 0 && !paused) {
      xtrans = (int) (Math.random() * 2 * MAX_SHAKE - MAX_SHAKE);
      ytrans = (int) (Math.random() * 2 * MAX_SHAKE - MAX_SHAKE);
    }
    offGraphics.translate(xtrans, ytrans);
    offGraphics.setColor(Color.white);
    if (blastCounter > 0)
      offGraphics.setColor(Color.black);
    for (i = 0; i < NUM_STARS; i++)
      offGraphics.drawLine(starsX[i], starsY[i], starsX[i], starsY[i]);
    targeted = false;
    victim = null;
    for (i = 0; i < TGObject.list.size(); i++) {
      shape = (TGShip) TGObject.list.elementAt(i);
      for (j = 0; j < shape.polygons.size(); j++) {
        polygon = (Polygon) shape.polygons.elementAt(j);
        angle = (Double) shape.angles.elementAt(j);
        c = 255 - (int) (255 * (angle.doubleValue() / (Math.PI / 2)));
        offGraphics.setColor(getColor(shape.color, c));
        offGraphics.fillPolygon(polygon);
        if (!(shape instanceof TGDebris) && polygon.inside(mx, my)) {
          targeted = true;
          range = (int) shape.dist1;
          speed = (int) ((shape.dist2 - shape.dist1) * 1000 / DELAY);
          if (firing)
            victim = shape;
        }
      }
    }
    if (victim != null) {
      victim.exploding = true;
      victim.counter = EXPLODE_COUNT;
    }
    if (firing && !paused) {
      if (sound)
        fireSound.play();
      firing = false;
      for (i = 0; i < 3; i++) {
        c = 255 - i * 64;
        offGraphics.setColor(new Color(c / 2, c, c / 2));
        if (blastCounter > 0)
          offGraphics.setColor(Color.gray);
        offGraphics.drawLine(0, d.height - 3 + i, mx, my);
        offGraphics.drawLine(0, d.height - 3 - i, mx, my);
        offGraphics.drawLine(d.width, d.height - 3 + i, mx, my);
        offGraphics.drawLine(d.width, d.height - 3 - i, mx, my);
      }
    }
    if (targeted && gameState != END) {
      if (loaded && !paused && sound)
        targetedSound.play();
      offGraphics.setColor(Color.yellow);
      if (blastCounter > 0)
        offGraphics.setColor(Color.darkGray);
      x = TARGET_WIDTH  / 2;
      y = TARGET_HEIGHT / 2;
      w = TARGET_WIDTH  / 4;
      h = TARGET_HEIGHT / 4;
      offGraphics.drawLine(mx - x, my - y, mx - x + w, my - y);
      offGraphics.drawLine(mx + x, my - y, mx + x - w, my - y);
      offGraphics.drawLine(mx - x, my - y, mx - x, my - y + h);
      offGraphics.drawLine(mx + x, my - y, mx + x, my - y + h);
      offGraphics.drawLine(mx - x, my + y, mx - x, my + y - h);
      offGraphics.drawLine(mx + x, my + y, mx + x, my + y - h);
      offGraphics.drawLine(mx - x, my + y, mx - x + w, my + y);
      offGraphics.drawLine(mx + x, my + y, mx + x - w, my + y);
      offGraphics.setFont(smallFont);
      s = range + "m";
      offGraphics.drawString(s, mx + x + smallFontWidth, my);
      s = speed + "mps";
      offGraphics.drawString(s, mx - x - (smallFm.stringWidth(s) + smallFontWidth), my);
    }
    offGraphics.setFont(font);
    offGraphics.setColor(Color.green);
    if (blastCounter > 0)
      offGraphics.setColor(Color.darkGray);
    s = "Score: " + score;
    offGraphics.drawString(s, fontWidth, fontHeight);
    s = "High: " + high;
    offGraphics.drawString(s, d.width - (fontWidth + fm.stringWidth(s)), fontHeight);
    s = "Shields: ";
    offGraphics.drawString(s, fontWidth, d.height - fontHeight);
    x = fm.stringWidth(s) + fontWidth;
    y = d.height - 3 * fontHeight / 2;
    offGraphics.drawRect(x, y, 2 * SHIELD_START, fontHeight / 2);
    offGraphics.fillRect(x, y, 2 * shields, fontHeight / 2);
    if (!sound && !paused && gameState != DEMO) {
      s = "Muted";
      offGraphics.drawString(s, d.width - (fontWidth + fm.stringWidth(s)), d.height - fontHeight);
    }
    if (paused && gameState != DEMO) {
      s = "Paused";
      offGraphics.drawString(s, d.width - (fontWidth + fm.stringWidth(s)), d.height - fontHeight);
    }
    offGraphics.setColor(Color.white);
    if (gameState == END) {
      s = "Game Over";
      offGraphics.drawString(s, (d.width - fm.stringWidth(s)) / 2, (d.height - fontHeight) / 2);
    }
    if (gameState == DEMO) {
      s = "Tail Gunner";
      offGraphics.drawString(s, (d.width - fm.stringWidth(s)) / 2, fontHeight);
      s = "PROGRAMMED BY DEBAYAN ROY";
      offGraphics.drawString(s, (d.width - fm.stringWidth(s)) / 2, 2 * fontHeight);
      if (!loaded) {
        offGraphics.setColor(Color.blue);
        s = "Loading sounds...";
        w = fm.stringWidth(s) + 2 * fontWidth;
        h = 2 * fontHeight;
        x = (d.width  - w) / 2;
        y = (d.height - h) / 4;
        offGraphics.fillRect(x, y, w, h);
        offGraphics.setColor(Color.white);
        offGraphics.drawRect(x, y, w, h);
        offGraphics.drawString(s, x + fontWidth, y + (h + fontHeight) / 2);
      }
      else {
        offGraphics.setColor(Color.green);
        s = "'S' - Start  'P' - Pause/Resume  'M' - Mute/Sound";
        offGraphics.drawString(s, d.width - (fontWidth + fm.stringWidth(s)), d.height - fontHeight);
      }
      offGraphics.setColor(Color.green);
      offGraphics.setFont(smallFont);
      if (targeted) {
        offGraphics.setColor(Color.yellow);
        s = "Target box displays craft's closing speed and range.";
        offGraphics.drawString(s, (d.width - smallFm.stringWidth(s)) / 2, 4 * fontHeight);
      }
      offGraphics.setColor(Color.red);
      s = typenme[demoIndex];
      offGraphics.drawString(s, d.width / 2 - (smallFm.stringWidth(s) + fontWidth), d.height - 4 * fontHeight);
      s = "Maximum speed: " + (MAX_SPEED * typespd[demoIndex] * 1000 / DELAY) + "mps";
      offGraphics.drawString(s, d.width / 2 + smallFontWidth, d.height - 4 * fontHeight);
      s = "Weapon strength: " + typedmg[demoIndex];
      offGraphics.drawString(s, d.width / 2 - (smallFm.stringWidth(s) + fontWidth), d.height - 3 * fontHeight);
      s = "Point value: " + typepts[demoIndex];
      offGraphics.drawString(s, d.width / 2 + smallFontWidth, d.height - 3 * fontHeight);
    }
    offGraphics.translate(-xtrans, -ytrans);
    g.drawImage(offImage, 0, 0, this);
  }
}
