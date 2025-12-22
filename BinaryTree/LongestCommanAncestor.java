package BinaryTree;

public class LongestCommanAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int min = Math.min(p.val,q.val);
        int max = Math.max(p.val,q.val);
        while(root.val < min   || root.val > max ){
            if(root.val < min)root = root.right;
            if(root.val > max)root = root.left;
        }
        // while(root.val > max){
        //     root = root.left;
        // }
        if(root.val >= min || root.val <= max)return root;
        return null;
    }
}
