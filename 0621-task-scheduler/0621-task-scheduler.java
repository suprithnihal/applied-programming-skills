class Solution {
    public int leastInterval(char[] tasks, int n) {

        // Count frequency of each task
        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Find maximum frequency
        int maxFreq = 0;

        for (int count : freq) {
            maxFreq = Math.max(maxFreq, count);
        }

        // Count how many tasks have maximum frequency
        int maxCount = 0;

        for (int count : freq) {
            if (count == maxFreq) {
                maxCount++;
            }
        }

        // Minimum schedule length forced by the most frequent tasks
        int frame = (maxFreq - 1) * (n + 1) + maxCount;

        // If there are enough other tasks to fill all idle slots,
        // no idle time is necessary.
        return Math.max(tasks.length, frame);
    }
}