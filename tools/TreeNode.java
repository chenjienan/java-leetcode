package tools;
import java.util.*;

public class TreeNode<T extends Comparable<?>> {
    public T key;
    public int counter;
    public TreeNode<T> left;
    public TreeNode<T> right;
    public TreeNode<T> parent;

    public TreeNode(T x) {
        this.key = x;
    }

    public TreeNode<T> deserializeFromList(List<T> arr) {
        if (arr == null || arr.size() == 0) {
            return null;
        }

        TreeNode<T> root = new TreeNode<>(arr.get(0));
        Queue<TreeNode<T>> queue = new ArrayDeque<>();
        queue.offer(root);

        int i = 1;
        while (i < arr.size()) {
            TreeNode<T> curNode = queue.poll();
            
            // find left child (already check if i < length in the while loop)
            if (arr.get(i) != null) {
                curNode.left = new TreeNode<T>(arr.get(i));
                queue.offer(curNode.left);
             }
            i++; // move to the next element

             // find right child
            if (i < arr.size() && arr.get(i) != null) {
                curNode.right = new TreeNode<T>(arr.get(i));
                queue.offer(curNode.right);     
            }
            i++; // move to next round
        }
        return root;
    }
}