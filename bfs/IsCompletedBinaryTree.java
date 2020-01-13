package bfs;
import tools.*;
import java.util.*;

public class IsCompletedBinaryTree {

    public static boolean isCompleted(TreeNode<Integer> root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.offer(root);

        boolean seenNull = false;
        while (!queue.isEmpty()) {
            TreeNode<Integer> curNode = queue.poll();
            if (curNode.left == null) {
                seenNull = true;
            // node != null
            } else if (seenNull) {
                return false;
            } else {
                queue.offer(curNode.left);
            }


            if (curNode.right == null) {
                seenNull = true;
            } else if (seenNull) {
                return false;
            } else {
                queue.offer(curNode.right);
            }

        }

        return true;
    }

	public static void main(String[] args)
	{
		List<Integer> nodes = new ArrayList<>(Arrays.asList(5, 3, 8, null, 4));
        TreeNode<Integer> nodeInstance = new TreeNode<Integer>(0);
        TreeNode<Integer> root = nodeInstance.deserializeFromList(nodes);
        // BinaryTreePrinter.printNode(root);
        System.out.println(isCompleted(root));
	}
}



