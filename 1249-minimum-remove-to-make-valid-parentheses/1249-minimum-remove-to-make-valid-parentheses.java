import java.util.*;

class Solution {
    public String minRemoveToMakeValid(String s) {

        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c == '(') {
                // Store index of '('
                stack.push(i);

            } else if (c == ')') {

                if (!stack.isEmpty()) {
                    // Match with previous '('
                    stack.pop();
                } else {
                    // No matching '(' → remove ')'
                    sb.setCharAt(i, '#');
                }
            }
        }

        // Remaining '(' are unmatched → remove them
        while (!stack.isEmpty()) {
            int index = stack.pop();
            sb.setCharAt(index, '#');
        }

        // Remove all marked characters
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '#') {
                result.append(sb.charAt(i));
            }
        }

        return result.toString();
    }
}