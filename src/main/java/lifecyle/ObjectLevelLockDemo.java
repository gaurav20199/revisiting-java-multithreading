package lifecyle;

public class ObjectLevelLockDemo implements Runnable {
    @Override
    public void run() {
        synchronizedMethod();
    }

    // Object-level lock: synchronized instance method
    public synchronized void synchronizedMethod() {
        System.out.println(Thread.currentThread().getName() + " entered");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " exited");
    }

    public static void main(String[] args) {
        ObjectLevelLockDemo obj1 = new ObjectLevelLockDemo();
        ObjectLevelLockDemo obj2 = new ObjectLevelLockDemo();

        Thread t1 = new Thread(obj1, "Thread 1");
        Thread t2 = new Thread(obj1, "Thread 2");
        Thread t3 = new Thread(obj2, "Thread 3");

        t1.start();
        t2.start();
        t3.start();

        /*
         * Thread 3 entered
         * Thread 1 entered
         * Thread 1 exited
         * Thread 2 entered
         * Thread 3 exited
         * Thread 2 exited
         * 
         * 
         * Another possible outcome
         * 
         * Thread 3 entered
         * Thread 1 entered
         * Thread 2 entered
         * Thread 3 exited
         * Thread 2 exited
         * Thread 1 exited
         *
         */


        /*
         * Explanation to why Thread 1 exited last although it entered before Thread 2???
             
         * Synchronized methods/blocks only guarantee mutual exclusion, not execution order. When Thread 1 enters the synchronized 
         * method on obj1, Thread 2 must wait for Thread 1 to release the lock before it can enter.

         * Once Thread 1 finishes its sleep and is ready to exit, it will release the lock, allowing Thread 2 to enter. 
         * However, after releasing the lock, Thread 1 must compete with Thread 2 (and any other waiting threads) for CPU time to 
         * execute the remaining code and actually print its "exited" message.

         * Thread scheduling is managed by the JVM and OS, and is non-deterministic. It's possible that after Thread 1 releases the lock, 
         * Thread 2 is scheduled to run and quickly completes its execution (including printing "exited") before Thread 1 resumes and 
         * prints its own "exited" message.

         * The "entered" message only tells you when a thread acquired the lock, not when it will finish its work or when it will be scheduled next.
         

         */
    }
}
