package creation;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableClient {

    public static void main(String[] args) {
        Callable callable = new CreationUsingCallable("Task 1");
        Callable callableForTask2 = new CreationUsingCallable("Task 2");
        ExecutorService executorService = Executors.newFixedThreadPool(2);
         try { 
            // Submit Callable tasks to the executor and get Future objects 
            Future<String> future1 = executorService.submit(callable);
            Future<String> future2 = executorService.submit(callableForTask2);
             
            // Get results from Future objects 
            System.out.println("Result from first task:"); 
            System.out.println(future1.get()); // Blocks until the task completes 
             
            System.out.println("Result from second task:"); 
            System.out.println(future2.get()); // Blocks until the task completes 
             
        } catch (InterruptedException | ExecutionException e) { 
            System.out.println("Task execution interrupted: " + e.getMessage()); 
        } finally { 
            // Shutdown the executor 
            executorService.shutdown(); 
        }
    }
    
}
