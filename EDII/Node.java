package EDII;
import java.util.ArrayList;
import java.util.List;
public class Node {
    private Object data;
    private Node parent;
    private List<Node> children;

    public Node(Object data, Node parent){
        this.data = data;
        this.parent = parent;
        this.children = new ArrayList<>();
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(Node child) {
        this.children.add(child);
    }
    
}
