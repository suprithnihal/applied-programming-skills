class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> nodes = new ArrayList<>();

        // {node, row, col}
        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{root, 0, 0});

        while (!queue.isEmpty()) {
            Object[] curr = queue.poll();

            TreeNode node = (TreeNode) curr[0];
            int row = (int) curr[1];
            int col = (int) curr[2];

            // Store {column, row, value}
            nodes.add(new int[]{col, row, node.val});

            if (node.left != null) {
                queue.offer(new Object[]{
                    node.left, row + 1, col - 1
                });
            }

            if (node.right != null) {
                queue.offer(new Object[]{
                    node.right, row + 1, col + 1
                });
            }
        }

        // Sort by column, then row, then value
        nodes.sort((a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);

            if (a[1] != b[1])
                return Integer.compare(a[1], b[1]);

            return Integer.compare(a[2], b[2]);
        });

        List<List<Integer>> result = new ArrayList<>();

        int currentColumn = Integer.MIN_VALUE;

        for (int[] node : nodes) {
            int col = node[0];
            int value = node[2];

            if (col != currentColumn) {
                result.add(new ArrayList<>());
                currentColumn = col;
            }

            result.get(result.size() - 1).add(value);
        }

        return result;
    }
}
