package superiterable;

import java.util.List;

public class UseSuperIterable {
  public static void main(String[] args) {
    SuperIterable<String> sis = new SuperIterable<>(List.of("Fred", "Jim", "Sheila"));
//
//    for (String s : sis) {
//      System.out.println("> " + s);
//    }


//  Function<String, String> makeMessage = s -> "Dear " + s.toUpperCase()

    sis
      .filter(s -> s.length() > 3)
      .forEach(s -> System.out.println("String: " + s));
  }
}
