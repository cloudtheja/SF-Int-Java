package completablefuture;

import java.io.FileNotFoundException;
import java.util.concurrent.CompletableFuture;

public class Example {
  public static CompletableFuture<String> readFile(String filename) {
    CompletableFuture<String> res = new CompletableFuture<>();
    new Thread(() -> {
      System.out.println("OS thread (fake!) starts task");
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        System.out.println("Hmm, how did that happen!");;
      }
      if (Math.random() > 0.5) {
        System.out.println("file read completing succesfully!");
        res.complete("The data in  file " + filename + " is a very interesting story");
      } else {
        System.out.println("file read failed!!!");
        res.completeExceptionally(new RuntimeException("File busted"));
      }
    })
      .start();
    return res;
  }

  public static void main(String[] args) throws InterruptedException {
    // CompletableFuture uses "daemon" threads
    CompletableFuture.supplyAsync(() -> {
      System.out.println("starting pipeline in " + Thread.currentThread().getName());
      return "filename.txt";
    })
        .thenApplyAsync(d -> {
          System.out.println("processing " + d + " in " + Thread.currentThread().getName());
          if (Math.random() > 0.5) throw new RuntimeException("Bad file");
          return d.toUpperCase();
        })
      .thenApplyAsync(d -> {
        System.out.println("intermediate data: " + d);
        return "I " + d;
      })
      .handleAsync((s, f) -> {
        if (s != null) {
          System.out.println("Success so far " + s);
          return s;
        } else {
          System.out.println("failed with " + f.getMessage());
          return "recovery.txt";
        }
      })
      .thenCompose(f -> readFile(f))
      .handleAsync((s, f) -> {
        if (s != null) return s;
        else {
          System.out.println("FAILED");
          return "This is fallback data, file reading failed!";
        }
      })
      .thenAcceptAsync(d -> {
        System.out.println("processing final result " + d + " "
          + Thread.currentThread().getName());
      })
      .join();

    System.out.println("main exiting");
  }
}
