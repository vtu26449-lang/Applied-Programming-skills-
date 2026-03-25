import java.util.*;

class Solution {

    // Main function expected by driver
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    // Helper function
    public void inorder(TreeNode root, List<Integer> result) {
        if (root == null)
            return;

        inorder(root.left, result);   // Left
        result.add(root.val);         // Root
        inorder(root.right, result);  // Right
    }
}