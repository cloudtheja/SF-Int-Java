package threadissues;

class MyTask2 implements Runnable {
  public long getCounter() {
    return counter;
  }
  private long counter = 0;
  @Override
  public void run() {
    for (long l = 0; l < 1_000_000_000; l++) {
      counter++;
    }
  }
}
public class Transactions2 {
  public static void main(String[] args) throws InterruptedException {
    MyTask2 mt2 = new MyTask2();
    Thread t1 = new Thread(mt2);
    Thread t2 = new Thread(mt2);

    t1.start();
    t2.start();

    t1.join();
    t2.join();
    System.out.println("counter value is " + mt2.getCounter());
  }
}
