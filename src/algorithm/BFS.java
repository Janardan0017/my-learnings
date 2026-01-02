package algorithm;

import java.util.ArrayList;
import java.util.List;

public class BFS {

    public static void main(String[] args) {
        GraphNode<String> a = new GraphNode<>("A");
        GraphNode<String> b = new GraphNode<>("B");
        GraphNode<String> c = new GraphNode<>("C");
        GraphNode<String> d = new GraphNode<>("D");
        GraphNode<String> e = new GraphNode<>("E");
        GraphNode<String> f = new GraphNode<>("F");
        GraphNode<String> g = new GraphNode<>("G");

        a.addChild(b);
        a.addChild(c);
        b.addChild(d);
        b.addChild(e);
        c.addChild(d);
        c.addChild(f);
        d.addChild(e);
        e.addChild(g);
        f.addChild(g);

        System.out.println(a);
    }

    static class GraphNode<T> {

        T value;
        GraphNode<T> parentNode;
        List<GraphNode<T>> childNodes;

        public GraphNode() {
            childNodes = new ArrayList<>();
        }

        public GraphNode(T value) {
            this.value = value;
            childNodes = new ArrayList<>();
        }

        public void addChild(GraphNode<T> childNode) {
            this.childNodes.add(childNode);
        }

        @Override
        public String toString() {
            return "GraphNode{"
                    + "value=" + value
                    + ", parentNode=" + parentNode
                    + ", childNodes=" + childNodes
                    + '}';
        }
    }
}
