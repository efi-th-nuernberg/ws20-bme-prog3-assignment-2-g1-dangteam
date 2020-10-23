import java.util.StringTokenizer;
import java.lang.StringBuffer;

class TextFormatter {
  // Attributes
  private final int maxLineLength;
  private static final String text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy " +
          "eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et " +
          "accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem " +
          "ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod " +
          "tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et " +
          "justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est " +
          "Lorem ipsum dolor sit amet.";

  public static void main(String[] args) {
    TextFormatter formatter = new TextFormatter(30);
    formatter.print(text);
  }

  //Konstruktor
  public TextFormatter(int maxLineLength) {
    this.maxLineLength = maxLineLength;
  }

  // Ausgabe
  public void print(String aText) {
    String line = "";
    StringTokenizer st = new StringTokenizer(aText);
    
    while(st.hasMoreTokens())
    {
      String word = st.nextToken();

      if(word.length() > maxLineLength){
        line = cutWord(word);
      }
      
      else if(line.length() + word.length() <= maxLineLength){
        line += word + " ";
      }

      else{
        System.out.print(line);
        System.out.print("\n");
        line = "";
      }
    }
    // Prints out the last line of the given String 
    System.out.print(line + '\n');
  }
  
  public String cutWord(String word){
    String firstPart = word.substring(0, maxLineLength);
    System.out.print(firstPart + "\n");
    String lastPart = word.substring(maxLineLength) + " ";
    return lastPart;
  } 
}