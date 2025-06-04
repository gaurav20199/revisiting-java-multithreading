package creation;

public class StartVsRun extends Thread {

    @Override
    public void run() {
        System.out.println("Run is executed by::"+Thread.currentThread().getName());
    }


    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()); // will print main
        StartVsRun thread = new StartVsRun();
        thread.run(); // run will be executed by main
        thread.start(); // new Thread will be created and run will be executed by new Thread.
        thread.start(); // will give IllegalThreadStateException

    }
}
