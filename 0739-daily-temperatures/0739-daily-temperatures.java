import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>(); // stores indices of days

        for (int i = 0; i < n; i++) {
            // While current temperature is greater than the temperature at stack top
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevDay = stack.pop();
                answer[prevDay] = i - prevDay; // number of days waited
            }
            stack.push(i); // push current day's index
        }

        // Remaining indices in stack have no warmer future day → answer stays 0
        return answer;
    }

    // Example usage
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] temperatures1 = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(sol.dailyTemperatures(temperatures1)));
        // Output: [1,1,4,2,1,1,0,0]

        int[] temperatures2 = {30,40,50,60};
        System.out.println(Arrays.toString(sol.dailyTemperatures(temperatures2)));
        // Output: [1,1,1,0]

        int[] temperatures3 = {30,60,90};
        System.out.println(Arrays.toString(sol.dailyTemperatures(temperatures3)));
        // Output: [1,1,0]
    }
}
