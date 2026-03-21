import java.util.*;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        
        int left = 0, result = 0;

        for (int right = 0; right < nums.length; right++) {

            // Maintain maxDeque (decreasing)
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[right]) {
                maxDeque.pollLast();
            }

            // Maintain minDeque (increasing)
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[right]) {
                minDeque.pollLast();
            }

            maxDeque.offer(right);
            minDeque.offer(right);

            // Shrink window if condition breaks
            while (nums[maxDeque.peek()] - nums[minDeque.peek()] > limit) {
                
                if (maxDeque.peek() == left) {
                    maxDeque.poll();
                }
                if (minDeque.peek() == left) {
                    minDeque.poll();
                }
                
                left++;
            }

            // Update result
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}