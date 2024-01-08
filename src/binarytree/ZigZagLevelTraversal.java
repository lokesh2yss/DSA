package binarytree;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.val = data;
        left = null;
        right = null;
    }
}

public class ZigZagLevelTraversal {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(-70);
        TreeNode t2 = new TreeNode(-8);
        TreeNode t3 = new TreeNode(-65);
        TreeNode t4 = new TreeNode(-70);
        TreeNode t5 = new TreeNode(-14);
        TreeNode t6 = new TreeNode(96);
        TreeNode t7 = new TreeNode(4);
        TreeNode t8 = new TreeNode(40);
        TreeNode t9 = new TreeNode(-20);
        TreeNode t10 = new TreeNode(-8);
        TreeNode t11 = new TreeNode(-62);
        TreeNode t12 = new TreeNode(-79);
        TreeNode t13 = new TreeNode(-92);
        TreeNode t14 = new TreeNode(-39);
        TreeNode t15 = new TreeNode(-18);
        TreeNode t16 = new TreeNode(-54);
        TreeNode t17 = new TreeNode(-25);
        TreeNode t18 = new TreeNode(74);

        t1.left = t2;
        t2.left = t3;
        t2.right = t4;
        t3.left = t5;
        t3.right = t6;
        t4.right = t7;
        t5.left = t8;
        t5.right = t9;
        t6.left = t10;
        t7.left = t11;
        t7.right = t12;
        t9.left = t13;
        t9.right = t14;
        t10.left = t15;
        t11.left = t16;
        t11.right = t17;
        t12.left = t18;

        TreeNode root = t1;
        List<List<Integer>> ans = zigzagLevelOrder(root);
        System.out.println(ans);

    }
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        boolean flag = true;
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> tmp = new ArrayList<>();
            //System.out.print(size+" ");
            //System.out.println(q);
            for(int i=0;i<size;i++) {
                TreeNode cur = null;
                cur = q.poll();
                if(flag) {
                    tmp.add(cur.val);
                }
                else {
                    tmp.add(0,cur.val);
                }
                //System.out.print(cur.val+" ");
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
