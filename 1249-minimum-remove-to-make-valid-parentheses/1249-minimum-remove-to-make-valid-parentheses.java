class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int openCount = 0;

        // First pass: remove invalid ')'
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                openCount++;
                sb.append(ch);
            } else if (ch == ')') {
                if (openCount > 0) {
                    openCount--;
                    sb.append(ch);
                }
                // else skip this ')'
            } else {
                sb.append(ch);
            }
        }

        // Second pass: remove extra '('
        StringBuilder result = new StringBuilder();
        int openToRemove = openCount;
        for (int i = sb.length() - 1; i >= 0; i--) {
            char ch = sb.charAt(i);
            if (ch == '(' && openToRemove > 0) {
                openToRemove--;
                // skip this '('
            } else {
                result.append(ch);
            }
        }

        return result.reverse().toString();
    }
}
