package binarytree;
import java.util.*;
import tools.*;

public class PreorderTraversal {

	public static List<Integer> preOrder(TreeNode<Integer> root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		
		Deque<TreeNode<Integer>> stack = new ArrayDeque<>(Arrays.asList(root));

		while (!stack.isEmpty()) {
			TreeNode<Integer> curNode = stack.pollFirst();

			// right first
			if (curNode.right != null) {
				stack.offerFirst(curNode.right);
			}
			// then left
			if (curNode.left != null) {
				stack.offerFirst(curNode.left);
			}
			
			res.add(curNode.key);
		}
		return res;
	}

	public static void main(String[] args)
	{
		List<Integer> nodes = new ArrayList<>(Arrays.asList(5,2,10,1,3,8,13,null,null,null,4,null,null,11,15));
		TreeNode<Integer> nodeInstance = new TreeNode<Integer>(0);
		TreeNode<Integer> root = nodeInstance.deserializeFromList(nodes);
		BinaryTreePrinter.printNode(root);
		
		System.out.println(preOrder(root));
	}
}
