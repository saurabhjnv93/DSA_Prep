package BinaryTree;

public class DeleteNodeInBST {
     public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)return root;
        if(root.val > key){
            root.left = deleteNode(root.left,key);
        }
        else if(root.val < key){
            root.right = deleteNode(root.right,key);
        }
        else{
            if(root.left == null || root.right == null){
                return (root.left == null)? root.right:root.left;
            }
            else{
                TreeNode maxNode = findMax(root.left);
                root.left = deleteNode(root.left,maxNode.val);
                maxNode.left = root.left;
                maxNode.right = root.right;
                return maxNode;
            }
        }
        return root;
    }
    private TreeNode findMax(TreeNode node){
        while(node.right != null){
            node = node.right;
        }
        return node;
    }
}
