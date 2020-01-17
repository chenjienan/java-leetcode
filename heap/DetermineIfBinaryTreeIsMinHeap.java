package heap;

import java.util.*;
import tools.*;


class DetermineIfBinaryTreeIsMinHeap {
    public boolean isMinHeap(TreeNode<Integer> root) {
        if (root == null) {
            return true;    
        }
        
        Queue<TreeNode<Integer>> queue = new ArrayDeque<>(Arrays.asList(root));

        boolean seenNull = false;
        while (!queue.isEmpty()) {
            TreeNode<Integer> curNode = queue.poll();
            if (curNode.left == null) {
                seenNull = true;
            } else if (seenNull || curNode.key > curNode.left.key) {
                return false;
            } else {
                queue.offer(curNode.left);
            }

            if (curNode.right == null) {
                seenNull = true;
            } else if (seenNull || curNode.key > curNode.right.key) {
                return false;
            } else {
                queue.offer(curNode.right);
            }
        }
        return true;
    }

    public static void main(String[] args){
        List<Integer> nodes = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        TreeNode<Integer> nodeInstance = new TreeNode<Integer>(0);
        TreeNode<Integer> root = nodeInstance.deserializeFromList(nodes);
        BinaryTreePrinter.printNode(root);

        DetermineIfBinaryTreeIsMinHeap solution = new DetermineIfBinaryTreeIsMinHeap();
        System.out.println(solution.isMinHeap(root));
    }
  }