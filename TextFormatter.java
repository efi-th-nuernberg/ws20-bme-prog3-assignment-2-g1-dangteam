import java.util.StringTokenizer;
import java.lang.StringBuffer;

class TextFormatter {

  private static final String text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy " +
          "eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et " +
          "accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem " +
          "ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod " +
          "tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et " +
          "justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est " +
          "Lorem ipsum dolor sit amet.";

  public static void main(String[] args) {
    //TextFormatter formatter = new TextFormatter(30);
    //formatter.print(text);
    print(text);
  }

  // Konstruktor
  /*public TextFormatter(int maxLineLength) {
    int maxLineL = maxLineLength;
    this.print = print(text); 
  }*/

  // Ausgabe
  public static void print(String aText) {
    String line = "";
    StringTokenizer st = new StringTokenizer(aText);
    while(st.hasMoreTokens())
    {
      String word = st.nextToken();
      
      if(line.length() + word.length() <= 30){
        line += word + " ";
      }
      else{
        System.out.print(line);
        System.out.print("\n");
        line = "";
      }  
    }
  }
}