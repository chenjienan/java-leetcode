package binarytree;
import tools.*;

class SymmetricBinaryTree {

    public boolean isSymmetric(TreeNode<Integer> root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
        
    }

    private boolean helper(TreeNode<Integer> leftNode, TreeNode<Integer> rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        } else if (leftNode == null || rightNode == null) {
            return false;
        } else if (leftNode.key != rightNode.key) {
            return false;
        }

        return helper(leftNode.left, rightNode.right) && helper(leftNode.right, rightNode.left);
    }
}