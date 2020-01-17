package binarytree;
import java.util.*;
import tools.*;

public class PostorderTraversal {

	public List<Integer> postOrder(TreeNode<Integer> root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		Deque<TreeNode<Integer>> stack = new ArrayDeque<>(Arrays.asList(root));

		TreeNode<Integer> preNode = null;
		while (!stack.isEmpty()) {
			TreeNode<Integer> curNode = stack.peekFirst();

			if (preNode == null || curNode == preNode.left || curNode == preNode.right) {
				if (curNode.left != null) {
					stack.offerFirst(curNode.left);
				} else if (curNode.right != null) {
					stack.offerFirst(curNode.right);
				} else {
					// curNode is leaf node
					res.add(stack.pollFirst().key);
					
				}
			} else if (preNode == curNode.left) {	// from left subtree
				if (curNode.right != null) {
					stack.offerFirst(curNode.right);
				} else {
					res.add(stack.pollFirst().key);
					
				}
			} else if (preNode == curNode.right){	// from right subtree
				res.add(stack.pollFirst().key);
				
			}
			preNode = curNode;
		}

		return res;
	}


	public static void main(String[] args)
	{
		List<Integer> nodes = new ArrayList<>(Arrays.asList(5,2,10,1,3,8,13,null,null,null,4,null,null,11,15));
        TreeNode<Integer> nodeInstance = new TreeNode<Integer>(0);
        TreeNode<Integer> root = nodeInstance.deserializeFromList(nodes);
		BinaryTreePrinter.printNode(root);
		
		PostorderTraversal solution = new PostorderTraversal();
		System.out.println(solution.postOrder(root));
	}
}
