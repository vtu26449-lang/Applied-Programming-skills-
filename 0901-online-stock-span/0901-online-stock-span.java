import java.util.*;

class StockSpanner {
    // Stack stores pairs: [price, span]
    private Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1; // at least today counts
        // Merge spans of previous days with prices <= current price
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        // Push current price and its span
        stack.push(new int[]{price, span});
        return span;
    }

    // Example usage
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100)); // 1
        System.out.println(stockSpanner.next(80));  // 1
        System.out.println(stockSpanner.next(60));  // 1
        System.out.println(stockSpanner.next(70));  // 2
        System.out.println(stockSpanner.next(60));  // 1
        System.out.println(stockSpanner.next(75));  // 4
        System.out.println(stockSpanner.next(85));  // 6
    }
}
