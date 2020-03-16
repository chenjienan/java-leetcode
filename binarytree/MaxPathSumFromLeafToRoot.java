package binarytree;
import tools.*;


public class MaxPathSumFromLeafToRoot {
  public int maxPathSumLeafToRoot(TreeNode<Integer> root) {
    if (root == null) {
      return 0;
    }
    
    int[] max = {Integer.MIN_VALUE};
    
    getPathSum(root, 0, max);
    return max[0];
  }

  private void getPathSum(TreeNode<Integer> node, int curSum, int[] max) {
    if (node == null) {
      return;
    }
    curSum += node.key;
    if (node.left == null && node.right == null) {
      max[0] = Math.max(max[0], curSum);
      return;
    }

    getPathSum(node.left, curSum, max);
    getPathSum(node.right, curSum, max);
  }
}
