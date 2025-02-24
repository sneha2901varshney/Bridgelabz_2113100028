package AssignmentAnnotations;
import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CacheResult {
}

class ExpensiveComputation {
    private final Map<Integer, Integer> cache = new HashMap<>();

    @CacheResult
    public int computeFactorial(int n) {
        if (n <= 1) {
            return 1;
        }

        if (cache.containsKey(n)) {
            System.out.println("Fetching from cache for: " + n);
            return cache.get(n);
        }

        int result = n * computeFactorial(n - 1);
        cache.put(n, result);
        System.out.println("Computed factorial of " + n + ": " + result);
        return result;
    }

    public void executeComputation(int n) {
        Method[] methods = this.getClass().getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(CacheResult.class) && method.getName().equals("computeFactorial")) {
                try {
                    System.out.println("Result: " + method.invoke(this, n));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return;
            }
        }
    }
}

public class CustomCacheSystem {
    public static void main(String[] args) {
        ExpensiveComputation computation = new ExpensiveComputation();

        computation.executeComputation(5);
        computation.executeComputation(5);
        computation.executeComputation(6);
        computation.executeComputation(6);
    }
}

