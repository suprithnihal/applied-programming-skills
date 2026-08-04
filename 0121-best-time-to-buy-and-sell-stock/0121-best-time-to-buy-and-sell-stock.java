class Solution {

    public int maxProfit(int[] prices) {
        int buyPrice = prices[0];
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - buyPrice);
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println(s.maxProfit(prices1)); // Output: 5

        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println(s.maxProfit(prices2)); // Output: 0
    }
}
