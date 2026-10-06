import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Count frequency of each number
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Min-heap: [number, frequency]
        PriorityQueue<int[]> minHeap =
            new PriorityQueue<>((a, b) -> a[1] - b[1]);

        // Keep only k most frequent elements
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            minHeap.offer(new int[]{entry.getKey(), entry.getValue()});

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // Build answer
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll()[0];
        }

        return result;
    }
}
