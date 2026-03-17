import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int asteroid : asteroids) {
            boolean destroyed = false;

            // Collision happens only if current asteroid moves left (<0)
            // and stack top moves right (>0)
            while (!stack.isEmpty() && asteroid < 0 && stack.peek() > 0) {
                int top = stack.peek();

                if (Math.abs(asteroid) > top) {
                    // Top asteroid explodes, continue checking
                    stack.pop();
                    continue;
                } else if (Math.abs(asteroid) == top) {
                    // Both explode
                    stack.pop();
                }
                // Current asteroid destroyed
                destroyed = true;
                break;
            }

            if (!destroyed) {
                stack.push(asteroid);
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
