class Solution {

    static class Node {
        TreeNode node;
        int row;
        int col;

        Node(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        // column -> nodes
        TreeMap<Integer, List<Node>> map = new TreeMap<>();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 0, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            map.putIfAbsent(current.col, new ArrayList<>());
            map.get(current.col).add(current);

            if (current.node.left != null) {
                queue.offer(new Node(
                    current.node.left,
                    current.row + 1,
                    current.col - 1
                ));
            }

            if (current.node.right != null) {
                queue.offer(new Node(
                    current.node.right,
                    current.row + 1,
                    current.col + 1
                ));
            }
        }

        // Process columns from left to right
        for (List<Node> nodes : map.values()) {

            // Sort by row, then by value
            nodes.sort((a, b) -> {
                if (a.row != b.row) {
                    return Integer.compare(a.row, b.row);
                }
                return Integer.compare(a.node.val, b.node.val);
            });

            List<Integer> column = new ArrayList<>();

            for (Node n : nodes) {
                column.add(n.node.val);
            }

            result.add(column);
        }

        return result;
    }
}