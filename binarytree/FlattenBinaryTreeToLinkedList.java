package binarytree;
import tools.*;

public class FlattenBinaryTreeToLinkedList {
  public TreeNode<Integer> flatten(TreeNode<Integer> root) {
    if (root == null) {
      return root;
    }

    TreeNode<Integer> flattenLeft = flatten(root.left);
    TreeNode<Integer> flattenRight = flatten(root.right);

    if (root.left != null) {
      TreeNode<Integer> rightMost = flattenLeft;
      while (rightMost.right != null) {
        rightMost = rightMost.right;
      }

      rightMost.right = flattenRight;
      root.right = flattenLeft;
      root.left = null;
    }
    return root;
  }
}
