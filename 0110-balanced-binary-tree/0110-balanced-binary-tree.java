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

    static int hight(TreeNode root){
        if(root == null) return 0;
        int leftHeight = 0,rightHeight = 0;
        if(root.left != null) leftHeight = hight(root.left); 
        if(root.right != null) rightHeight = hight(root.right);
        if(leftHeight == -1 || rightHeight == -1) return -1;
        if(Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Integer.max(leftHeight,rightHeight)+1;
    }
    public boolean isBalanced(TreeNode root) {
        int h = hight(root);
        if(h == -1) return false;
        return true;
    }
}