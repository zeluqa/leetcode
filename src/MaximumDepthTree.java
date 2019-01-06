//https://leetcode.com/problems/maximum-depth-of-n-ary-tree/solution/
import java.util.List;

class MaximumDepthTree {
	// Definition for a Node.
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val,List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};
	
    static int max;
    public int maxDepth(Node root) {
        max = 0;
        if (root != null)            
            traverse(root,1);
        return max;
    }
    
    public void traverse(Node root, int depth) {
        if (root.children.size() == 0) {
            max = (depth > max) ? depth : max;
            return;            
        }
        
        for (Node node : root.children)
            traverse(node, depth+1);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
}