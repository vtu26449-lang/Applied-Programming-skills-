import java.util.*;

class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        findPaths(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    // Helper function
    public void findPaths(TreeNode root, int sum, List<Integer> path, List<List<Integer>> result) {
        if (root == null)
            return;

        path.add(root.val); // add current node

        // Check if leaf node and sum matches
        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new ArrayList<>(path)); // store path
        } else {
            findPaths(root.left, sum - root.val, path, result);
            findPaths(root.right, sum - root.val, path, result);
        }

        path.remove(path.size() - 1); // backtrack
    }
}