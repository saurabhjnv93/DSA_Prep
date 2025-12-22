package BinaryTree;

import java.util.*;
class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode curr = root;
        // st.push(root);
        while(curr!=null || !st.isEmpty()){
            while(curr!=null){
                st.push(curr);
                curr=curr.left;
            }
            curr = st.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }
}