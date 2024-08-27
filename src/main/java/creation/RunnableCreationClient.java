package creation;

public class RunnableCreationClient {
    public static void main(String[] args) {
        System.out.println("Client Thread name is::"+Thread.currentThread().getName());
        CreationUsingRunnable runnableObj = new CreationUsingRunnable();
        Thread threadUsingRunnableApproach = new Thread(runnableObj);
        threadUsingRunnableApproach.start();
        System.out.println("Client Thread ended::"+Thread.currentThread().getName());
    }
}
