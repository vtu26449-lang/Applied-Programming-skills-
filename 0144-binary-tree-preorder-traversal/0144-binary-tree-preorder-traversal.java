import java.util.*;

class Solution {

    // Function expected by driver
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    // Helper function
    public void preorder(TreeNode root, List<Integer> result) {
        if (root == null)
            return;

        result.add(root.val);         // Root
        preorder(root.left, result);  // Left
        preorder(root.right, result); // Right
    }
}