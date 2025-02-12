package AssignmentLinkList;
    class DoubleList {
      String text;
        DoubleList prev, next;

        DoubleList(String text) {
            this.text = text;
        }
    }

public class undoRedo {
    private DoubleList head, tail, current;
    private int size = 0;
    private final int MAX_SIZE = 10;

    public undoRedo() {
        head = tail = current = null;
    }

    public void addState(String text) {
        DoubleList newNode = new DoubleList(text);

        if (current != null) {
            current.next = newNode;
            newNode.prev = current;
        }

        current = newNode;

        if (head == null) {
            head = tail = newNode;
        } else {
            tail = newNode;
        }

        size++;
        if (size > MAX_SIZE) {
            head = head.next;
            if (head != null) head.prev = null;
            size--;
        }
    }

    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
        } else {
            System.out.println("No more undo operations available.");
        }
    }

    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
        } else {
            System.out.println("No more redo operations available.");
        }
    }

    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current State: " + current.text);
        } else {
            System.out.println("No content available.");
        }
    }

    public static void main(String[] args) {
        undoRedo editor = new undoRedo();

        editor.addState("Hello");
        editor.addState("Hello, World");
        editor.addState("Hello, World!");

        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.redo();
        editor.displayCurrentState();
    }
}
