package lab1.students;

import java.util.HashSet;
import java.util.List;

public class Student {
   // Student: must have a name, and gpa should be in range 0 to 5.0

   private String name;
   private double gpa; // float - 32 bit IEEE 754, double - 64 bit
  // many courses array? List? Set? "Iterable", "Collection"
  // Lists have programmer order, duplicates OK, search
  // might not be fast
  // Set rejects duplicate entries, search fast
  // do NOT (necessarily) maintain programmer order
//  java.util.HashSet courses
//  HashSet courses
  private List<String> courses;

  // this is called a "constructor" but it's not; it's an "initializer"
  // objects are constructed (memory allocation) by "new" (which also zeros the memory)
  // then the newly allocated object is passed to the "constructor" as "this"
  // for initialization.
  // Consequences... if you call new there are two possible outcomes:
  //  - a NEW object of EXACTLY the specified type
  //  - or an exception
  private Student(String name, double gpa, List<String> courses) {
    // validity!
    if (!isValid(name, gpa, courses)) {
      throw new IllegalArgumentException("Bad student values");
    }
    this.name = name;
    this.gpa = gpa;
    this.courses = courses;
  }

  // ... causes the recevied data to be an array. IF the caller provides the
  // array, then can still chante the elements
  public static Student of(String name, double gpa, String ... courses) {
    // validation in constructor!
    // List.of copies the array elements, so caller cannot change the result
    return new Student(name, gpa, List.of(courses));
  }

  public static boolean isValid(String name, double gpa, List<String> courses) {
    return name != null && name.length() > 0
      && gpa >= 0 && gpa <= 5.0
      && courses != null;
  }

  public String getName() {
//    String name = "Hahha!";
//    return this.name; // this "disambiguates"

//    return this.name; // this "disambiguates" but is assumed if nothing local
    return name; // style in Java *often* uses unqualified where correct
  }

  public double getGpa() {
    return gpa;
  }

  // consider myStudent.getCourses().add(anotherStudent);
  public List<String> getCourses() {
    return courses;
  }

  // the ESSENCE is that instance methods REQUIRE an instace of the
  // enclosing class as the prefix
  // this suggests that they are suitable when you want to work on one instance

  // static methods do not have an object prefix, do not have this,
  // as such are suitable for behaviors that are RELATED to the concept
  // the class embodies, but NOT spedific to one instance.
  void doStuff() {
    // "this" exists in an instance method
    // to create it, we MUST have a prefix for the method invocation
    // e.g. myStudent.doStuff() -- myStudent at the caller becomes "this" in the method
    // IF you have simply doStuff() (and it works) it must be equivalent to
    // this.doStuff()

    System.out.println(this);
  }
  static void doOtherStuff() {
//    System.out.println(this); // this DOES NOT exist in a static method
  }
  // explicit declaration of "this" is valid since Java 6 !??!
  // if you have an instance method (i.e. "this" exists)
  public Student withName(Student this, String name) {
    // IF (but only if) courses is never modified, then we can reuse it!
    // validation? in this case, performed by the constructor
    return new Student(name, this.gpa, this.courses);
  }

  public Student withGpa(double gpa) {
    return new Student(this.name, gpa, this.courses);
  }

  public Student withCourses(List<String> courses) {
    return new Student(this.name, this.gpa, courses);
  }
}


class TryItOut {
  public static void main(String[] args) {
//    Student s = new Student("Fred", 3.2, List.of("Math", "Physics"));
    Student s = Student.of("Fred", 3.2, "Math", "Physics");
    System.out.println(s.getName());
//    s.name = ""; // NO SETTER
//    s.gpa = -22;
      System.out.println(s.getName());
    System.out.println(s.getGpa());
//    System.out.println(s.name);
//    s.name = "";
//    s.gpa = -22;
//    System.out.println(s.name);
//    System.out.println(s.gpa);
  }
}