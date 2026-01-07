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
    public int maxLevelSum(TreeNode root) {
        if(root == null)return 0;
        Deque<TreeNode> dq= new ArrayDeque<>();
        dq.add(root);
        int max= Integer.MIN_VALUE;
        int index=1, res=1;

        while(!dq.isEmpty()){
            int len= dq.size();
            int sum = 0;
            for(int i=0;i< len;i++){
                TreeNode temp= dq.poll();
                sum+= temp.val;
                if(temp.left != null){
                    dq.add(temp.left);
                }
                if(temp.right!= null){
                    dq.add(temp.right);
                }
            }
            if(sum > max){
                res = index;
                max= sum; 
            }
            index++;
        }
        return res;
    }
}