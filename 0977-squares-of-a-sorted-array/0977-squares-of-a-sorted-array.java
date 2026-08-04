import java.util.Arrays;

class Solution {

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int left = 0;
        int right = n - 1;

        // Fill the result array from the end
        for (int i = n - 1; i >= 0; i--) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                result[i] = leftSquare;
                left++;
            } else {
                result[i] = rightSquare;
                right--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] nums = {-4, -1, 0, 3, 10};

        System.out.println(Arrays.toString(s.sortedSquares(nums)));
    }
}
