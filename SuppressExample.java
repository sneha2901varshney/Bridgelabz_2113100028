package AssignmentAnnotations;
import java.util.ArrayList;
public class SuppressExample {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("Hello");
        list.add(42);
        list.add(3.14);

        for (Object item : list) {
            System.out.println(item);
        }
    }
}
