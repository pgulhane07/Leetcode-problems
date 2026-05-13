/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public void encode(TreeNode root, StringBuilder sb){
        if(root == null){
            // sb.append("?");
            // sb.append("#");
            return;
        }
        sb.append(root.val);
        sb.append("#");
        if(root.left==null){
            sb.append("?");
            sb.append("#");
        }
        else{
            encode(root.left, sb);
        }
       if(root.right==null){
            sb.append("?");
            sb.append("#");
        }
        else{
            encode(root.right, sb);
        }
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb= new StringBuilder();
        encode(root, sb);
       // System.out.println(sb.toString());
        return sb.toString();
        
    }
    int k;
    public TreeNode decode(String[] data, int i){
        TreeNode root= new TreeNode();
        if(k==data.length-1)return null;
        if(!data[i].equals("?")){
            root.val = Integer.valueOf(data[i]);
        }
        else{
            return null;
        }
        k++;
        root.left = decode(data, k );
        k++;
        root.right = decode(data, k);
        return root;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr= data.split("#");
        k=0;
        // for(String s:arr){
        //     System.out.println(s);
        // }
        return decode(arr, 0);

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));