package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagOrderLevelTraversal {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        boolean flag = true;
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> tmp = new ArrayList<>();
            for(int i=0;i<size;i++) {
                TreeNode cur = null;
                cur = q.poll();
                if(flag) {
                    tmp.add(cur.val);
                }
                else {
                    tmp.add(0,cur.val);
                }
                if(cur.left != null ) {
                    q.offer(cur.left);
                }
                if(cur.right != null) {
                    q.offer(cur.right);
                }
            }
            ans.add(tmp);
            flag = !flag;
        }
        return ans;
    }
}
