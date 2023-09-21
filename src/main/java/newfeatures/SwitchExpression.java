package newfeatures;

public class SwitchExpression {
  public static void main(String[] args) {
    int x = 99;

    String message = switch (x) {
      case 99 -> {
        System.out.println("found 99 in my switch");
        yield "value is 99!"; // yield required in block form on right of arrow
      }
      default ->
        "something else";
    } ;
//    String message = switch (x) {
//      case 99 :
//        System.out.println("found 99 in my switch");
//        yield "value is 99!"; // yield NOT return, we are NOT returning from the function
//      default :
//        yield "something else";
//    } ;

    System.out.println(message);
  }
}

