import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Deque<Integer> stack = new ArrayDeque<>();

        for (int asteroid : asteroids) {

            boolean alive = true;

            // Collision is possible only when:
            // stack top is moving right (+)
            // current asteroid is moving left (-)
            while (alive &&
                   !stack.isEmpty() &&
                   stack.peek() > 0 &&
                   asteroid < 0) {

                int top = stack.peek();

                if (top < -asteroid) {
                    // Stack asteroid explodes
                    stack.pop();

                } else if (top == -asteroid) {
                    // Both explode
                    stack.pop();
                    alive = false;

                } else {
                    // Current asteroid explodes
                    alive = false;
                }
            }

            // Current asteroid survived
            if (alive) {
                stack.push(asteroid);
            }
        }

        // Stack is in reverse order
        int[] result = new int[stack.size()];

        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}