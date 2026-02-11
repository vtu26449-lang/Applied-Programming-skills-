import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Map to store the next greater element for each number in nums2
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        // Stack to help find next greater elements
        Stack<Integer> stack = new Stack<>();

        // Traverse nums2 to fill the map
        for (int num : nums2) {
            while (!stack.isEmpty() && stack.peek() < num) {
                nextGreaterMap.put(stack.pop(), num);
            }
            stack.push(num);
        }

        // For remaining elements in stack, no next greater element exists
        while (!stack.isEmpty()) {
            nextGreaterMap.put(stack.pop(), -1);
        }

        // Build the result for nums1 using the map
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterMap.get(nums1[i]);
        }

        return result;
    }

    // Optional: main method for local testing
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(sol.nextGreaterElement(nums1, nums2)));
        // Output: [-1, 3, -1]

        int[] nums3 = {2, 4};
        int[] nums4 = {1, 2, 3, 4};
        System.out.println(Arrays.toString(sol.nextGreaterElement(nums3, nums4)));
        // Output: [3, -1]
    }
}

