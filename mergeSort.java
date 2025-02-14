package AssignmentSortingAlgorithms;

import java.util.Scanner;

public class mergeSort {

    public static void splitArray(int[] priceArr, int left, int right) {
        if (left > right) {
            return;
        }

        if (left < right) {
            int mid = left + (right - left) / 2;
            splitArray(priceArr, left, mid);
            splitArray(priceArr, mid + 1, right);
            mergeArray(priceArr, left, mid, right);
        }
    }

    public static void mergeArray(int[] priceArr, int left, int mid ,int right)
    {
       int newArr[] = new int[right - left +1 ] ; // location for sorted array

        int idx1 = left ; // index for array1
        int idx2 = right ; // index for array2
        int x = 0; // index for newArr

        while(idx1 <= mid && idx2 <= right )
        {
            if(priceArr[idx1] <= priceArr[idx2])
            {
                newArr[x++] = priceArr[idx1++];
            }
            else {
                newArr[x++] = priceArr[idx2++];
            }
        }

        while(idx1 <= mid)
        {
            newArr[x++] = priceArr[idx1++];
        }

        while(idx2 <= right)
        {
            newArr[x++] = priceArr[idx2++];
        }

        for(int i =0 , j = right ; i <newArr.length  ; i++ , j++)
        {
            priceArr[j] = newArr[i];
        }
    }

    public static void main(String [] args)
    {
        int i, n;
        Scanner sc = new Scanner(System.in) ;
        System.out.println("enter the number of books : ") ;
        n = sc.nextInt() ;

        int[] priceArr = new int[n] ;
        System.out.println("Enter books prices: ") ;
        for(i=0 ; i<n ; i++)
        {
            priceArr[i] = sc.nextInt();
        }

        int l = priceArr.length;

        splitArray(priceArr,0,l-1);

        for(i = 0; i< n; i++)
        {
            System.out.println(priceArr[i] + " ");
        }
    }
}
