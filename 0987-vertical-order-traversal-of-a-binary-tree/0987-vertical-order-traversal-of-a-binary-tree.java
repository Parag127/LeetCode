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

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<TreeNode>>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(0, 0, root));

        while (!q.isEmpty()) {
            int col = q.peek().col;
            int row = q.peek().row;
            TreeNode node = q.poll().node;

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
                q.offer(new Pair(col - 1, row + 1, node.left));
            }

            if (node.right != null) {
                q.offer(new Pair(col + 1, row + 1, node.right));
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<TreeNode>> rowMap : map.values()) {
            List<Integer> ans = new ArrayList<>();

            for (PriorityQueue<TreeNode> colMap : rowMap.values()) {
                while (!colMap.isEmpty())
                    ans.add(colMap.poll().val);
            }

            list.add(new ArrayList<>(ans));
        }

        return list;

    }

    class Pair {
        TreeNode node;
        int col;
        int row;

        Pair (int col, int row, TreeNode node) {
            this.node = node;
            this.col = col;
            this.row = row;
        }
    }
}