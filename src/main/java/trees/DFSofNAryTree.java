package trees;
/*
	Problem: Find max depth of an n-ary tree.
*/

import lombok.val;

import static java.util.Objects.isNull;
import static models.Models.*;

public class DFSofNAryTree {

    public int maxDepth(final Node root) {
        class Recurse {
            public int maxDepthR(final Node node, int depth) {
                if(node == null || node.getChildren() == null || node.getChildren().size() < 1) {
                    return depth;
                }
                val initial = depth;
                for(val child : node.getChildren()) {
                    depth = Math.max(depth, maxDepthR(child, initial + 1));
                }
                return depth;
            }
        }
        return isNull(root) ? 0 : new Recurse().maxDepthR(root, 1);
    }
}