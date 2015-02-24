package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://oj.leetcode.com/problems/clone-graph/
 * 
 * DFS version:
 * https://oj.leetcode.com/discuss/18553/recursive-dfs-java-solution
 * -using-hashmap
 *
 **/

public class CloneGraphDFS {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

		if (node == null) {
			return null;
		}

		Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();

		return cloneGraph(node, map);

	}

	private UndirectedGraphNode cloneGraph(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {

		UndirectedGraphNode root = new UndirectedGraphNode(node.label);

		map.put(root.label, root);

		for (UndirectedGraphNode nn : node.neighbors) {

			if (!map.containsKey(nn.label)) {
				root.neighbors.add(cloneGraph(nn, map));
			} else {
				root.neighors.add(map.get(nn.label));
			}

		}

		return root;

	}
}