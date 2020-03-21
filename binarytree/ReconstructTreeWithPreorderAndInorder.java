package binarytree;
import tools.*;
import java.util.*;


public class ReconstructTreeWithPreorderAndInorder {
  public TreeNode<Integer> reconstruct(int[] inOrder, int[] preOrder) {
    
    // pre-process inorder array into HashMap key: array value, value: idx
    Map<Integer, Integer> idxMap = new HashMap<>();
    for (int idx = 0; idx < inOrder.length; idx++) {
      idxMap.put(inOrder[idx], idx);
    }

    return construct(inOrder, 0, inOrder.length - 1, preOrder, 0, preOrder.length - 1, idxMap);
  }

  private TreeNode<Integer> construct(int[] in, int inLeft, int inRight, int[] pre, int preLeft, int preRight, Map<Integer, Integer> idxMap) {

    // base case
    if (inLeft > inRight) {
      return null;
    }

    TreeNode<Integer> root = new TreeNode<Integer>(pre[preLeft]);
    int leftSize = idxMap.get(root.key) - inLeft;
    int rightSize = inRight - idxMap.get(root.key);

    root.left = construct(in, inLeft, inLeft + leftSize - 1, pre, preLeft + 1, preLeft + leftSize, idxMap);
    root.right = construct(in, inRight - rightSize + 1, inRight, pre, preRight - rightSize + 1, preRight, idxMap);

    return root;
  }
}
