package AssignmentLinkList;

class Process {
    int processId;
    int burstTime;
    int priority;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

public class RoundRobin {
    private Process head;
    private Process tail;
    private int timeQuantum;

    public RoundRobin(int timeQuantum) {
        this.head = null;
        this.tail = null;
        this.timeQuantum = timeQuantum;
    }

    public void addProcess(int processId, int burstTime, int priority) {
        Process newProcess = new Process(processId, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            tail.next = head; // Circular linked list
        } else {
            tail.next = newProcess;
            newProcess.next = head;
            tail = newProcess;
        }
    }

    public void executeProcesses() {
        if (head == null) {
            System.out.println("No processes to execute.");
            return;
        }

        Process current = head;
        int totalWaitingTime = 0, totalTurnaroundTime = 0, completedProcesses = 0;

        while (head != null) {
            if (current.burstTime > 0) {
                System.out.println("Executing Process ID: " + current.processId);
                int executionTime = Math.min(timeQuantum, current.burstTime);
                current.burstTime -= executionTime;

                if (current.burstTime == 0) {
                    System.out.println("Process ID " + current.processId + " completed.");
                    totalTurnaroundTime += executionTime;
                    removeProcess(current.processId);
                    completedProcesses++;
                }
            }
            current = current.next;
        }

        System.out.println("Average Waiting Time: " + (double) totalWaitingTime / completedProcesses);
        System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / completedProcesses);
    }

    public void removeProcess(int processId) {
        if (head == null) return;

        Process current = head, prev = null;
        do {
            if (current.processId == processId) {
                if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else {
                    prev.next = current.next;
                    if (current == tail) {
                        tail = prev;
                    }
                }
                return;
            }
            prev = current;
            current = current.next;
        } while (current != head);
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("No processes in the queue.");
            return;
        }

        Process temp = head;
        do {
            System.out.println("Process ID: " + temp.processId + " | Burst Time: " + temp.burstTime + " | Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
    }
}

class CPUScheduler {
    public static void main(String[] args) {
        RoundRobin scheduler = new RoundRobin(3);
        scheduler.addProcess(1, 10, 2);
        scheduler.addProcess(2, 5, 1);
        scheduler.addProcess(3, 8, 3);
        scheduler.addProcess(4, 6, 2);

        System.out.println("Initial Process Queue:");
        scheduler.displayProcesses();

        System.out.println("\nExecuting Processes:");
        scheduler.executeProcesses();
    }
}
