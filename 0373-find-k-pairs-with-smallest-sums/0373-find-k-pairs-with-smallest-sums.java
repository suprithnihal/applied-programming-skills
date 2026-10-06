import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        // {sum, index in nums1, index in nums2}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        // Start with the first element of nums2 for each nums1 element
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }

        while (k > 0 && !minHeap.isEmpty()) {
            int[] current = minHeap.poll();

            int i = current[1];
            int j = current[2];

            result.add(Arrays.asList(nums1[i], nums2[j]));
            k--;

            // Move to the next element in nums2
            if (j + 1 < nums2.length) {
                minHeap.offer(new int[]{
                    nums1[i] + nums2[j + 1],
                    i,
                    j + 1
                });
            }
        }

        return result;
    }
}
