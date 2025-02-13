package AssignmentHashMap;
import java.util.*;
class subarrayWithZeroSum {
    public static List<List<Integer>> findZeroSumSubarrays(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        int sum = 0;
        sumMap.put(0, new ArrayList<>(Collections.singletonList(-1)));

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sumMap.containsKey(sum)) {
                for (int start : sumMap.get(sum)) {
                    result.add(Arrays.asList(start + 1, i));
                }
            }

            sumMap.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
        List<List<Integer>> subarrays = findZeroSumSubarrays(nums);

        for (List<Integer> subarray : subarrays) {
            System.out.println("Subarray found from index " + subarray.get(0) + " to " + subarray.get(1));
        }
    }
}

