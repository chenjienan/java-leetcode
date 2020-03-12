package binarytree;
import tools.*;

public class ReconstructBSTWithPostorder {
  public TreeNode<Integer> reconstruct(int[] post) {
        
    int[] rootIdx = {post.length - 1};
    return constructBST(post, rootIdx, Integer.MIN_VALUE);
  }

  private TreeNode<Integer> constructBST(int[] post, int[] rootIdx, int min) {

    if (rootIdx[0] < 0 || post[rootIdx[0]] <= min) {
      return null;
    }

    TreeNode<Integer> root = new TreeNode<>(post[rootIdx[0]]);
    rootIdx[0]--;
    root.right = constructBST(post, rootIdx, root.key);
    root.left = constructBST(post, rootIdx, min);

    return root;
  }

  public static void main(String[] args) {
    int[] A = { 1, 4, 3, 11, 8, 5 };

    ReconstructBSTWithPostorder sol = new ReconstructBSTWithPostorder();
    BinaryTreePrinter.printNode(sol.reconstruct(A));
  }
}
