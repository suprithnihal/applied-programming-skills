import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        // Map: element -> next greater element
        Map<Integer, Integer> map = new HashMap<>();
        
        // Monotonic decreasing stack
        Stack<Integer> stack = new Stack<>();

        // Process nums2
        for (int num : nums2) {
            
            // Current number is the next greater
            // for all smaller elements on top
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            
            stack.push(num);
        }

        // Build answer for nums1
        int[] ans = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.getOrDefault(nums1[i], -1);
        }

        return ans;
    }
}