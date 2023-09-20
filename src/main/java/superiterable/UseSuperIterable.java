package superiterable;

import java.util.List;
import java.util.function.Function;

public class UseSuperIterable {
  public static void main(String[] args) {
    SuperIterable<String> sis = new SuperIterable<>(List.of("Fred", "Jim", "Sheila"));
//
//    for (String s : sis) {
//      System.out.println("> " + s);
//    }


  Function<String, String> makeMessage = s -> "Dear " + s.toUpperCase();

    sis
      .filter(s -> s.length() > 3)
//      .map(s -> "Dear " + s.toUpperCase())
      .map(makeMessage)
      .forEach(s -> System.out.println("String: " + s));
  }
}
