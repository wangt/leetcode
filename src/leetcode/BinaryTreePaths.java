package leetcode;

/**
 * https://leetcode.com/problems/binary-tree-paths/
 * Given a binary tree, return all root-to-leaf paths.
 * https://leetcode.com/discuss/52072/accepted-java-simple-solution-in-8-lines
 */

public class BinaryTreePaths {

	public List<String> binaryTreePaths(TreeNode root) {

    	if(root == null){
    		return Collections.emptyList();
    	}

    	if(root.left == null && root.right == null){
    		return Arrays.asList(new String[]{String.valueOf(root.val)})
    	}

    	List<String> result = new ArrayList<String>();

    	for(String s:binaryTreePaths(root.left)){
    		result.add(root.val + "->" + s);
    	}

		for(String s:binaryTreePaths(root.left)){
    		result.add(root.val + "->" + s);
    	}
    	
    	return result;    
    }
}