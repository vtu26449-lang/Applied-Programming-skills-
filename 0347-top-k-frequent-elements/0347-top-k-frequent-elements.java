import java.util.*;

class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        // Count frequency
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        // Min heap based on frequency
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );

        for (int key : map.keySet()) {
            pq.add(key);
            if (pq.size() > k)
                pq.poll();
        }

        // Build result
        int[] result = new int[k];
        int i = 0;

        while (!pq.isEmpty()) {
            result[i++] = pq.poll();
        }

        return result;
    }
}