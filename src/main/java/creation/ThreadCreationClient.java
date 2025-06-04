package creation;

public class ThreadCreationClient {
    public static void main(String[] args) {
        System.out.println("Client Thread name is::"+Thread.currentThread().getName());
        CreationUsingThread threadUsingThreadApproach = new CreationUsingThread(); // Thread is created in Java and is in new state.
        threadUsingThreadApproach.start(); //  The thread is created at OS level and starts execution → Transitions to RUNNABLE
        System.out.println("Client Thread ended::"+Thread.currentThread().getName()); 

    }
}
