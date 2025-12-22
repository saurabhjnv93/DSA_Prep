package BinaryTree;

public class InsertInBST {
     public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            TreeNode node = new TreeNode(val);
            return node;
        }
        
        if(root.val < val){
            root.right = insertIntoBST(root.right,val);
        }
        else{
            root.left = insertIntoBST(root.left,val);
        }
        return root;
    }
}
