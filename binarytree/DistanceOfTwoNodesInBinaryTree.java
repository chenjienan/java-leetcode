package binarytree;
import tools.*;
import java.util.*;

public class DistanceOfTwoNodesInBinaryTree {

  public int distance(final TreeNode<Integer> root, final int k1, final int k2) {
    TreeNode<Integer> lca = getLCA(root, k1, k2);
    
    int leftDist = lca.key == k1 ? 0 : getDistanceFromNode(lca, k1) - 1;
    int rightDist = lca.key == k2 ? 0 : getDistanceFromNode(lca, k2) - 1;
    return leftDist + rightDist;
  }

  private TreeNode<Integer> getLCA(TreeNode<Integer> node, int a, int b) {
    if (node == null || node.key == a || node.key == b) {
      return node;
    }

    TreeNode<Integer> leftRes = getLCA(node.left, a, b);
    TreeNode<Integer> rightRes = getLCA(node.right, a, b);

    if (leftRes == null && rightRes == null) {
      return null;
    }
    if (leftRes != null && rightRes != null) {
      return node;
    }
    return leftRes != null ? leftRes : rightRes;
  }

  private int getDistanceFromNode(TreeNode<Integer> node, int x) {
    if (node == null) {
      return 0;
    }

    if (node.key == x) {
      return 1;
    }
    int left = getDistanceFromNode(node.left, x);
    int right = getDistanceFromNode(node.right, x);
    if (left == 0 && right == 0) {
      return 0;
    }

    return left != 0 ? left + 1 : right + 1;
  }

  public static void main(final String[] args)
	{
		final List<Integer> nodes = new ArrayList<>(Arrays.asList(7, 3, 9, 1, 5, 8, 10, null, 2, 4, 6));
    final TreeNode<Integer> nodeInstance = new TreeNode<Integer>(0);
    final TreeNode<Integer> root = nodeInstance.deserializeFromList(nodes);
		BinaryTreePrinter.printNode(root);
		
    final DistanceOfTwoNodesInBinaryTree sol = new DistanceOfTwoNodesInBinaryTree();
    System.out.println(sol.distance(root, 2, 6));
	}
}



