package AssignmentHashMap;
import java.util.*;
class pairWithGivenSum {
    public static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(target - num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {10, 14, 7, 12, 15};
        int target = 10;

        System.out.println(hasPairWithSum(nums, target) ? "Pair found" : "No pair found");
    }
}
