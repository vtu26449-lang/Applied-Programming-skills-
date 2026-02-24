import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // Push opening brackets
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // If stack is empty, no matching opening bracket
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                // Check if the closing bracket matches the opening one
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // Valid only if no unmatched opening brackets remain
        return stack.isEmpty();
    }

    // Example usage
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.isValid("()"));      // true
        System.out.println(sol.isValid("()[]{}"));  // true
        System.out.println(sol.isValid("(]"));      // false
        System.out.println(sol.isValid("([])"));    // true
        System.out.println(sol.isValid("([)]"));    // false
    }
}
