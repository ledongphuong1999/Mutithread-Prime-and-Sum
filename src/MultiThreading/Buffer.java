package MultiThreading;

public interface Buffer {
    public void set(int value) throws InterruptedException;
    public int get() throws InterruptedException;
    public void setTerminate(boolean terminate);
    public boolean isTerminate();
}