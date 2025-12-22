package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()){
            int s = q.size();

            List<Integer> temp = new ArrayList<>();

            for(int i=0;i<s;i++){
                TreeNode  nd = q.poll();
                temp.add(nd.val);
                if(nd.left != null){
                    q.offer(nd.left);
                }
                if(nd.right != null){
                    q.offer(nd.right);
                }
            }
            res.add(temp);
        }
        return res;
        
    }
}
