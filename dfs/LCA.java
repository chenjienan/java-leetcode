package dfs;

import tools.*;

public class LCA {
  public TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> one, TreeNode<Integer> two) {

    // base case
    if (root == null || root == one || root == two) {
      return root;
    }
    
    // recursive steps
    
    // step 1 get info
    TreeNode<Integer> leftRes = lowestCommonAncestor(root.left, one, two);
    TreeNode<Integer> rightRes = lowestCommonAncestor(root.right, one, two);
    // step 2 process the data and return the proper value
    if (leftRes == null && rightRes == null) {
      return null;
    } else if (leftRes != null && rightRes == null) {
      return leftRes;
    } else if (leftRes == null && rightRes != null) {
      return rightRes;
    }

    return root;
  }
}