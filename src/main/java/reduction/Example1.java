package reduction;

import java.util.List;
import java.util.stream.IntStream;

public class Example1 {
  public static void main(String[] args) {
    Integer res = List.of(1,2,3,4,5,6,7,8,9,10)
      .stream()
      .reduce(0, (a, b) -> a + b);
    System.out.println("sum is " + res);
    System.out.println("------------------------");
    var res2 = IntStream.iterate(1, x -> x + 1)
      .limit(10)
      .boxed()
      .reduce((a, b) -> a + b);

    res2
      .map(s -> "The sum is " + s)
      .ifPresentOrElse(
        s -> System.out.println(s),
        () -> System.out.println("There was no data"));
    System.out.println("------------------------");

    System.out.println(IntStream.iterate(1, x -> x + 1)
      .limit(10)
      .summaryStatistics());

  }
}
