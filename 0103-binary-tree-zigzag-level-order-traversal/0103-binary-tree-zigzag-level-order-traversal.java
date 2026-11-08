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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) return list;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int flag = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            flag %= 2;
            List<Integer> arr = new ArrayList<>();
            
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                arr.add(temp.val);

                if (temp.left != null) 
                    q.offer(temp.left);
                

                if (temp.right != null) 
                    q.offer(temp.right);
                
            }

            if (flag != 0) 
                Collections.reverse(arr);
            
            flag += 1;
            list.add(arr);
        }

        return list;
    }
}