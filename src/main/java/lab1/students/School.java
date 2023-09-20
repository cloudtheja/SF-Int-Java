package lab1.students;

import java.util.List;

interface CriterionOfStudent {
  boolean test(Student s);
}

class SmartStudent implements CriterionOfStudent {
  @Override
  public boolean test(Student s) {
    return s.getGpa() > 3.0;
  }
}

public class School {
  public static void showByCriterion(List<Student> ls, CriterionOfStudent crit) {
    for (var s : ls) {
      if (crit.test(s)) {
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

    showByCriterion(school, new SmartStudent());
    System.out.println("------------");
//    showSmart(school, 2.0);
    System.out.println("------------");
//    showEnthusiastic(school);

  }
}
