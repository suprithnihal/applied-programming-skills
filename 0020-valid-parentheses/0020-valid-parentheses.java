import java.util.*;

class Solution {
    public boolean isValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {

            // Opening brackets
            if (c == '(') {
                stack.push(')');
            } 
            else if (c == '[') {
                stack.push(']');
            } 
            else if (c == '{') {
                stack.push('}');
            }

            // Closing bracket
            else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}