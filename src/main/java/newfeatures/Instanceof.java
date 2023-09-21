package newfeatures;

import java.util.List;

final class Person {
  private String name;
  private String address;

  public Person(String name, String address) {
    this.name = name;
    this.address = address;
  }

  @Override
  public boolean equals(Object other) {
    return other instanceof Person p &&
      p.name.equals(this.name) &&
      p.address.equals(this.address);
  }
}
public class Instanceof {
  public static void main(String[] args) {
    Object obj = "Hello";
    if (obj instanceof String) {
      String s = (String)obj;
      System.out.println("It's a string: " + s);
    }

    if (obj instanceof String s) {
      System.out.println("it's a string " + s);
    }

//    Object obj2 = List.of("Fred", "Jim", "Sheila");
    Iterable<String> obj2 = List.of("Fred", "Jim", "Sheila");
    if (obj2 instanceof List<String> l) {
      String nameZero = l.get(0);
    }

  }
}
