package AssignmentStackQueue;
import java.util.* ;
public class stackRecursion {

    public static void sortStack(Stack<Integer> stack) {
        if (stack.size() > 1) {
            int top = stack.pop();
            sortStack(stack);
            sortedInsert(stack, top);
        }
    }

    private static void sortedInsert(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || element >= stack.peek()) {
            stack.push(element);
        } else {
            int temp = stack.pop();
            sortedInsert(stack, element);
            stack.push(temp);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(60);
        stack.push(40);
        stack.push(90);
        stack.push(50);

        System.out.println("Original Stack: " + stack);

        sortStack(stack);

        System.out.println("Sorted Stack: " + stack);
    }
}
