class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode p, TreeNode q) {
        // Both nodes are null
        if (p == null && q == null) {
            return true;
        }

        // One node is null
        if (p == null || q == null) {
            return false;
        }

        // Values are different
        if (p.val != q.val) {
            return false;
        }

        // Compare opposite sides
        return isMirror(p.left, q.right)
            && isMirror(p.right, q.left);
    }
}