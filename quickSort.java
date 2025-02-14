package AssignmentSortingAlgorithms;
import java.util.*;
public class quickSort {
    public static void quicksort(int[] prices, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(prices, low, high);
            quicksort(prices, low, pivotIndex - 1); // Sort left partition
            quicksort(prices, pivotIndex + 1, high); // Sort right partition
        }
    }

    private static int partition(int[] prices, int low, int high) {
        int pivot = prices[high]; // Choosing the last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (prices[j] < pivot) {
                i++;
                swap(prices, i, j);
            }
        }
        swap(prices, i + 1, high);
        return i + 1;
    }

    private static void swap(int[] prices, int i, int j) {
        int temp = prices[i];
        prices[i] = prices[j];
        prices[j] = temp;
    }

public static void main(String [] args)
{
    int i , n;
    Scanner sc = new Scanner(System.in) ;
    System.out.println("enter the number of product : ") ;
    n = sc.nextInt() ;

    int[] bookArr = new int[n] ;
    System.out.println("Enter product prices: ") ;
    for(i=0 ; i<n ; i++)
    {
        bookArr[i] = sc.nextInt();
    }

    quicksort(bookArr, 0, bookArr.length - 1);

    for(i=0 ; i<n ; i++)
    {
        System.out.println(" Product prices in sorted array: " + bookArr[i]) ;
    }
}
}

