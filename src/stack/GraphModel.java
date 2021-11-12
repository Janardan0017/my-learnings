package stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GraphModel {
    Set<Node> nodes;
    Set<Edge> edges;

    public GraphModel() {
        this.nodes = new HashSet<>();
        this.edges = new HashSet<>();
    }

    // add node
    public void addNode(Node node) {
        nodes.add(node);
    }

    // add edge
    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    // remove node
    public void removeNode(Node node) {
        nodes.remove(node);
        // remove all edges who are connected with this node
        List<Edge> edgesToRemove = new ArrayList<>();
        // get all edges who are connected to this node
        for (Edge edge : edges) {
            if (edge.getNodeA().equals(node) || edge.getNodeB().equals(node)) {
                edgesToRemove.add(edge);
            }
        }
        // remove edges
        edges.removeAll(edgesToRemove);
    }

    // remove an edge
    public void removeEdge(Edge edge) {
        edges.remove(edge);
    }

    public static void main(String[] args) {
        GraphModel graph = new GraphModel();
        Node A = new Node(0, 0, 1, 1, "A");
        Node B = new Node(1, 1, 1, 1, "B");
        graph.addNode(A);
        graph.addNode(B);
        Edge edge = new Edge(A, B);
        graph.addEdge(edge);
        System.out.println(graph);
        graph.removeNode(A);
        System.out.println(graph);
    }

    @Override
    public String toString() {
        return "GraphModel{" +
                "nodes=" + nodes +
                ", edges=" + edges +
                '}';
    }
}