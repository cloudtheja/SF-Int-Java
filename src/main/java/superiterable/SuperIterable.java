package superiterable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

// Predicate is core library, and looks like this:
//public interface Predicate<E> {
//  boolean test(E e);
//}

// Consumer is core library and looks like this:
// public interface Consumer<E> {
//   void accept(E e);
// }

// Function<A, R> is a core library feature and looks like:
// public Function<A, R> {
//   R apply(A a);
// }

public class SuperIterable<E> implements Iterable<E> {
  private Iterable<E> self;

  public SuperIterable(Iterable<E> self) {
    if (self == null) throw new IllegalArgumentException();
    this.self = self;
  }

  public SuperIterable<E> filter(/*SuperIterable<E> this,*/
                                   Predicate<E> crit) {
    List<E> results = new ArrayList<>();
    for (E s : this.self) {
      if (crit.test(s)) {
        results.add(s);
      }
    }
    return new SuperIterable<>(results);
  }

  // equivalent to "forEach"
//  public void withAll(SuperIterable<E> this, Consumer<E> op) {
//    for (E s : this.self) {
//      op.accept(s);
//    }
//  }

  @Override
  public Iterator<E> iterator() {
    return self.iterator();
  }
}
