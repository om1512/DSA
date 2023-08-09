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
    static int height(TreeNode node,int[] arr){
        if(node == null) return 0;
        int leftSum = 0,rightSum = 0;
        if(node.left != null) 
            leftSum = height(node.left,arr);
        if(node.right != null) 
            rightSum = height(node.right,arr);
        arr[0] = Integer.max(arr[0],leftSum + rightSum);
        return Integer.max(leftSum,rightSum) + 1;
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        int[] arr = new int[1];
        arr[0] = 0;
        height(root,arr);
        return arr[0];
    }
}