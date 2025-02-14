package AssignmentSortingAlgorithms;
import java.util.* ;
public class BubbleSort {
public static void main (String[] args)
{
    int i , j , n , temp ;

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the no. of students: ");
    n = sc.nextInt();

    int[] stuArr = new int[n] ;

    System.out.println("Enter the marks of students: ") ;
    for(i=0 ; i<n ; i++)
    {
        stuArr[i] = sc.nextInt();
    }

    for (i=0 ;i< n-1; i++)
    {
        for (j=0 ; j<n-i-1 ; j++)
        {
            if (stuArr[j] > stuArr[j+1])
            {
                temp = stuArr[j] ;
                stuArr[j] = stuArr[j+1] ;
                stuArr[j+1] =  temp ;
            }
        }
    }

    for(i=0 ; i<n ; i++)
    {
        System.out.println("Enter marks in sorted array: " + stuArr[i]) ;
    }
}
}
