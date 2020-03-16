package binarytree;
import tools.*;

public class MaxPathSumBinaryTreeIII {
  public int maxPathSum(TreeNode<Integer> root) {
    
    int[] globalMax = {Integer.MIN_VALUE};
    subpathSum(root, -1, globalMax);
    return globalMax[0];
  }

  public void subpathSum(TreeNode<Integer> node, int curSum, int[] globalMax) {

    if (node == null) {
      return;
    }

    if (curSum < 0) {
      curSum = node.key;
    } else {
      curSum += node.key;
    }
    globalMax[0] = Math.max(globalMax[0], curSum);

    subpathSum(node.left, curSum, globalMax);
    subpathSum(node.right, curSum, globalMax);
  }
}
