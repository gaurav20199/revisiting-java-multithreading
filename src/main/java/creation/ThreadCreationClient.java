package creation;

public class ThreadCreationClient {
    public static void main(String[] args) {
        System.out.println("Client Thread name is::"+Thread.currentThread().getName());
        CreationUsingThread threadUsingThreadApproach = new CreationUsingThread();
        threadUsingThreadApproach.start();
        System.out.println("Client Thread ended::"+Thread.currentThread().getName());

    }
}
