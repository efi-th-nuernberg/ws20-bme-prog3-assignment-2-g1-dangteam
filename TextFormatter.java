import java.util.StringTokenizer;

class TextFormatter {
  // Attributes
  private final int maxLineLength;
  private static final String text = "Lorem ipsum dolor sit amet, consetetur                  sadipscing elitr, sed diam nonumy " +
          "eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et " +
          "accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem " +
          "ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod " +
          "tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et " +
          "justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est " +
          "Lorem ipsum dolor sit amet.";

  public static void main(String[] args) {
    TextFormatter formatter = new TextFormatter(30);
    formatter.print(text, 'c');
    System.out.print("\n");
    formatter.print(text, 'l');
    System.out.print("\n");
    formatter.print(text, 'r');
  }

  //Konstruktor
  public TextFormatter(int maxLineLength) {
    this.maxLineLength = maxLineLength;
  }

  // Print Function takes a String and an Argument char which desides the 
  // alinement of the output (c = center, l = left, r = right)
  public void print(String aText, char arg) {
    String line = "";
    StringTokenizer st = new StringTokenizer(aText);

    switch(arg)
    {
      case 'l':
        output(line, st, arg);
        break;
      case 'r':
        output(line, st, arg);
        break;
      case 'c':
        output(line, st, arg); 
        break;
      default:
        System.out.print("Error, wrong padding argument");
        break;

    }
  }

  public void output(String line, StringTokenizer st, char arg)
  {
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
        if(arg != 'l')
        {
          line = paddLine(line, arg);
        }
        System.out.print(line + '\n');
        line = "";
        line += word + ' ';
      }
    }
    // Prints out the last line of the given String 
    if(arg != 'l')
    {
      line = paddLastLine(line, arg);
    }
    System.out.print(line + '\n');
  }

  public String paddLine(String line, char arg)
  {
    String temp = "";
    int diff = maxLineLength - line.length();
    if(arg == 'c')
    {
      diff = diff/2;
    }
    for (int i = 0; i<= diff; i++)
      {
        temp += ' ';
      }
    temp += line;
    line = temp;
    return line;
  }

  public String paddLastLine(String line, char arg)
  {
    String temp = "";
    int diff = maxLineLength - line.length();
    if(arg == 'c')
    {
      diff = diff/2;
    }
    for(int i =  0; i<= diff;i++ )
    {
      temp += ' ';
    }
    temp += line;
    line = temp;
    return line;
  }
  
  public String cutWord(String word){
    String firstPart = word.substring(0, maxLineLength - 1);
    System.out.print(firstPart + "-\n");
    String lastPart = word.substring(maxLineLength - 1) + " ";
    return lastPart;
  } 
}
