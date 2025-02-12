package AssignmentLinkList;

class Circular {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Circular next;

    public Circular(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

public class Task {
    private Circular head = null;
    private Circular tail = null;
    private Circular current = null;

    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Circular newTask = new Circular(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            newTask.next = head;
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;
        }
    }

    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Circular newTask = new Circular(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            newTask.next = head;
        } else {
            newTask.next = head;
            tail.next = newTask;
            head = newTask;
        }
    }

    public void addTaskAtPosition(int taskId, String taskName, int priority, String dueDate, int position) {
        if (position <= 0) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }
        Circular newTask = new Circular(taskId, taskName, priority, dueDate);
        Circular temp = head;
        for (int i = 0; i < position - 1 && temp.next != head; i++) {
            temp = temp.next;
        }
        newTask.next = temp.next;
        temp.next = newTask;
        if (temp == tail) {
            tail = newTask;
        }
    }

    public void removeTaskById(int taskId) {
        if (head == null) return;
        Circular temp = head, prev = null;
        do {
            if (temp.taskId == taskId) {
                if (temp == head) {
                    head = head.next;
                    tail.next = head;
                } else {
                    prev.next = temp.next;
                    if (temp == tail) {
                        tail = prev;
                    }
                }
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
    }

    public void viewCurrentTask() {
        if (current == null) current = head;
        if (current != null) {
            System.out.println("Current Task: " + current.taskName);
        }
    }

    public void moveToNextTask() {
        if (current != null) {
            current = current.next;
            viewCurrentTask();
        }
    }

    public void displayTasks() {
        if (head == null) return;
        Circular temp = head;
        do {
            System.out.println(temp.taskId + " | " + temp.taskName + " | " + temp.priority + " | " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int priority) {
        if (head == null) return;
        Circular temp = head;
        do {
            if (temp.priority == priority) {
                System.out.println("Task: " + temp.taskName + " | Priority: " + temp.priority);
            }
            temp = temp.next;
        } while (temp != head);
    }
}

class Main{
    public static void main(String[] args) {
        Task scheduler = new Task();

        scheduler.addTaskAtEnd(1, "Complete Report", 1, "2025-02-20");
        scheduler.addTaskAtEnd(2, "Team Meeting", 2, "2025-02-21");
        scheduler.addTaskAtBeginning(3, "Project Review", 1, "2025-02-19");

        System.out.println("All Tasks:");
        scheduler.displayTasks();

        System.out.println("\nViewing Current Task:");
        scheduler.viewCurrentTask();
        scheduler.moveToNextTask();

        System.out.println("\nSearching for Priority 1 Tasks:");
        scheduler.searchByPriority(1);
    }
}
