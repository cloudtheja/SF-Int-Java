package threadissues;

class Worker implements Runnable {
  private boolean stop = false;
  @Override
  public void run() {
    System.out.println("Worker starting");
    while (! stop)
      ;
    System.out.println("Worker stopping");
  }
  public void stop() {
    System.out.println("stop requested");
    stop = true;
  }
}

public class Visibility {
  public static void main(String[] args) throws InterruptedException {
    Worker w = new Worker();
    Thread t = new Thread(w);
    System.out.println("starting worker");
    t.start();
    Thread.sleep(1000);
    System.out.println("about to issue stop request");
    w.stop();
    System.out.println("stop instruction issued, main exiting");
  }
}
