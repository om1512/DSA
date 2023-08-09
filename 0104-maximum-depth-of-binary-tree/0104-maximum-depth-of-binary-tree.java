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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        else if(root.left == null && root.right == null) return 1;
        Queue<TreeNode> queue = new LinkedList<>();
        int count = 0;
        queue.add(root);
        while(!queue.isEmpty()){
            count++;
            int num = queue.size();
            for(int i=0;i<num;i++){
                if(queue.peek().left!=null)
                    queue.add(queue.peek().left);
                if(queue.peek().right!=null)
                    queue.add(queue.peek().right);
                queue.remove();
            } 
        }
        return count;
    }
}