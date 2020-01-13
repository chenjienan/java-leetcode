package binarytree;
import java.util.*;
import tools.*;

public class InorderTraversal {

	public static List<Integer> inOrder(TreeNode<Integer> root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		Deque<TreeNode<Integer>> stack = new ArrayDeque<>();
		TreeNode<Integer> cur = root;
		while (cur != null || !stack.isEmpty()){
			// get left subtree
			if (cur != null) {
				stack.offerFirst(cur);
				cur = cur.left;
			} else {
				// from the left subtree of cur node has been traversed
				// helper node: cur is null
				cur = stack.pollFirst();
				// when switch to right subtree, add value to res
				// second visit of the node.
				res.add(cur.key);
				cur = cur.right;
			}
		}
		return res;
	}

	public static void main(String[] args)
	{
		List<Integer> nodes = new ArrayList<>(Arrays.asList(5,2,10,1,3,8,13,null,null,null,4,null,null,11,15));
        TreeNode<Integer> nodeInstance = new TreeNode<Integer>(0);
        TreeNode<Integer> root = nodeInstance.deserializeFromList(nodes);
		BinaryTreePrinter.printNode(root);
		
		System.out.println(inOrder(root));
	}
}
