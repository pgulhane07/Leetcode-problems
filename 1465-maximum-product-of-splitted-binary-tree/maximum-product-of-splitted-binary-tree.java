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
    long max=0;
    private final int mod= 1000000007; 
    public long dfs(TreeNode root, long sum){

        if(root == null)return 0;
        long lval=0, rval=0;
        if(root.left!=null){
            lval =  dfs(root.left, sum);
            // long prod= lval * (sum-lval);
            max= Math.max(lval * (long)(sum-lval), max);
          //  max= max%mod;
           // System.out.println(lval+" "+max+" "+prod);
        }

        if(root.right!=null){
            rval =  dfs(root.right, sum);
            // int prod= rval * (sum-rval);
            max= Math.max(rval * (long)(sum-rval), max);
            //max= max%mod;
           // System.out.println(rval+"  in2in "+max+" "+prod);
        }
        //int rootval=0;
        // if(root.left == null && root.right == null){
        //     lval = root.val;
        // }
       // System.out.println(lval+" out "+max);

        return lval+rval+root.val;

    }

    public int maxProduct(TreeNode root) {
        if(root==null)return 0;

        ArrayDeque<TreeNode> dq= new ArrayDeque<>();
        dq.add(root);
        long sum= 0;
        while(!dq.isEmpty()){
            TreeNode x=dq.poll(); 
            sum+= x.val;

            if(x.left!=null)dq.add(x.left);
            if(x.right!=null)dq.add(x.right);
        }
       // System.out.println(sum);
        dfs(root, sum);
        return (int)(max % 1000000007);
    }
}