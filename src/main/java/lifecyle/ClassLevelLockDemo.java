package lifecyle;

public class ClassLevelLockDemo extends Thread {
    public ClassLevelLockDemo(String name) {
        super(name);
    }

    @Override
    public void run() {
        classLevelLockMethod();
    }

    // Class-level lock: synchronized static method
    private static synchronized void classLevelLockMethod() {
        try {
            System.out.println(Thread.currentThread().getName() + ": entered");
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + ": exited");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void instanceMethod() {
        synchronized(ClassLevelLockDemo.class) {
            System.out.println("Class-level lock acquired in instance method by " + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public static void main(String[] args) {
        ClassLevelLockDemo t1 = new ClassLevelLockDemo("Thread 1");
        ClassLevelLockDemo t2 = new ClassLevelLockDemo("Thread 2");

        t1.start();
        t2.start();

        /*
         * Thread 1: entered
         * Thread 1: exited
         * Thread 2: entered
         * Thread 2: exited
         * 
         * This will be the outcome everytime.
         * 
         * When a thread enters a static synchronized method (or a synchronized block on the class object), it acquires the class-level lock 
         * (the monitor associated with the Class object of that class).

         * Only one thread can hold this lock at a time. All other threads trying to enter any static synchronized method 
         * (or synchronized block on the class object) must wait until the lock is released.

         * In your example, Thread 1 acquires the class-level lock first, enters the method, and completes its execution 
         * (including the sleep and the "exited" print) before releasing the lock.

         * Only after Thread 1 has fully exited and released the lock can Thread 2 acquire the lock and execute the method. 
         * This results in strictly sequential execution: Thread 2 cannot "enter" until Thread 1 has "exited.        
         */
    }
}
