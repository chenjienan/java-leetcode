package binarytree;
import java.util.*;
import tools.*;

public class ClosestKNumberInBST {
  public int[] closestKValues(TreeNode<Integer> root, double target, int k) {      
    if (root == null) {
      return new int[k];
    }
    
    List<Integer> res = new ArrayList<>();  
    inorderClosest(root, target, k, res);
    
    int[] ret = new int[res.size()];
    for (int i = 0; i < res.size(); i++) {
      ret[i] = res.get(i);
    }
    return ret;
  }

  private void inorderClosest(TreeNode<Integer> node, double target, int k, List<Integer> res) {
    if (node == null) {
      return;
    }
    
    inorderClosest(node.left, target, k, res);
    
    if (res.size() < k) {
      res.add(node.key);
    } else {
      if (Math.abs(target - res.get(0)) > Math.abs(target - node.key)) {
        res.remove(0);
        res.add(node.key);
      } 
    }        
    inorderClosest(node.right, target, k, res);
  }
}