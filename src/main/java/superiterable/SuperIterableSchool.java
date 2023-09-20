package superiterable;

import lab1.students.Student;

import java.util.List;

public class SuperIterableSchool {
  public static void main(String[] args) {
    List<Student> school = List.of(
      Student.of("Fred", 3.2, "Math", "Physics"),
      Student.of("Jim", 2.2, "Journalism"),
      Student.of("Sue", 2.2, "Journalism", "History", "Political Science"),
      Student.of("Sheila", 3.9, "Math", "Physics", "Quantum Mechanics", "Astrophysics")
    );

    SuperIterable<Student> sis = new SuperIterable<>(school);

    System.out.println("smart students:");
    sis
      .filter(s -> s.getGpa() > 3)
      .forEach(s -> System.out.println(s));

    System.out.println("-------------------");
    // print "Fred has grade 3.2" etc. for all students
    sis

      .forEach(m -> System.out.println(m));

    System.out.println("-------------------");
    // print Sheila has grade A and takes [Math, Physics, ...], for all smart students
    sis

      .forEach(m -> System.out.println(m));

    System.out.println("-------------------");
    // print Fred takes 2 courses and has grade B for all students
    sis

      .forEach(m -> System.out.println(m));

  }
}
