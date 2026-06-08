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
    public TreeNode dfs(int parent){
        TreeNode root= new TreeNode(parent);
        
        if(map.containsKey(parent)){
            TreeNode p= map.get(parent);
            if(p.left != null){
                root.left = dfs(p.left.val);
            }
            if(p.right != null){
                root.right = dfs(p.right.val);
            }

        }
        return root;
    }
    HashMap<Integer, TreeNode> map;
    public TreeNode createBinaryTree(int[][] descriptions) {
        map = new HashMap<>();
        Set<Integer> isChild= new HashSet();
        for(int[] d: descriptions){
            int parent= d[0];
            int child = d[1];
            isChild.add(child);
            System.out.println(d[2]);
            if(map.containsKey(parent)){
                TreeNode p = map.get(parent);
                TreeNode c = new TreeNode(child);
                if(map.containsKey(child)){
                    c = map.get(child);
                }
                // else{
                //     TreeNode c = new TreeNode(child);
                // }
                    
                
                if(d[2] == 1){
                //    System.out.println("left");
                    p.left= c;
                }
                else{
                    p.right= c;
                   // System.out.println("right");
                }
                map.put(parent,p);
            }
            else{
                TreeNode p = new TreeNode(parent);
                TreeNode c = new TreeNode(child);
                if(map.containsKey(child)){
                    c = map.get(child);
                }
                if(d[2] == 1){
                    p.left= c;
                   // System.out.println("left else");
                }
                else{
                    p.right= c;
                   // System.out.println("rigth else");
                }
                map.put(parent,p);
            }

            // for(int n:map.keySet()){
            //     int l=-1,r=-1;
            //     if(map.get(n).left != null){
            //         l= map.get(n).left.val;
            //     }
            //     if(map.get(n).right != null){
            //         r= map.get(n).right.val;
            //     }
            //     System.out.println(n+" -->"+l+ " "+r);
            // }
            // System.out.println("---=-=-=-=");
        }
        for(int n:map.keySet()){
            if(!isChild.contains(n)){
              return dfs(n);   
            }
        }
        return null;

    }
}