package binarytree;
import tools.*;

public class MaxPathSumBinaryTreeII {
  public int maxPathSum(TreeNode<Integer> root) {
    
    int[] max = {Integer.MIN_VALUE};
    int possibleMax = getCurMax(root, max);
    return Math.max(max[0], possibleMax);
  }
  
  private int getCurMax(TreeNode<Integer> node, int[] max) {

    if (node == null) {
      return 0;
    }

    int leftMax = getCurMax(node.left, max); 
    int rightMax = getCurMax(node.right, max);

    leftMax = Math.max(leftMax, 0);
    rightMax = Math.max(rightMax, 0);

    int curMax = leftMax + rightMax + node.key;
    max[0] = Math.max(max[0], curMax);

    return Math.max(leftMax, rightMax) + node.key;
  }
}
