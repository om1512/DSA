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
      arrayList.add(node.val);
      preOrder(node.left, arrayList);
      preOrder(node.right, arrayList);
    }
    return arrayList;
  }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return preOrder(root,list);
    }
}