package binarytree;
import tools.*;
import java.util.*;


public class CountUniValueSubtree {
  public int countUnivalSubtrees(TreeNode<Integer> root) {

    int[] res = {0};
    helper(root, res);
    return res[0];
  }

  // can find univalue in node
  private boolean helper(TreeNode<Integer> node, int[] counter) {
    if (node == null) {
      return true;
    }

    boolean left = helper(node.left, counter);
    boolean right = helper(node.right, counter);

    if (left && right) {
      if (node.left != null && node.left.key != node.key) {
        return false;
      }
      if (node.right != null && node.right.key != node.key) {
        return false;
      }

      counter[0]++;
      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    List<Integer> nodes = new ArrayList<>(Arrays.asList(5,1,5,5,5,null,5,1, 2, 5));
		TreeNode<Integer> nodeInstance = new TreeNode<Integer>(0);
		TreeNode<Integer> root = nodeInstance.deserializeFromList(nodes);
    BinaryTreePrinter.printNode(root);
    
    CountUniValueSubtree sol = new CountUniValueSubtree();
    System.out.println(sol.countUnivalSubtrees(root));
  }
}
