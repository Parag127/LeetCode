/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) return new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<TreeNode>>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0, 0));

        while (!q.isEmpty()) {
            Pair p = q.poll();
            int col = p.col;
            int row = p.row;
            TreeNode node = p.node;

            if (!map.containsKey(col)) {
                map.put(col, new TreeMap<>());
            }

            if (!map.get(col).containsKey(row)) {
                map.get(col).put(row, new PriorityQueue<>(
                    (a, b) -> Integer.compare(a.val, b.val)
                ));
            }

            map.get(col).get(row).offer(node);
            
            if (node.left != null) {
                q.offer(new Pair (node.left, col - 1, row + 1));
            }

            if (node.right != null) {
                q.offer(new Pair (node.right, col + 1, row + 1));
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<TreeNode>> rowMap : map.values()) {
            List<Integer> res = new ArrayList<>();

            for (PriorityQueue<TreeNode> colMap : rowMap.values()) {
                while (!colMap.isEmpty()) {
                    res.add(colMap.poll().val);
                }
            }
            list.add(new ArrayList<>(res));
        }

        return list;
    }

    class Pair {
        TreeNode node;
        int col;
        int row;

        Pair (TreeNode node, int col, int row) {
            this.node = node;
            this.col = col;
            this.row = row;
        }
    }
}