package AssignmentReflections;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Greeting {
    void sayHello(String name);
}

class GreetingImpl implements Greeting {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }
}

class LoggingProxyHandler implements InvocationHandler {
    private final Object target;

    public LoggingProxyHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Logging: Invoking method -> " + method.getName());
        return method.invoke(target, args);
    }
}

public class LoggingProxyDemo {
    public static void main(String[] args) {
        Greeting originalGreeting = new GreetingImpl();

        Greeting proxyInstance = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class[]{Greeting.class},
                new LoggingProxyHandler(originalGreeting)
        );

        proxyInstance.sayHello("Sneha");
    }
}

