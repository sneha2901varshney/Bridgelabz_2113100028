package AssignmentRuntimeAnalysis;
import java.util.*;
public class dataStructureComparision {

    public static void main(String[] args) {
        int n = 1000000;

        int[] array = createArray(n);
        HashSet<Integer> hashSet = createHashSet(n);
        TreeSet<Integer> treeSet = createTreeSet(n);

        long startTime = System.currentTimeMillis();
        searchInArray(array, n);
        long endTime = System.currentTimeMillis();
        System.out.println("Array search time: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        searchInHashSet(hashSet, n);
        endTime = System.currentTimeMillis();
        System.out.println("HashSet search time: " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        searchInTreeSet(treeSet, n);
        endTime = System.currentTimeMillis();
        System.out.println("TreeSet search time: " + (endTime - startTime) + "ms");
    }

    public static int[] createArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        return array;
    }

    public static HashSet<Integer> createHashSet(int n) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hashSet.add(i);
        }
        return hashSet;
    }

    public static TreeSet<Integer> createTreeSet(int n) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            treeSet.add(i);
        }
        return treeSet;
    }

    public static void searchInArray(int[] array, int n) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == n) {
                break;
            }
        }
    }

    public static void searchInHashSet(HashSet<Integer> hashSet, int n) {
        hashSet.contains(n);
    }

    public static void searchInTreeSet(TreeSet<Integer> treeSet, int n) {
        treeSet.contains(n);
    }
}

