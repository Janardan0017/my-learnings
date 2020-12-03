package stack;

public class Edge {
    private final Node nodeA;
    private final Node nodeB;

    public Edge(Node nodeA, Node nodeB) {
        this.nodeA = nodeA;
        this.nodeB = nodeB;
    }

    public Node getNodeA() {
        return nodeA;
    }

    public Node getNodeB() {
        return nodeB;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "nodeA=" + nodeA +
                ", nodeB=" + nodeB +
                '}';
    }
}