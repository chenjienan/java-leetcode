package binarytree;
import tools.*;
import java.util.*;


public class BinaryTreeDiameter {
  public int diameter(TreeNode<Integer> root) {
    if (root == null) {
      return 0;
    }       
    int[] maxDiameter = {Integer.MIN_VALUE};
    helper(root, maxDiameter);
    return maxDiameter[0] == Integer.MIN_VALUE ? 0 : maxDiameter[0];
  }

  private int helper(TreeNode<Integer> node, int[] maxDiameter) {
    if (node == null) {
      return 0;
    }

    int left = helper(node.left, maxDiameter);
    int right = helper(node.right, maxDiameter);
    
    if (left != 0 && right != 0) {
      maxDiameter[0] = Math.max(maxDiameter[0], left + right + 1);
    }
    
    return Math.max(left, right) + 1;
  }

  public static void main(String[] args) {
    List<Integer> nodes = new ArrayList<>(Arrays.asList(1,2,3,null,null, 6, 14));
		TreeNode<Integer> nodeInstance = new TreeNode<Integer>(0);
		TreeNode<Integer> root = nodeInstance.deserializeFromList(nodes);
    BinaryTreePrinter.printNode(root);
    
    BinaryTreeDiameter sol = new BinaryTreeDiameter();
    System.out.println(sol.diameter(root));
  }
}