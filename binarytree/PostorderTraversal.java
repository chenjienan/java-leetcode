package binarytree;
import java.util.*;
import tools.*;

public class PostorderTraversal {

	public static List<Integer> postOrder(TreeNode<Integer> root) {
		List<Integer> res = new ArrayList<>();
		if (root == null) {
			return res;
		}

		Deque<TreeNode<Integer>> stack = new ArrayDeque<>(Arrays.asList(root));


		return res;
	}


	public static void main(String[] args)
	{
		
	}
}
