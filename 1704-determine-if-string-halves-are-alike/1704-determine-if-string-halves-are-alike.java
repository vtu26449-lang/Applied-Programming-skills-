public class Solution {
    public boolean halvesAreAlike(String s) {
        // Define all vowels in a string for easy checking
        String vowels = "aeiouAEIOU";
        int n = s.length();
        int countA = 0, countB = 0;

        // Split the string into two halves
        String a = s.substring(0, n / 2);
        String b = s.substring(n / 2);

        // Count vowels in first half
        for (char ch : a.toCharArray()) {
            if (vowels.indexOf(ch) != -1) {
                countA++;
            }
        }

        // Count vowels in second half
        for (char ch : b.toCharArray()) {
            if (vowels.indexOf(ch) != -1) {
                countB++;
            }
        }

        // Check if both halves have same number of vowels
        return countA == countB;
    }

    // Main method to test
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.halvesAreAlike("book"));       // true
        System.out.println(sol.halvesAreAlike("textbook"));   // false
    }
}