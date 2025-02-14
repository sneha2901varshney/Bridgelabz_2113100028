package AssignmentSortingAlgorithms;
import java.util.* ;
public class selectionSort {
    public static void main(String[] args) {
        int i, j, temp, a, n;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the number of students : ");
        n = sc.nextInt();

        int[] examArr = new int[n];
        System.out.println("Enter Student marks: ");
        for (i = 0; i < n; i++) {
            examArr[i] = sc.nextInt();
        }

        for (i = 0; i < n - 1; i++) {
            a = i; //smallest value
            for (j = i + 1; j < n; j++) //unsorted part
            {
                if (examArr[j] < examArr[a]) {
                    a = j;
                }
            }
            temp = examArr[i];
            examArr[i] = examArr[a];
            examArr[a] = temp;
        }

        for (i = 0; i < n; i++) {
            System.out.println("Student Marks in sorted array: " + examArr[i]);
        }
    }
}
