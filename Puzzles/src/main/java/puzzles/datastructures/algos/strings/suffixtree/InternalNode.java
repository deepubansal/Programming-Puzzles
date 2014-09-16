package puzzles.datastructures.algos.strings.suffixtree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InternalNode implements Node {

    List<Node> nodes;

    String incomingEdge;

    public InternalNode() {
        nodes = new ArrayList<Node>();
    }

    public String getIncomingEdge() {
        return incomingEdge;
    }

    @Override
    public String toString() {
        StringBuffer output = new StringBuffer();
        for (Iterator<Node> itr = nodes.iterator(); itr.hasNext();) {
            Node node = itr.next();
            output.append(incomingEdge + node.toString());
        }
        return output.toString();
    }

}
