package binarytree;
import java.util.*;
import tools.*;


public class BinaryTreePath {
  public String[] binaryTreePaths(TreeNode<Integer> root) {
    // Write your solution here
    
    
    StringBuilder sb = new StringBuilder();
    List<String> strList = new ArrayList<>();

    helper(root, sb, strList);
    String[] res = new String[strList.size()];
    for (int i = 0; i < strList.size(); i++) {
      res[i] = strList.get(i);
    }
    return res;
  }

  // reach bottom
  private void helper(TreeNode<Integer> node, StringBuilder sb, List<String> strList) {
    
    if (node.left == null && node.right == null) { // leaf node
      sb.append(node.key);
      strList.add(sb.toString());
      int keyLen = Integer.toString(node.key).length();
      sb.delete(sb.length() - keyLen, sb.length());
      return;
    }
    
    sb.append(node.key);
    sb.append("->");
    if (node.left != null) {      
      helper(node.left, sb, strList);      
    }
    
    if (node.right != null) {
      helper(node.right, sb, strList);      
    }
    int keyLen = Integer.toString(node.key).length();
    sb.delete(sb.length() - 2 - keyLen, sb.length());
  }

  public static void main(String[] args) {
    List<Integer> nodes = new ArrayList<>(Arrays.asList(3, 9 , 20, null, null, 15, 7));
		TreeNode<Integer> nodeInstance = new TreeNode<Integer>(0);
		TreeNode<Integer> root = nodeInstance.deserializeFromList(nodes);
    BinaryTreePrinter.printNode(root);
   
    BinaryTreePath sol = new BinaryTreePath();
    String[] res = sol.binaryTreePaths(root);
    for (int i = 0; i < res.length; i++) {
      System.out.println(res[i]);
    }
  }
}
