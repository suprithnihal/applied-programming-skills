import java.util.*;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {

        Deque<Integer> stack = new ArrayDeque<>();

        int j = 0; // pointer for popped

        for (int x : pushed) {

            // Push
            stack.push(x);

            // Pop whenever possible
            while (!stack.isEmpty() &&
                   stack.peek() == popped[j]) {

                stack.pop();
                j++;
            }
        }

        return j == popped.length;
    }
}