package reduction;

import java.util.OptionalDouble;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.DoubleStream;

class Average {
  private double sum;
  private long count;

  public Average(double sum, long count) {
    this.sum = sum;
    this.count = count;
  }

  public Average merge(Average other) {
    return new Average(this.sum + other.sum, this.count + other.count);
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
  public static void main(String[] args) throws InterruptedException {
    final Semaphore sem = new Semaphore(0);
//    ForkJoinPool fjp = new ForkJoinPool(4);
    // this is default, no need to execute like this
    ForkJoinPool fjp = ForkJoinPool.commonPool();
    fjp.execute( () -> {
      final long COUNT = 3_000_000_000L;
      long start = System.nanoTime();
      DoubleStream.generate(() -> ThreadLocalRandom.current().nextDouble(-1.0, +1.0))
        .parallel()
        .limit(COUNT)
        .mapToObj(v -> new Average(v, 1))
        .reduce(new Average(0, 0), (a1, a2) -> a1.merge(a2))
        .get()
        .ifPresentOrElse(a -> System.out.println("Average is " + a),
          () -> System.out.println("no data!"));
      long time = System.nanoTime() - start;
      System.out.printf("""
        Calculated %,d elements in %7.3f seconds
        rate is %,9.3f per second
        """, COUNT, (time / 1_000_000_000.0), (COUNT * 1_000_000_000.0 / time));
      sem.release();
    });
    sem.acquire();
    System.out.println("Shutting down");
  }
}
