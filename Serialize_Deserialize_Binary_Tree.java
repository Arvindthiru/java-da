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
    public String serialize(TreeNode root) {
        if(root == null)
        {
            return "";
        }
        StringBuilder str = new StringBuilder();
        if(root!=null)
        {
           serializeTree(str,root);
        }
        return str.toString();
    }
    
    // Serializes the Tree into a List.
    public void serializeTree(StringBuilder str, TreeNode root) {
        if(root==null)
        {
            str.append("X,");
            return;
        }
        else
        {   
            str.append(root.val+",");
            serializeTree(str,root.left);
            serializeTree(str,root.right);
        }
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //System.out.println(data);
        if(data.length() == 0)
        {
            return null;
        }
        String[] sElems = data.split(",");
        Queue<String> qElems = new LinkedList<>();
        for(String elem : sElems)
        {
            qElems.add(elem);
        }
        TreeNode root=deserializeTree(qElems,qElems.poll());
        return root;
    }
    
    // Deserialize Tree from list of Strings. 
    public TreeNode deserializeTree(Queue<String> elems,String elem){
        if(elem.compareTo("X") == 0)
        {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(elem));
        root.left = deserializeTree(elems,elems.poll());
        root.right = deserializeTree(elems,elems.poll());
        return root;
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
