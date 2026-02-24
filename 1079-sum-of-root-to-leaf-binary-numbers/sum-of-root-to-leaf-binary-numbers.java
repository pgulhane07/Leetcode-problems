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
    int total=0;
    public void backtrack(TreeNode root, List<Integer> val){

        if(root == null)return;
        val.add(root.val);
        if(root.right==null && root.left== null){
            int res=0, k=0;
          //  System.out.println(val);
            for(int i=val.size()-1;i>=0;i--){
                if( val.get(i)==1)
                    res= res+ (int)Math.pow(2,k);

                k++;
            }
           // System.out.println(res);
            val.remove(val.size()-1);
            total+=res;
            return;
        }

        if(root.left != null){
            backtrack(root.left, val);
        }
        if(root.right != null){
            backtrack(root.right, val);
        }
        val.remove(val.size()-1);

    }
    public int sumRootToLeaf(TreeNode root) {
        backtrack(root, new ArrayList<>());
        return total;
    }
}