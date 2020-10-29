package MultiThreading;

public class SynchronizedBuffer implements Buffer {

    private int buffer = -1;
    private boolean finded = false;
    private boolean terminate = false;

    public synchronized void set(int value) throws InterruptedException {
        while (finded) {
            wait();
        }
        buffer = value;
        finded = true;
        notifyAll();
    }

    public synchronized int get() throws InterruptedException {
        if(isTerminate())
          Thread.interrupted();
        while (!finded) {
            wait();
        }
        finded = false;
        notifyAll();
        return buffer;
    }

    public boolean isTerminate() {
        return terminate;
    }

    public void setTerminate(boolean terminate) {
        this.terminate = terminate;
    }

}