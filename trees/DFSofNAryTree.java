/*
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

	Problem: Find max depth of an n-ary tree.
*/

class DFSofNAryTree {
    public int maxDepth(final Node root) {
        class Recurse {
            public int maxDepthR(final Node node, int depth) {
                if(node == null || node.children == null || node.children.size() < 1) {
                    return depth;
                }
                final int initial = depth;
                for(final Node child : node.children) {
                    depth = Math.max(depth, maxDepthR(child, initial + 1));
                }
                return depth;
            }
        }
        return root == null ? 0 : new Recurse().maxDepthR(root, 1);
    }
}