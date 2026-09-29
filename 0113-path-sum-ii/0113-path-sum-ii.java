class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(root, targetSum, path, result);

        return result;
    }

    private void dfs(TreeNode node, int targetSum,
                     List<Integer> path,
                     List<List<Integer>> result) {

        if (node == null) {
            return;
        }

        // Add current node to path
        path.add(node.val);

        // Check if current node is a leaf
        if (node.left == null && node.right == null) {
            if (node.val == targetSum) {
                result.add(new ArrayList<>(path));
            }
        } else {
            // Continue searching
            dfs(node.left, targetSum - node.val, path, result);
            dfs(node.right, targetSum - node.val, path, result);
        }

        // Backtrack
        path.remove(path.size() - 1);
    }
}
