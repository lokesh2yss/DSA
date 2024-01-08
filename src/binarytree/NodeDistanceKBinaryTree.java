package binarytree;

import java.util.*;

public class NodeDistanceKBinaryTree {
    public static List<Integer> distanceK(TreeNode root, int target, int k) {
        Map<TreeNode, TreeNode> parentsMap = new HashMap<>();

        TreeNode t = assignParents(root, parentsMap, target);
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        q.offer(t);
        visited.put(t, true);
        int curDist = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            if(curDist == k) break;
            curDist++;
            for(int i=0;i<size;i++) {
                TreeNode cur = q.poll();
                if(cur.left != null && visited.get(cur.left) == null) {
                    visited.put(cur.left, true);
                    q.offer(cur.left);
                }
                if(cur.right != null && visited.get(cur.right) == null) {
                    visited.put(cur.right, true);
                    q.offer(cur.right);
                }
                if(parentsMap.get(cur) != null && visited.get(parentsMap.get(cur)) == null) {
                    visited.put(parentsMap.get(cur), true);
                    q.offer(parentsMap.get(cur));
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()) {
            ans.add(q.poll().val);
        }
        Collections.sort(ans);
        return ans;

    }
    public static TreeNode assignParents(TreeNode root, Map<TreeNode, TreeNode> parentsMap, int target) {
        TreeNode t = null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode cur = q.poll();
            if(target == cur.val) {
                t = cur;
            }
            if(cur.left != null) {
                parentsMap.put(cur.left, cur);
                q.offer(cur.left);
            }
            if(cur.right != null) {
                parentsMap.put(cur.right, cur);
                q.offer(cur.right);
            }
        }
        return t;
    }
}
