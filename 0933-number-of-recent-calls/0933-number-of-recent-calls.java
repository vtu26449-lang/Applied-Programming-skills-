import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    private Queue<Integer> queue;

    // Initializes the counter with zero recent requests
    public RecentCounter() {
        queue = new LinkedList<>();
    }

    // Adds a new request at time t and returns the number of requests
    // that happened in the past 3000 milliseconds (inclusive)
    public int ping(int t) {
        queue.offer(t);

        // Remove requests older than t - 3000
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }

        return queue.size();
    }
}

// Demonstration
public class Main {
    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();

        System.out.println(recentCounter.ping(1));     // Output: 1
        System.out.println(recentCounter.ping(100));   // Output: 2
        System.out.println(recentCounter.ping(3001));  // Output: 3
        System.out.println(recentCounter.ping(3002));  // Output: 3
    }
}