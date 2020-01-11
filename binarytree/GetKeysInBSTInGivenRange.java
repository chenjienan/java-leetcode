package binarytree;

import tools.*;
import java.util.*;

public class GetKeysInBSTInGivenRange {
    public List<Integer> getRange(TreeNode<Integer> root, int min, int max) {
        // Write your solution here
        List<Integer> res = new ArrayList<>();
        helper(root, min, max, res);
        return res;
    }

    private void helper(TreeNode<Integer> node, int min, int max, List<Integer> res) {
        if (node == null) {
            return;
        }
        // check left
        if (node.key > min) {
            helper(node.left, min, max, res);
        }
        // check if value is in range
        if (node.key >= min && node.key <= max) {
            res.add(node.key);
        }
        // check right
        if (node.key < max) {
            helper(node.right, min, max, res);
        }
    }
}
