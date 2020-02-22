package binarytree;
import tools.*;
import java.util.*;

public class MinimumDepthBinaryTree {
  public int minDepth(TreeNode root) {
  
    // base case
    if (root == null) {
      return 0;
    }
    
    // recursive rule
    int left = minDepth(root.left);
    int right = minDepth(root.right);
    
    if (left != 0 && right != 0) {          // not a leaf
      return Math.min(left, right) + 1;    // add cur node
    }
    
    if (left == 0) {      // left == 0 
      return right + 1;
    }
    return left + 1;      // right == 0
  }

  public static void main(String[] args) {
    List<Integer> nodes = new ArrayList<>(Arrays.asList(261,null,404,285,454,281,298));
		TreeNode<Integer> nodeInstance = new TreeNode<Integer>(0);
		TreeNode<Integer> root = nodeInstance.deserializeFromList(nodes);
    BinaryTreePrinter.printNode(root);
    
    MinimumDepthBinaryTree sol = new MinimumDepthBinaryTree();
    System.out.println(sol.minDepth(root));
  }
}