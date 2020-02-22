package binarytree;
import java.util.*;
import tools.*;



public class LCAWithParentNode {
  public TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> one, TreeNode<Integer> two) {
    
    int oneHeight = getHeight(one);
    int twoHeight = getHeight(two);

    if (oneHeight > twoHeight) {
      for (int i = 0; i < oneHeight - twoHeight; i++) {
        one = one.parent;
      }
      
    } else {
      for (int i = 0; i < twoHeight - oneHeight; i++) {
        two = two.parent;
      }
    }

    while (one != null) {
        if (one.key == two.key) {
          return one;
        }
        one = one.parent;
        two = two.parent;
      }
    return null;
  }

  private int getHeight(TreeNode<Integer> node) {
    int height = 0;
    while (node != null) {
      node = node.parent;
      height++;
    }
    return height;
  }

  public static void main(String[] args)
	{
		List<Integer> nodes = new ArrayList<>(Arrays.asList(8,5,13,3,6, 9, 17, 2, 4));
    TreeNode<Integer> nodeInstance = new TreeNode<Integer>(0);
    TreeNode<Integer> root = nodeInstance.deserializeFromList(nodes);
    BinaryTreePrinter.printNode(root);

    TreeNode<Integer> one = new TreeNode<Integer>(4);
    TreeNode<Integer> two = new TreeNode<Integer>(13);

    TreeNode<Integer> node3 = new TreeNode<Integer>(3);  
    TreeNode<Integer> node5 = new TreeNode<Integer>(5);
    TreeNode<Integer> node8 = new TreeNode<Integer>(8);

    one.parent = node3;
    node3.parent = node5;
    node5.parent = node8;

    two.parent = node8;

    LCAWithParentNode sol = new LCAWithParentNode();
    System.out.println(sol.lowestCommonAncestor(one, two).key);
  }
}