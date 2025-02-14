package AssignmentSortingAlgorithms;
import java.util.* ;
public class insertionSort {
    public static void main(String [] args)
    {
        int i , temp , prev , n;
        Scanner sc = new Scanner(System.in) ;
        System.out.println("enter the number of employees : ") ;
        n = sc.nextInt() ;

       int[] empArr = new int[n] ;
        System.out.println("Enter Employee Ids: ") ;
        for(i=0 ; i<n ; i++)
        {
            empArr[i] = sc.nextInt();
        }

        for(i=1 ; i< n ; i++ )
        {
            temp = empArr[i] ;
            prev = i-1 ;
            while(prev >= 0 && empArr[prev] > temp)
            {
                empArr[prev+1] = empArr[prev] ;
                prev-- ;
            }
            empArr[prev+1] = temp ;
        }

        for(i=0 ; i<n ; i++)
        {
            System.out.println("Enter Employee Ids in sorted array: " + empArr[i]) ;
        }
    }
}
