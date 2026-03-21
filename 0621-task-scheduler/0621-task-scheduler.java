import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Count frequency of each task
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Find the maximum frequency
        int maxFreq = 0;
        for (int f : freq) {
            maxFreq = Math.max(maxFreq, f);
        }

        // Count how many tasks have this maximum frequency
        int maxCount = 0;
        for (int f : freq) {
            if (f == maxFreq) {
                maxCount++;
            }
        }

        // Formula:
        // (maxFreq - 1) * (n + 1) + maxCount
        // This gives the minimum length required to schedule tasks with cooling
        int partCount = maxFreq - 1;
        int partLength = n + 1;
        int emptySlots = partCount * partLength + maxCount;

        // The result is the maximum between total tasks and calculated slots
        return Math.max(tasks.length, emptySlots);
    }
}

// Demonstration
public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        char[] tasks1 = {'A','A','A','B','B','B'};
        System.out.println(sol.leastInterval(tasks1, 2)); // Output: 8

        char[] tasks2 = {'A','C','A','B','D','B'};
        System.out.println(sol.leastInterval(tasks2, 1)); // Output: 6

        char[] tasks3 = {'A','A','A','B','B','B'};
        System.out.println(sol.leastInterval(tasks3, 3)); // Output: 10
    }
}