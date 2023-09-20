package superiterable;

import lab1.students.Student;

import java.util.List;
import java.util.stream.Stream;

public class SuperIterableSchool {
  public static String getLetterGrade(double grade) {
    if (grade > 3.5) return "A";
    if (grade > 3.0) return "B";
    if (grade > 2.5) return "C";
    return "D";
  }

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
      .map(s -> s.getName() + " has grade " + s.getGpa())
      .forEach(m -> System.out.println(m));

    System.out.println("-------------------");
    // print Sheila has grade A and takes [Math, Physics, ...], for all smart students
    sis
      .filter(s -> s.getGpa() > 3.0)
      .map(s -> s.getName() + " has grade " + getLetterGrade(s.getGpa())
           + " and takes " + s.getCourses())
      .forEach(m -> System.out.println(m));

    System.out.println("-------------------");
    // print Fred takes 2 courses and has grade B for all students
    sis
      .map(s -> s.getName() + " takes " + s.getCourses().size() + " courses and has grade " +
          getLetterGrade(s.getGpa()))
      .forEach(m -> System.out.println(m));

    System.out.println("-------------------");
    // print all the courses
    sis
      .flatMap(s -> new SuperIterable<>(s.getCourses()))
      .forEach(m -> System.out.println(m));

    System.out.println("Using Stream -------------------");
    // print Fred takes 2 courses and has grade B for all students
    Stream<Student> schoolStream = school.stream();
    schoolStream
      .map(s -> s.getName() + " takes " + s.getCourses().size() + " courses and has grade " +
        getLetterGrade(s.getGpa()))
      .forEach(m -> System.out.println(m));

//    System.out.println("can I use schoolStream again?"); // NO! it's stateful.
//    schoolStream
//      .forEach(s -> System.out.println(s));

    System.out.println("-------------------");
    // print all the courses
    school.stream()
      .flatMap(s -> s.getCourses().stream())
      .forEach(m -> System.out.println(m));
  }
}

/*
Using Stream API and Student list...
- print all students
- print "Fred takes 2 courses" for all students that take more than one course
- each student that takes more than two courses, gets a 20% bump in grade, then print them all out
- print all the courses taken by all the students
- read the API docs for java.stream.Stream...
-- print all the courses without duplicates
-- print all courses without duplicates, in order
-------------
- print "Fred takes Math" etc. for all student/course pairs
 */
