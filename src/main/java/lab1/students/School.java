package lab1.students;

import java.util.List;

interface CriterionOfStudent {
  boolean test(Student s);
}

class SmartStudent implements CriterionOfStudent {
  private double threshold;

  public SmartStudent(double threshold) {
    this.threshold = threshold;
  }

  @Override
  public boolean test(Student s) {
    return s.getGpa() > threshold;
  }
}

class EnthusiasticStudent implements CriterionOfStudent {
  @Override
  public boolean test(Student s) {
    return s.getCourses().size() > 2;
  }
}

public class School {
  // OO patterns call this "Command" pattern
  // functional programming simply calls this (and other things) "Higher Order Function"
  public static void showByCriterion(List<Student> ls, CriterionOfStudent crit) {
    for (var s : ls) {
      if (crit.test(s)) { // NOT crit(s)
        System.out.println("Interesting! " + s);
      }
    }
  }

//  private static double threshold = 3.0;
//  public static void setThreshold(double threshold) {
//    // validations? permission checks?
//    School.threshold = threshold;
//  }
//  public static void showSmart(List<Student> ls) {
////  public static void showSmart(List<Student> ls, double threshold) {
//    for (var s : ls) {
//      if (s.getGpa() > threshold) {
//        System.out.println("Smart: " + s);
//      }
//    }
//  }
//
//  public static void showEnthusiastic(List<Student> ls) {
//    for (var s : ls) {
//      if (s.getCourses().size() > 2) {
//        System.out.println("Enthusiastic: " + s);
//      }
//    }
//  }
//

  public static void main(String[] args) {
    List<Student> school = List.of(
      Student.of("Fred", 3.2, "Math", "Physics"),
      Student.of("Jim", 2.2, "Journalism"),
      Student.of("Sue", 2.2, "Journalism", "History", "Political Science"),
      Student.of("Sheila", 3.9, "Math", "Physics", "Quantum Mechanics", "Astrophysics")
    );
//    showSmart(school, 3.0);
//    showSmart(school);

    CriterionOfStudent smarterThanThree = new SmartStudent(3.0);
    showByCriterion(school, smarterThanThree);
    System.out.println("------------");
//    showSmart(school, 2.0);
    showByCriterion(school, new SmartStudent(2.0));
    System.out.println("------------");
//    showEnthusiastic(school);
    showByCriterion(school, new EnthusiasticStudent());
    System.out.println("------------");

    // we KNOW (and so does the compiler) this second argument MUST BE
    // CriterionOfStudent
    // we also know that interface declares ONE abstract method
    // which takes a single argument, of type Student, and
    // returns boolean
    // IF (but only if) we only wish to provide that one abstract method
    // we could (conceivably) define the method, and have the compiler
    // a) build a (hidden) class around that method
    // b) instantiate it
    showByCriterion(school,
      (Student s) -> { return s.getCourses().size() <= 2; }
    );

  }
}
