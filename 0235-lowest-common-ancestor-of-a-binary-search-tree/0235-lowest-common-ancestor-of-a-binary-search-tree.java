class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                // Both nodes are in the left subtree
                root = root.left;
            } 
            else if (p.val > root.val && q.val > root.val) {
                // Both nodes are in the right subtree
                root = root.right;
            } 
            else {
                // They are on different sides, or root is p/q
                return root;
            }
        }

        return null;
    }
}
