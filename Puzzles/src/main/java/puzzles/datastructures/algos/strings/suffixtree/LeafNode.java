package puzzles.datastructures.algos.strings.suffixtree;


public class LeafNode implements Node {

    private int position;
    
    String incomingEdge;
    
    public LeafNode(int position) {
        this.position = position;
    }
    
    public int getPosition() {
        return this.position;
    }

    public String getIncomingEdge() {
        return this.incomingEdge;
    }
    
    @Override
    public String toString() {
        return this.incomingEdge +"("+ position+")\n";
    }
}
