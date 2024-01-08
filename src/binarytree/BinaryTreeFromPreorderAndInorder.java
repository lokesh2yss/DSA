package binarytree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeFromPreorderAndInorder {
    public static TreeNode buildTree(List<Integer> preorder, List<Integer> inorder) {
        if(preorder.size() == 0) return null;
        //take the first element of preorder as root of the tree
        int rootVal = preorder.get(0);
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
        List<Integer> leftPreOrder = new ArrayList<>();
        List<Integer> rightPreOrder = new ArrayList<>();
        for(int j=1; j<leftInOrderSize+1;j++) { //first element is root
            leftPreOrder.add(preorder.get(j));
        }
        for(int j= leftInOrderSize+1; j<preorder.size();j++) {
            rightPreOrder.add(preorder.get(j));
        }
        root.left = buildTree(leftPreOrder, leftInOrder);
        root.right = buildTree(rightPreOrder, rightInOrder);
        return root;
    }
}
