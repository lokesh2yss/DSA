package binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeFromInorderAndPostorder {
    public static TreeNode buildTree(List<Integer> inorder, List<Integer> postorder) {
        if(postorder.size() == 0) return null;
        //take the last element of preorder as root of the tree
        int rootVal = postorder.get(postorder.size()-1);
        TreeNode root = new TreeNode(rootVal);
        List<Integer> leftInOrder = new ArrayList<>();
        List<Integer> rightInOrder = new ArrayList<>();
        int i = 0;
        for(;i<inorder.size(); i++) {
            if(inorder.get(i)==rootVal) break;
            leftInOrder.add(inorder.get(i));
        }
        int leftInOrderSize = i;
        i++;
        for(;i<inorder.size(); i++) {
            rightInOrder.add(inorder.get(i));
        }
        List<Integer> leftPostOrder = new ArrayList<>();
        List<Integer> rightPostOrder = new ArrayList<>();
        for(int j=0; j<leftInOrderSize;j++) { //first element is root
            leftPostOrder.add(postorder.get(j));
        }
        for(int j= leftInOrderSize; j<postorder.size()-1;j++) {
            rightPostOrder.add(postorder.get(j));
        }
        root.left = buildTree(leftInOrder, leftPostOrder);
        root.right = buildTree(rightInOrder, rightPostOrder);
        return root;
    }
}
