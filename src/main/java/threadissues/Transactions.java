package threadissues;

class MyTask implements Runnable {
  private int x = 0;
  @Override
  public void run() {
    System.out.println(Thread.currentThread().getName() + " starting");
    for (; x < 1000; x++) {
      System.out.println(Thread.currentThread().getName() + " x is " + x);
    }
    System.out.println(Thread.currentThread().getName() + " ending");
  }
}

// timing between uncoordinated threads is non-deterministic
// we have to build "time coordination" if we need it.

public class Transactions {
  public static void main(String[] args) {
    MyTask mt = new MyTask();
    System.out.println("main about to kick off run method");
//    mt.run();
    Thread t1 = new Thread(mt);
    t1.start();
    Thread t2 = new Thread(mt);
    t2.start();
    System.out.println("main about to exit");
  }
}
