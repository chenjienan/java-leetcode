package binarytree;
import java.util.*;
import tools.*;

public class CousinsInBinaryTree {
  public boolean isCousin(TreeNode<Integer> root, int a, int b) {
    
    if (root == null) {
      return false;
    }

    // BFS
    Queue<TreeNode<Integer>> queue = new ArrayDeque<>();
    queue.offer(root);

    while (!queue.isEmpty()) {

      int size = queue.size();
      int count = 0;

      for (int i = 0; i < size; i++) {
        TreeNode<Integer> curNode = queue.poll();
        
        if (curNode.left != null && curNode.right != null) {
          if ((curNode.left.key == a && curNode.right.key == b) ||
            (curNode.left.key == b && curNode.right.key == a)) {
            return false; // share the same parent
          }
        }
                      
        if (curNode.left != null) {
          if (curNode.left.key == a || curNode.left.key == b) {
            count++;
          }
          queue.offer(curNode.left);
        }

        if (curNode.right != null) {
          if (curNode.right.key == a || curNode.right.key == b) {
            count++;
          }
          queue.offer(curNode.right);
        }                
      }
      if (count == 2) {
          return true;
        }
      if (count == 1) {
        return false;
      }
    }
    return false;
  }
}
