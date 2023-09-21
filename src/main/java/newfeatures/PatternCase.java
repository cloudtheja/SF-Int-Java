package newfeatures;

public class PatternCase {
  public static void main(String[] args) {
//    Object obj = null;
    Object obj = "Hello";
    // pattern matching switch can be an expression too :)
    switch (obj) { // pattern match switch can have
      case null -> System.out.println("Oh look!!! it's a null");
      // this would take precedence by order over length > 3, creating
      // a probably bad situation, but the compiler can't tell
//      case String s when s.length() < 20 -> System.out.println("it's a short string");
      case String s when s.length() > 3 -> {
        System.out.println("it's a fairly long string " + s);
        System.out.println("length is " + s.length());
      }
      // cannot preceed the guarded case
      case String s -> System.out.println("it's a short string");
      default -> System.out.println("Something else!");
    }
  }
}
