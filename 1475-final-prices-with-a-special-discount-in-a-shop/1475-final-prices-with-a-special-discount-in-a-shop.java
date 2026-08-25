import java.util.*;

class Solution {
    public int[] finalPrices(int[] prices) {

        int n = prices.length;
        int[] answer = prices.clone();

        // Store indices
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // Current price can be a discount
            // for previous prices
            while (!stack.isEmpty() &&
                   prices[i] <= prices[stack.peek()]) {

                int index = stack.pop();

                answer[index] -= prices[i];
            }

            stack.push(i);
        }

        return answer;
    }
}