package stack;

import java.awt.*;

public class Node {
    private String name;
    private Rectangle rectangle;


    public Node(int x, int y, int width, int height, String name) {
        this.rectangle = new Rectangle(x, y, width, height);
        this.name = name;
    }

    public Node() {
        this.rectangle = new Rectangle(0, 0, 0, 0); //gonna change the parameters later
        this.name = "default name";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    @Override
    public boolean equals(Object o) {
        Node node = (Node) o;
        return this.name.equals(node.getName());
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", x=" + rectangle.x +
                ", y=" + rectangle.y +
                ", width=" + rectangle.width +
                ", height=" + rectangle.height +
                '}';
    }
}
