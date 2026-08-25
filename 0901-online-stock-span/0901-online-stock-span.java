import java.util.*;

class StockSpanner {

    // Each element: {price, span}
    Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {

        int span = 1; // Include today

        // Merge all previous days with price <= current price
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        // Store current price and its calculated span
        stack.push(new int[]{price, span});

        return span;
    }
}