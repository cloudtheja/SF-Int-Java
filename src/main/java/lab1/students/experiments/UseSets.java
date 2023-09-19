package lab1.students.experiments;

import com.sun.source.tree.Tree;

import java.time.LocalDate;
import java.util.*;
//import java.lang.StringBuilder;

public class UseSets {
  public static void main(String[] args) {

    String name = "Fred";
//    String upcName = name.toUpperCase();
    name = name.toUpperCase();
    System.out.println(name);
//    System.out.println(upcName);

    System.out.println("----------------");

    // implementation of Java's "collections" are "heterogeneous" i.e. you can add ANYTHING
    Set/*<StringBuilder>*/ names = new HashSet(); // hash set demands "equals" work right, StringBuilder fails!
//    Set names = new TreeSet(); // tree set requires valid "order", consistent with equals

//    names.add(LocalDate.now()); // rejected because of <StringBuilder>

    names.add(new StringBuilder("Fred"));
    names.add(new StringBuilder("Jim"));
    boolean success = names.add(new StringBuilder("Sheila"));
    System.out.println(success);
    success = names.add(new StringBuilder("Sheila"));
    System.out.println(success);
    System.out.println(names);


    int x = 99;
    int y = 99;
    System.out.println(x == y);

    StringBuilder sb1 = new StringBuilder("Hello");
    StringBuilder sb2 = new StringBuilder("Hello");
    System.out.println("sb1 = " + sb1);
    System.out.println("sb2 = " + sb2);
    System.out.println(sb1 == sb2);
    sb2.append(" world");
    System.out.println("sb1 = " + sb1);
    System.out.println("sb2 = " + sb2);
    System.out.println(sb1 == sb2);
    System.out.println(sb1.equals(sb2));

    System.out.println("---------------");
    // Java 9+ "List.of", previously Arrays.asList
//    List<String> folks = new ArrayList<String>(List.of(LocalDate.now(), "Alice", "Bob"));
    List<String> folks = new ArrayList<>(List.of("Alice", "Bob"));
//    var folks = new ArrayList<>(List.of(LocalDate.now(), "Alice", "Bob"));
    folks.add("Fred");
//    folks.add(LocalDate.now());
    System.out.println(folks);
//    String name1 = (String)folks.get(0);
    String name1 = folks.get(0);
    System.out.println(name1);

  }
}
