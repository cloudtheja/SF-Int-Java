package collecting;

import java.util.OptionalDouble;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.DoubleStream;

class Average {
  private double sum;
  private long count;

  public Average(double sum, long count) {
    this.sum = sum;
    this.count = count;
  }

  public void update(double d) {
    this.sum += d;
    this.count++;
  }

  public void merge(Average other) {
    this.sum += other.sum;
    this.count += other.count;
  }

  public OptionalDouble get() {
    if (count > 0) {
      return OptionalDouble.of(this.sum / count);
    } else {
      return OptionalDouble.empty();
    }
  }
}

public class Averager {
  public static void main(String[] args) {
    final long COUNT = 9_000_000_000L;
    long start = System.nanoTime();
    DoubleStream.generate(() -> ThreadLocalRandom.current().nextDouble(-1.0, +1.0))
      .parallel()
      .limit(COUNT)
      .collect(
        () -> new Average(0, 0),
        (a, d) -> a.update(d),
        (aFinal, a) -> aFinal.merge(a)
      )
      .get()
      .ifPresentOrElse(a -> System.out.println("Average is " + a),
        () -> System.out.println("no data!"));
    long time = System.nanoTime() - start;
    System.out.printf("""
        Calculated %,d elements in %7.3f seconds
        rate is %,9.3f per second
        """, COUNT, (time / 1_000_000_000.0), (COUNT * 1_000_000_000.0 / time));
  }
}
