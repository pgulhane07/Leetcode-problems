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
    class Pair{
        TreeNode node;
        int depth;
        Pair(TreeNode t, int d){
            node=t;
            depth=d;
        }
    }
    
    public Pair rec(TreeNode root){
        // TreeNode res=  new TreeNode();;
        if(root == null)return new Pair(null,0);

        Pair left = rec(root.left);

        Pair right= rec(root.right);

        if(left.depth == right.depth){
            return new Pair(root, left.depth+1);
        }
        else if(left.depth >right.depth){
            return new Pair(left.node, left.depth+1);
        }
        else{
            return new Pair(right.node, right.depth+1);
        }




    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        // res= new TreeNode();
        return rec(root).node;

        // Deque<TreeNode> dq= new ArrayDeque<>();
        // HashMap<Integer, List<TreeNode>> map= new HashMap<>();
        // HashMap<TreeNode, TreeNode> parent= new HashMap<>();
        // map.put(0, new ArrayList<>());
        // map.get(0).add(root);
        // dq.add(root);
        // parent.put(root, null);
        // int depth=0;
        // while(!dq.isEmpty()){
        //     depth++;
        //     map.put(depth, new ArrayList<>());
        //     int len= dq.size();
        //     for(int i=0;i<len;i++){
        //         TreeNode x= dq.poll();
            
        //         if(x.left!=null){
        //             dq.add(x.left);
        //             parent.put(x.left,x);
        //             map.get(depth).add(x.left);
        //         }
        //         if(x.right!=null){
        //             dq.add(x.right);
        //             parent.put(x.right,x);
        //             map.get(depth).add(x.right);
        //         }

        //     }
        // }

        // // if(map.get(depth).size()<2)return 
        // // for(int k:map.keySet()){
        // //     List<TreeNode> d= map.get(k);
        // //     for(TreeNode a: d)
        // //         System.out.print(a.val+" ");
        // //     System.out.println();
        // // }
        // // System.out.println();
        // List<TreeNode> deep= map.get(depth-1);
        // //  System.out.println("-----");
        // // for(TreeNode a: deep)
        // //         System.out.print(a.val+" ");
        // // System.out.println();
        // Set<TreeNode> trav= new HashSet<>(deep);
        // if(deep.size()==1)return deep.get(0);
        // while(trav.size() > 1){
        //     Set<TreeNode> temp= new HashSet<>();
        //     //TreeNode par= temp.get(0);
        //     for(TreeNode s:deep){
        //         // if(parent.get(s).val == par.val){

        //         // }
        //         temp.add(parent.get(s));
        //     }
        //     trav = new HashSet<>(temp);
        // }
        // TreeNode res= new TreeNode();
        // for(TreeNode n:trav){
        //     res=n;
        // }
        // return res;
    }
}