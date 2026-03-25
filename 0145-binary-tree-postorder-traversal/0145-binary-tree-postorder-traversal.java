import java.util.*;

class Solution {

    // Function expected by driver
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    // Helper function
    public void postorder(TreeNode root, List<Integer> result) {
        if (root == null)
            return;

        postorder(root.left, result);   // Left
        postorder(root.right, result);  // Right
        result.add(root.val);           // Root
    }
}