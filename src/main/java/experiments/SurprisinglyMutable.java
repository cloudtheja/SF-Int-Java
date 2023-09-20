package experiments;

import java.util.ArrayList;
import java.util.List;

class BadStudent {
  private String name;
  private List<String> courses;

  public BadStudent(String name, List<String> courses) {
    this.name = name;
    this.courses = courses;
  }

  public BadStudent(String name, String [] courses) {
    this.name = name;
//    this.courses = Arrays.asList(courses); // this fails
    this.courses = List.of(courses); // this works OK!
  }

  public String getName() {
    return name;
  }

  public List<String> getCourses() {
    return courses;
  }

  @Override
  public String toString() {
    return "BadStudent{" +
      "name='" + name + '\'' +
      ", courses=" + courses +
      '}';
  }
}
public class SurprisinglyMutable {
  public static void main(String[] args) {
    List<String> courses = new ArrayList<>(List.of("Math", "Physics"));
    BadStudent fred = new BadStudent("Fred", courses);
    System.out.println(fred);
    courses.remove("Math");
    courses.add("Underwater basket weaving");
    System.out.println(fred);
    fred.getCourses().add("Astrophysics");
    System.out.println(fred);


    String [] moreCourses =  new String[]{"Journalism"};
    BadStudent jim = new BadStudent("Jim", moreCourses);
    System.out.println(jim);
    moreCourses[0] = "Astrophysics";
    System.out.println(jim);
    jim.getCourses().add("FAILS");
    System.out.println(jim);

  }
}
