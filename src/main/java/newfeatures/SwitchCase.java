package newfeatures;

public class SwitchCase {
  public static void main(String[] args) {
    int x = 96;
/*
    switch (x) {
      case 96, 97, 98:
//        int v = 100;
        System.out.println("it's 98");
      case 99:
//        System.out.println(v);
        System.out.println("it's 99");
      default:
        System.out.println("it's something else");
    }
*/
    switch (x) {
      // if you're still using colon form (why! stop it!) commas
      // work for alternation there too
      case 96, 97, 98 -> {
        int v = 100;
        System.out.println("it's 98");
      }
      case 99 -> {
        System.out.println("value of v?");
        if (Math.random() > 0.5) break; // only break in a BLOCK
        System.out.println("it's 99");
      }
      case 100 -> {} // exlicitly do nothing in this case
      default ->
        System.out.println("it's something else");
    }
  }
}
