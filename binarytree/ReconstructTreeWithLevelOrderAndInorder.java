package binarytree;
import tools.*;
import java.util.*;

public class ReconstructTreeWithLevelOrderAndInorder {
  public TreeNode<Integer> reconstruct(int[] inOrder, int[] levelOrder) {
    
    Map<Integer, Integer> iMap = new HashMap<>();
    for (int i = 0; i < inOrder.length; i++) {
      iMap.put(inOrder[i], i);
    }

    List<Integer> level = new ArrayList<>();
    for (int num : levelOrder) {
      level.add(num);
    }
    return helper(level, iMap);
  }

  private TreeNode<Integer> helper(List<Integer> levelOrder, Map<Integer, Integer> iMap) {

    if (levelOrder.isEmpty()) {
      return null;
    }

    TreeNode<Integer> root = new TreeNode<Integer>(levelOrder.remove(0));

    List<Integer> leftElements = new ArrayList<>();
    List<Integer> rightElements = new ArrayList<>();

    int rootIdx = iMap.get(root.key);
    for (Integer elem : levelOrder) {
      if (iMap.get(elem) < rootIdx) {
        leftElements.add(elem);
      } else {
        rightElements.add(elem);
      }      
    }
    root.left = helper(leftElements, iMap);
    root.right = helper(rightElements, iMap);

    return root;
  }
}
