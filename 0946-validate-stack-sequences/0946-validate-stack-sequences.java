import java.util.*;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0; // pointer for popped array

        for (int x : pushed) {
            stack.push(x);

            // keep popping while top of stack equals popped[j]
            while (!stack.isEmpty() && j < popped.length && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            }
        }

        // if all elements in popped are matched, return true
        return j == popped.length;
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] pushed1 = {1,2,3,4,5};
        int[] popped1 = {4,5,3,2,1};
        System.out.println(sol.validateStackSequences(pushed1, popped1)); // true

        int[] pushed2 = {1,2,3,4,5};
        int[] popped2 = {4,3,5,1,2};
        System.out.println(sol.validateStackSequences(pushed2, popped2)); // false
    }
}
