import java.awt.*;
public class GetAvailableFont {
  public static void main(String[] a) {
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    Font[] fonts = ge.getAllFonts(); 
    for (int i=0;i<fonts.length/4;i++) {
      if(i%3==0)
      System.out.println(fonts[i].getFontName());
      else System.out.print(fonts[i].getFontName()+"\t");
    }
  }
}