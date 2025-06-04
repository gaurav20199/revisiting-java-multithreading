package creation;

import java.util.concurrent.Callable;

public class CreationUsingCallable implements Callable<String> {

    private final String name; 
     
    public CreationUsingCallable(String name) { 
        this.name = name; 
    } 
     
    @Override 
    public String call() throws Exception { 
        StringBuilder result = new StringBuilder(); 
        for (int i = 0; i < 5; i++) { 
            result.append("Callable ").append(name) 
                  .append(" is running: ").append(i).append("n"); 
            Thread.sleep(500);
        } 
        return result.toString(); 
    } 

}
