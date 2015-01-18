package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://oj.leetcode.com/problems/clone-graph/
 * 
 * DFS version:
 * https://oj.leetcode.com/discuss/18553/recursive-dfs-java-solution
 * -using-hashmap
 *
 **/

public class CloneGraphBFS {

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

		if (node == null) {
			return null;
		}

		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);

		Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();

		LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();

		queue.addLast(node);

		map.put(node.label, node);

		while (!queue.isEmpty()) {

			UndirectedGraphNode n = queue.pop();

			UndirectedGraphNode nn = map.get(n.label);

			for (UndirectedGraphNode neighbor : n.neighbors) {

				if (!map.containsKey(neighbor.label)) {
					map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
					queue.add(neighbor);
				}

				nn.neighbors.add(map.get(neighbor.label));

			}

		}

		return newNode;
	}

}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}