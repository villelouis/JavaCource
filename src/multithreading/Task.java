package multithreading;
import java.util.concurrent.Callable;

public class Task <T> {
    public Task (Callable<?extends T> callable){
    }
    public T get(){
        return null;
    }
}
