package lab1.students.experiments;

import java.util.ArrayList;
import java.util.List;

// with an enum, the possible values are fixed
// at COMPILE TIME
enum Color {
  RED, BLACK;
}
enum Courses {
  MATH(20),
  PHYSICS(25) {
    @Override
    public Color getColor() {
      return Color.RED;
    }
  },
  CHEMISTRY(17),
  JOURNALISM(3, 2);

  private Color color;
  private int credit;
  private int length = 4;

  Courses(int credit) {
    this.credit = credit;
  }

  Courses(int credit, int length) {
    this(credit);
    this.length = length;
  }

  public Color getColor() {
    return Color.BLACK;
  }
  public int getCredit() {
    return this.credit;
  }

  public static List<Courses> getRedCourses() {
    List<Courses> res = new ArrayList<>();
    for (Courses c : Courses.values()) {
      if (c.getColor() == Color.RED) {
        res.add(c);
      }
    }
    return List.copyOf(res);
  }
}

public class MySchool {
  public static int getCourseCredit(String course) {
    // look up credit for course
    // what happens if course is "nerdlesprocket"!?
    return 10;
  }

  public static int getCourseEnumCredit(Courses course) {
    return course.getCredit();
  }

  public static void main(String[] args) {

  }
}
