package experiments;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrimitivesAndWrappers {
  public static void main(String[] args) {
    // eight primitive types in Java
    // boolean
    // byte short int long (integer types)
    // char (does arithmetic, but is 16 bit unsigned)
    // float double

    List<Object> stuff = new ArrayList<>();
    stuff.add("Hello");
    stuff.add(LocalDate.now());
    stuff.add(99); // "autoboxing" to Integer
    System.out.println(stuff);
    // reflection, look at the type of an object at runtime
    System.out.println(stuff.get(0).getClass().getName());
    System.out.println(stuff.get(2).getClass().getName());

    // take care, do not use wrapper types when you wanted primitives
    // wrappers are immutable!
    Float f = 3.14F;
    Float f1 = f + 2; // unbox 3.14, add, and then box the result
    f = f + 2; // as above

//    List<int> // NOPE
    List<Integer> numbers; // YES :(
    // CAN have array of primitives
    // (more efficient, but ugly, because resizing is not possible on arrays)

    int [] ia = { 1, 2, 3, 4, 5, };
  }
}
