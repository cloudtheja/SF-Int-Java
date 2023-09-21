package newfeatures;

public class TextBlocks {
  public static void main(String[] args) {
    // this must start with a newline
    // NOT "raw" strings
    String longText = """
          This is text,\n\n      
          it has multiple lines. 
      She said ""\"hello""\" 
      """.indent(10);
    System.out.println(longText.length());
    System.out.println(longText + "X");

  }
}
