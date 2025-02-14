package AssignmentSortingAlgorithms;

public class countingSort {
    public static void counting(int[] ages) {
        int maxAge = 18;
        int minAge = 10;
        int range = maxAge - minAge + 1;
        int[] count = new int[range];
        int[] output = new int[ages.length];

        for (int age : ages) {
            count[age - minAge]++;
        }

        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        for (int i = ages.length - 1; i >= 0; i--) {
            output[count[ages[i] - minAge] - 1] = ages[i];
            count[ages[i] - minAge]--;
        }

        System.arraycopy(output, 0, ages, 0, ages.length);
    }

    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] studentAges = {120, 105, 100, 1080, 130, 106, 120, 104, 107, 110};
        System.out.print("Before Sorting: ");
        printArray(studentAges);
        counting(studentAges);
        System.out.print("After Sorting: ");
        printArray(studentAges);
    }
}
