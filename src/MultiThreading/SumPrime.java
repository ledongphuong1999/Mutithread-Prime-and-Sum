package MultiThreading;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SumPrime implements Runnable {

    private final Buffer sharedLocation;
    private int sum = 0;
    private boolean FindPrimeTask = false;

    public SumPrime(Buffer shared) {
        sharedLocation = shared;
    }

    @Override
    public void run() {
        try {

            while (true) {
                if (sharedLocation.isTerminate()) {
                    break;
                }
                System.out.print("."); // wait
                sum += sharedLocation.get();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        System.out.println("\n Sum Prime: " + sum);
    }
}