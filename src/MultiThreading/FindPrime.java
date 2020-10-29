package MultiThreading;

public class FindPrime implements Runnable {

    private final Buffer sharedLocation;
    private int i = 0;

    public FindPrime(Buffer shared) {
        sharedLocation = shared;
    }

    @Override
    public void run() {
        try {
            for (int n = 1; n < 100; n++) {

                if (isPrime(n)) {
                    sharedLocation.set(n);
                    System.out.printf("%5d  ", n);
                    if ((++i) % 10 == 0) {
                        System.out.println("");
                    }
                }
            }
            sharedLocation.setTerminate(true);
            sharedLocation.set(0);
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    public static boolean isPrime(int i) {
        int c;
        for (c = 2; c < i; c++) {
            if (i % c == 0) {
                return false;
            }
        }
        return true;
    }
}