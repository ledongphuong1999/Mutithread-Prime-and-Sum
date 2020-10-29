package MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SharedBufferTest {
    public static void main(String[] args) {
        ExecutorService app = Executors.newCachedThreadPool();
        Buffer sharedLocation = new SynchronizedBuffer();
        app.execute(new FindPrime(sharedLocation));
        app.execute(new SumPrime(sharedLocation));
        app.shutdown();
    }
}