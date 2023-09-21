package collecting;

import lab1.students.Student;

import java.util.List;
import java.util.stream.Collectors;

public class UsingCollectors {

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

    var map = school.stream()
      .collect(Collectors.groupingBy(s -> getLetterGrade(s.getGpa())));

    map.entrySet().stream()
      .forEach(e -> System.out.println("students with grade " + e.getKey()
      + " are: " + e.getValue()));

    System.out.println("------------------------");
    var map2 = school.stream()
      .collect(Collectors.groupingBy(
        s -> getLetterGrade(s.getGpa()),
        Collectors.counting()));

    System.out.println(map2);

    System.out.println("------------------------");
    var map3 = school.stream()
      .collect(Collectors.groupingBy(
        s -> getLetterGrade(s.getGpa()),
        Collectors.mapping(s -> s.getName(),
          Collectors.joining(", "))));
    System.out.println(map3);
  }


}
