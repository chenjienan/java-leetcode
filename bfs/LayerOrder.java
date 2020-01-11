package bfs;

import tools.*;
import java.util.*;

public class LayerOrder {

    public static List<List<Integer>> layerByLayer(TreeNode<Integer> root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode<Integer>> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            
            List<Integer> curLayer = new ArrayList<>();
            // initial state
            int curSize = queue.size();
            // termination
            for (int i = 0; i < curSize; ++i) {
                
                TreeNode<Integer> curNode = queue.poll();
                // generate
                curLayer.add(curNode.key);
                // expand
                if (curNode.left != null) {
                    queue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    queue.offer(curNode.right);
                }
            }
            res.add(curLayer);
        }
        return res;
    }
	public static void main(String[] args)
	{
        List<Integer> nodesList = new ArrayList<>(Arrays.asList(5,3,8,1,4,null,11));
        TreeNode<Integer> nodeInstance = new TreeNode<Integer>(0);
        TreeNode<Integer> root = nodeInstance.deserializeFromList(nodesList);
        
        ListPrinter<Integer> lp = new ListPrinter<>();
        lp.printListOfList(layerByLayer(root));
    }
}
