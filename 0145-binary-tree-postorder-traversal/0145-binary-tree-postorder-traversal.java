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
     static List<Integer> preOrder(TreeNode node,List<Integer> arrayList){
    if(node != null){
      preOrder(node.left, arrayList);
      preOrder(node.right, arrayList);
      arrayList.add(node.val);
    }
    return arrayList;
  }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return preOrder(root,list);
    }
}