/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> l1 = new ArrayList<>();
        rootToNodePath(root, p, l1);

        List<TreeNode> l2 = new ArrayList<>();
        rootToNodePath(root, q, l2);

        TreeNode ans = null;
        for (int i = 0; i < Math.min(l1.size(), l2.size()); i++) {
            if (l1.get(i) == l2.get(i)) ans = l1.get(i);
        }

        return ans;
    }
    
    public boolean rootToNodePath(TreeNode root, TreeNode node, List<TreeNode> list) {
        if (root == null) {
            return false;
        }

        list.add(root);
        
        if (root == node) {
            return true;
        }

        if (rootToNodePath(root.left, node, list) == true || rootToNodePath(root.right, node, list) == true) {
            return true;
        }

        list.remove(list.size() - 1);
        return false;
    }
}