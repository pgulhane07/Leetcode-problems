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
    private boolean res= true;
    public int backtrack(TreeNode root){
        //base case
        if(root==null)return 0;

        int left= backtrack(root.left)+1;
        int right= backtrack(root.right)+1;

        if(Math.abs(right-left) > 1 )res= false;
        return Math.max(left, right);

    }
    public boolean isBalanced(TreeNode root) {
        backtrack(root);
        return res;
    }
}