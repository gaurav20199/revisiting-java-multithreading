package creation;

public class CreationUsingThread extends Thread{
    @Override
    public void run() {
        System.out.println("Implemented using Thread approach. Current Thread Name is::"+Thread.currentThread().getName());
    }
}
