import java.util.*;

class Solution {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        findPaths(root, "", result);
        return result;
    }

    // Helper function
    public void findPaths(TreeNode root, String path, List<String> result) {
        if (root == null)
            return;

        // If leaf node
        if (root.left == null && root.right == null) {
            result.add(path + root.val);
            return;
        }

        // Continue path
        findPaths(root.left, path + root.val + "->", result);
        findPaths(root.right, path + root.val + "->", result);
    }
}