package bfs;
import java.util.*;

public class Bipartite {

    static class GraphNode {
        public int key;
        public List<GraphNode> neighbors;

        public GraphNode(int key) {
        this.key = key;
        this.neighbors = new ArrayList<GraphNode>();
        }
    }

    public static boolean isBipartite(List<GraphNode> graph) {
        // key: graph node
        // value: color group
        HashMap<GraphNode, Integer> visited = new HashMap<>();

        for (GraphNode node: graph) {
            if (!helper(node, visited)) {
                return false;
            }
        }
        return true;        
    }

    private static boolean helper(GraphNode node, HashMap<GraphNode, Integer> visited) {
        if (visited.containsKey(node)) {
            return true;
        }

        // store neighbor nodes
        Queue<GraphNode> queue = new ArrayDeque<>();
        queue.offer(node);
        visited.put(node, 1);
        while (!queue.isEmpty()) {
            GraphNode curNode = queue.poll();
            int curGroup = visited.get(curNode);
            int neighborGroup = curGroup * -1;
            for (GraphNode neighborNode : curNode.neighbors) {
                // if not been visited
                if (!visited.containsKey(neighborNode)) {
                    visited.put(neighborNode, neighborGroup);
                    queue.offer(neighborNode);
                // if neighbor has been visited but color is not matched
                } else if (visited.get(neighborNode) != neighborGroup) {
                    return false;
                }
            } 
        }
        return true;
    }

	public static void main(String[] args)
	{
        GraphNode node0 = new GraphNode(0);
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);

        node0.neighbors.add(node1);
        node1.neighbors.add(node0);
        node2.neighbors.add(node1);
        node1.neighbors.add(node2);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);

        List<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(node0);
        nodeList.add(node1);
        nodeList.add(node2);
        nodeList.add(node3);

        System.out.println(isBipartite(nodeList));
	}
}
