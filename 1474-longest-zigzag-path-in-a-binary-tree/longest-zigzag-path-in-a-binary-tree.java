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
    int max=0;
    public void backtrack(TreeNode root, boolean isLeft, int step){
        if(root== null)return;
        max = Math.max(max, step);
        if(isLeft ){
            
            backtrack(root.left, !isLeft, step+1 );
            backtrack(root.right, isLeft, 1 );
            // else{
            //     return 1;
            // }
            // m = Math.max(m, x);
        }
        else{
            // if(root.right!= null)
             backtrack(root.right, !isLeft,step+1);
             backtrack(root.left, isLeft,1);
            //  else{
            //     return 1;
            // }
        }
        // max= Math.max(max, m);
       // return m;

    }

    public int longestZigZag(TreeNode root) {
        if(root== null)return 0;
        backtrack(root, true,0);
        //backtrack(root, false,0);
        return max;
    }
}