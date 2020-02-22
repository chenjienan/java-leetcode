package binarytree;
import tools.*;
import java.util.*;

public class BinaryTreePathSumToTarget {
  private boolean found;
  public boolean exist(TreeNode<Integer> root, int target) {            
    helper(root, target);
    return found;
  }

  private void helper(TreeNode<Integer> node, int remain) {
    if (node == null) {
      return;
    }
    if (node.left == null && node.right == null && node.key == remain) {
      this.found = true;
      return;
    }
    helper(node.left, remain - node.key);
    helper(node.right, remain - node.key);    
  }

  public boolean exist2(TreeNode<Integer> root, int target) {    
    helper2(root, target);
    return found;
  }

  private void helper2(TreeNode<Integer> node, int remain) {
    if (node == null) {
      return;
    }

    if (node.key == remain) {
      this.found = true;
      return;
    }
    helper2(node.left, remain - node.key);
    helper2(node.left, remain);
    helper2(node.right, remain - node.key);   
    helper2(node.right, remain);
  }

  public static void main(String[] args) {
    List<Integer> nodes = new ArrayList<>(Arrays.asList(5, 1, null, -1, 7, null, null, 0));
		TreeNode<Integer> nodeInstance = new TreeNode<Integer>(0);
		TreeNode<Integer> root = nodeInstance.deserializeFromList(nodes);
    BinaryTreePrinter.printNode(root);

    BinaryTreePathSumToTarget sol = new BinaryTreePathSumToTarget();
    System.out.println(sol.exist2(root, 8));
  }
}