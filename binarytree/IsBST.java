package binarytree;
import tools.*;

class IsBST {

    public boolean isBST(TreeNode<Integer> root) {
        // Write your solution here
        int lower = Integer.MIN_VALUE;
        int upper = Integer.MAX_VALUE;
        return helper(root, lower, upper);
    }
    
    private boolean helper(TreeNode<Integer> node, int lower, int upper) {
        if (node == null) {
            return true;
        }

        // validate the node value
        if (node.key <= lower || node.key >= upper) {
            return false;
        }

        return helper(node.left, lower, node.key) && helper(node.right, node.key, upper);
    }
}