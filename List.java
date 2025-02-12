import java.util.*;

 class Main2 {
    public static void main(String[] args) {
        List ab = new List();

        ab.addAtBeginning(1, "Ashi", 20, 'A');
        ab.addAtEnd(2, "Rithik", 21, 'B');
        ab.insertAtSpecificPosition(3, 22, "Shrishthi", 22, 'C');

        System.out.println("Student Records:");
        ab.displayNodeDetails();

        ab.updateGradebyRollNumber(2, 'A');
        System.out.println("\nAfter updating Rithik's grade:");
        ab.displayNodeDetails();

        ab.deleteByRollNumber(1);
        System.out.println("\nAfter deleting Ashi's record:");
        ab.displayNodeDetails();
    }
}


class Node {
    int RollNo;
    String Name;
    int Age;
    char Grade;
    Node next;

    public Node(int RollNo, String Name, int Age, char Grade) {
        this.RollNo = RollNo;
        this.Name = Name;
        this.Age = Age;
        this.Grade = Grade;
        this.next = null;
    }
}

public class List {
    private Node head;

    public void addAtBeginning(int RollNo, String Name, int Age, char Grade) {
        Node node = new Node(RollNo, Name, Age, Grade);
        node.next = head;
        head = node;
    }

    public void addAtEnd(int RollNo, String Name, int Age, char Grade) {
        Node node = new Node(RollNo, Name, Age, Grade);
        if (head == null) {
            head = node;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void insertAtSpecificPosition(int position, int RollNo, String Name, int Age, char Grade) {
        Node new_node = new Node(RollNo, Name, Age, Grade);
        if (position == 1) {
            new_node.next = head;
            head = new_node;
        } else {
            Node previous = head;
            int count = 1;
            while (count < position - 1) {
                previous = previous.next;
                count++;
            }
            Node current = previous.next;
            new_node.next = current;
            previous.next = new_node;
        }
    }


    public void deleteByRollNumber(int RollNo) {
        if (head == null) return;
        if (head.RollNo == RollNo) {
            head = head.next;
            return;
        }
        Node temp2 = head, prev = null;
        while (temp2 != null && temp2.RollNo != RollNo) {
            prev = temp2;
            temp2 = temp2.next;
        }
        if (temp2 == null) return;
        prev.next = temp2.next;
    }

    public Node SearchByRollNumber(int RollNo) {
        if (head == null) {
            System.out.println("No record found!!");
            return null;
        }


        Node temp3 = head;
        while (temp3 != null) {
            if (temp3.RollNo == RollNo) {
                System.out.println("Record Found");
                return temp3;
            }
            temp3 = temp3.next;
        }
        return null;

    }

    public void displayNodeDetails() {
        if (head == null) {
            System.out.println("No details to display");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.println("Roll Number: " + temp.RollNo + ", Name: " + temp.Name + ", Age: " + temp.Age + ", Grade: " + temp.Grade);
            temp = temp.next;
        }
    }

    public void updateGradebyRollNumber(int RollNo, char newGrade) {
        Node node = SearchByRollNumber(RollNo);
        if (node != null) {
            node.Grade = newGrade;
            System.out.println("Grade updated successfully");
        } else {
            System.out.println("Student not found");
        }
    }
}