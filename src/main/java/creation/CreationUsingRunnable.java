package creation;

public class CreationUsingRunnable implements Runnable{
    public void run() {
        System.out.println("Implemented using Runnable approach. Current Thread Name is::"+Thread.currentThread().getName());
    }
}
