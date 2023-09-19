package lab1.students.experiments;

enum Days {
  MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}
enum Suit {
  HEARTS, DIAMONDS, SPADES, CLUBS;
}

public class Poker {
  private static Suit trumps = Suit.HEARTS;

  public static boolean isTrumps(Suit s) {
    return s == trumps;
  }

  // 0 = HEARTS, 1 = DIAMONDS, 2 = SPADES, 3 = CLUBS
  private static int trumpsInt = 2;

  public static boolean isIntTrumps(int s) {
    return s == trumpsInt;
  }

  public static void main(String[] args) {
    int suitInt = 99; // ???? invalid

    Suit s = Suit.CLUBS;
  }
}
