package AssignmentRuntimeAnalysis;
import java.util.Arrays;
import java.util.Random;
public class searchTarget {
    public static void main(String[] args) {
        int[] sizes = {1000, 10000, 1000000};
        Random random = new Random();

        for (int size : sizes) {
            int[] data = new int[size];
            for (int i = 0; i < size; i++) {
                data[i] = random.nextInt(size * 10);
            }

            int target = data[random.nextInt(size)];

            long startTime = System.nanoTime();
            linearSearch(data, target);
            long linearTime = System.nanoTime() - startTime;

            Arrays.sort(data);
            startTime = System.nanoTime();
            binarySearch(data, target);
            long binaryTime = System.nanoTime() - startTime;

            System.out.println("Dataset Size: " + size);
            System.out.println("Linear Search Time: " + linearTime / 1e6 + " ms");
            System.out.println("Binary Search Time: " + binaryTime / 1e6 + " ms");
            System.out.println();
        }
    }

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}

