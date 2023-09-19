package lab1.students.experiments;

import java.util.HashMap;
import java.util.Map;

class Course {
  private String name;

  private Course(String name) {
    System.out.println("Constructing a course: " + name);
    this.name = name;
  }

  private static Map<String, Course> existingCourses = new HashMap<>();

  public static Course of(String name) {
    // validate the name?
    if (name == null || name.length() < 3 || name.length() > 10) {
      throw new IllegalArgumentException("Bad course name");
    }
    name = name.toUpperCase();

    Course c = existingCourses.get(name);
    if (c == null) {
      c = new Course(name);
      existingCourses.put(name, c);
    }
    return c;
  }

  @Override
  public String toString() {
    return "Course{" +
      "name='" + name + '\'' +
      '}';
  }
}
public class PooledCourses {
  public static void main(String[] args) {
    Course math = Course.of("Math");
    System.out.println("course is " + math);
    Course m1 = Course.of("Math");
    System.out.println("course is " + m1);

    System.out.println("math == m1 " + (math == m1));
  }
}
