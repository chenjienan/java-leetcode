package binarytree;

import tools.*;
import java.util.*;

public class DeleteInBST {

    public TreeNode<Integer> deleteTree(TreeNode<Integer> root, int key) {
        if (root == null) {
            return null;
        }
        // found the target node
        if (root.key == key) {
            // *** root is the node to be deleted ***
            // Case 2: the target node has only one child node (skip the curNode)
            if (root.left == null) {    // also covers case 1: target node is a leaf node
                return root.right;      // return curNode's right subtree
            }
            if (root.right == null) {
                return root.left;       // return curNode's left subtree
            }
            // guarantee root.left != null && root.right != null
            // *** prevent NPE *** guarantee root.right.left is not null
            // at this point, we the root.right (right subtree) in operation
            if (root.right.left == null) {      // root.right is the min value of the right subtree
                root.right.left = root.left;    // connect target node's left
                return root.right;
            } 
            // Case 3: the target node has two child nodes
            // so that we can operate on the right subtree
            TreeNode<Integer> newRoot = getSmallestNode(root.right);
            newRoot.left = root.left;       // connect left
            newRoot.right = root.right;     // connect right
            return newRoot;
        }

        // keep searching 
        else if (root.key > key) {                      // cur value > key, target not in right subtree
            root.left = deleteTree(root.left, key);     // search left subtree
        } else {                                        // cur value < key, target not in left subtree
            root.right = deleteTree(root.right, key);   // search right subtree
        }
        
        return root;
    }

    // get the smallest node from the right subtree
    private TreeNode<Integer> getSmallestNode(TreeNode<Integer> curNode) {
        // keep the previous node reference to curNode's parent
        TreeNode<Integer> parentNode = curNode;
        curNode = curNode.left;
        while (curNode.left != null) {
            parentNode = curNode;
            curNode = curNode.left;
        }
        // set the previous node's left child to left child's right child
        parentNode.left = parentNode.left.right;
        return curNode; // this is the node to replace target node (local root)
    }

	public static void main(String[] args)
	{
		List<Integer> nodes = new ArrayList<>(Arrays.asList(3, 2, 8, null, null, 6, 10));
        TreeNode<Integer> nodeInstance = new TreeNode<Integer>(0);
        TreeNode<Integer> root = nodeInstance.deserializeFromList(nodes);
        BinaryTreePrinter.printNode(root);

        DeleteInBST solution = new DeleteInBST();
        TreeNode<Integer> newRoot = solution.deleteTree(root, 8);
        BinaryTreePrinter.printNode(newRoot);
	}
}



