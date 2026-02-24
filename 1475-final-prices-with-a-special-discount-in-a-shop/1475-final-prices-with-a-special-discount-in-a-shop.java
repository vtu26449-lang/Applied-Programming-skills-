import java.util.*;

class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>(); // stores indices

        for (int i = 0; i < n; i++) {
            // While current price is less than or equal to the price at stack top
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int idx = stack.pop();
                answer[idx] = prices[idx] - prices[i]; // apply discount
            }
            stack.push(i);
            answer[i] = prices[i]; // default price (no discount yet)
        }

        // Remaining indices in stack have no discount → already set to original price
        return answer;
    }

    // Example usage
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] prices1 = {8,4,6,2,3};
        System.out.println(Arrays.toString(sol.finalPrices(prices1)));
        // Output: [4,2,4,2,3]

        int[] prices2 = {1,2,3,4,5};
        System.out.println(Arrays.toString(sol.finalPrices(prices2)));
        // Output: [1,2,3,4,5]

        int[] prices3 = {10,1,1,6};
        System.out.println(Arrays.toString(sol.finalPrices(prices3)));
        // Output: [9,0,1,6]
    }
}
