package binarytree;
import java.util.*;
import tools.*;


public class InvertBinaryTree {
  public TreeNode<Integer> invertTree(TreeNode<Integer> root) {
    // base case
      if (root == null) {
        return root;
    }
    // recursive rule
    TreeNode<Integer> tmp = invertTree(root.left);
    root.left = invertTree(root.right);
    root.right = tmp;

    return root;
  }

  public static void main(String[] args) {
    List<Integer> nodes = new ArrayList<>(Arrays.asList(261,null,404,285,454,281,298));
		TreeNode<Integer> nodeInstance = new TreeNode<Integer>(0);
		TreeNode<Integer> root = nodeInstance.deserializeFromList(nodes);
    BinaryTreePrinter.printNode(root);
    
    InvertBinaryTree sol = new InvertBinaryTree();
    BinaryTreePrinter.printNode(sol.invertTree(root));
  }
}

