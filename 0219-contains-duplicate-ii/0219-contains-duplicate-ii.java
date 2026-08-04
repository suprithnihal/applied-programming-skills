import java.util.HashMap;
import java.util.Map;

class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            // Check if the number has been seen before
            if (map.containsKey(nums[i])) {
                int diff = i - map.get(nums[i]);

                if (diff <= k) {
                    return true;
                }
            }

            // Update the latest index of the current number
            map.put(nums[i], i);
        }

        return false;
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums = {1, 2, 3, 1};
        int k = 3;

        System.out.println(s.containsNearbyDuplicate(nums, k));
    }
}
