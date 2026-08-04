import java.util.Map;
import java.util.HashMap;

class Solution {

    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        // Count the frequency of each character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        // Find the first character with frequency 1
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.firstUniqChar("leetcode"));      // Output: 0
        System.out.println(solution.firstUniqChar("loveleetcode"));  // Output: 2
        System.out.println(solution.firstUniqChar("aabb"));          // Output: -1
    }
}
