import java.util.*;

class Solution {

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // column -> row -> values
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map
            = new TreeMap<>();

        // Queue stores: node, row, column
        Queue<int[]> queue = new LinkedList<>();

        // Separate map to store TreeNode using an ID
        Map<Integer, TreeNode> nodes = new HashMap<>();

        if (root == null) {
            return new ArrayList<>();
        }

        int id = 0;
        nodes.put(id, root);
        queue.offer(new int[]{id, 0, 0});

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int nodeId = current[0];
            int row = current[1];
            int col = current[2];

            TreeNode node = nodes.get(nodeId);

            // Create column and row if needed
            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());

            // Add node value
            map.get(col).get(row).offer(node.val);

            // Left child
            if (node.left != null) {
                nodes.put(++id, node.left);
                queue.offer(new int[]{id, row + 1, col - 1});
            }

            // Right child
            if (node.right != null) {
                nodes.put(++id, node.right);
                queue.offer(new int[]{id, row + 1, col + 1});
            }
        }

        // Create final answer
        List<List<Integer>> result = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {

            List<Integer> column = new ArrayList<>();

            for (PriorityQueue<Integer> pq : rows.values()) {
                while (!pq.isEmpty()) {
                    column.add(pq.poll());
                }
            }

            result.add(column);
        }

        return result;
    }
}