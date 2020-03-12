package binarytree;
import tools.*;
import java.util.*;

public class LongestIncreasingPathBinaryTree {
  
  public int longest(TreeNode<Integer> root) {
    int[] max = {Integer.MIN_VALUE};
    helper(root, root, 0, max);
    return max[0];
  }

  private void helper(TreeNode<Integer> node, TreeNode<Integer> prevNode, int curLen, int[] max) {
    if (node == null) {
      return;
    }

    if (node.key > prevNode.key) {
      curLen++;
    } else {
      curLen = 1;
    }
    
    max[0] = Math.max(max[0], curLen);
    helper(node.left, node, curLen, max);
    helper(node.right, node, curLen, max);
  }
  
  public static void main(String[] args) {
    List<Integer> nodes = new ArrayList<>(Arrays.asList(1, 3, 2, 1, 0, null, 11));
		TreeNode<Integer> nodeInstance = new TreeNode<Integer>(0);
		TreeNode<Integer> root = nodeInstance.deserializeFromList(nodes);
    BinaryTreePrinter.printNode(root);

    LongestIncreasingPathBinaryTree sol = new LongestIncreasingPathBinaryTree();
    System.out.println(sol.longest(root));
  }
}


// from leaf to root => descending 
