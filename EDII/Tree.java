package EDII;
import java.util.List;
import java.util.Collections;

public class Tree {
    private Node root;
    private int size;

    public Tree(){
        this.root = null;
        this.size = 0;
    }

    public Object getInfo(Node v){
        if (v==null){
            return null;
        } 
        return v.getData();
    }

    public Node root(){
        return root;
    }

    public Node parent(Node v){
        if (v == null || v == root){
            return v;
        }
        return v.getParent();
    }

    public List<Node> filhos(Node v){
        if (v == null){
            return Collections.emptyList();
        } 
        return v.getChildren();
    }

    public boolean isInternal(Node v){
        return v != null && v.getChildren().size()>0;
    }

    public boolean isExternal(Node v){
        return v!=null && v.getChildren().size()==0;
    }

    public boolean isRoot(Node v){
        return v != null && v.getParent() == null;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public Object replace(Node v, Node e){
        if (v == null){
            return v;
        } 
        Object oldElement = v.getData();
        v.setData(e);
        return oldElement;
    }

    public int depth(Node v){
        if (isRoot(v)){
            return 0;
        } else {
            return 1 + depth(v.getParent());
        }
    }

    public int height(Node v){
        if (isExternal(v)){
            return 0;
        }
        int maxHeight = 0;
        for (Node child:v.getChildren()){
            maxHeight = Math.max(maxHeight, height(child));
        }
        return 1 + maxHeight;
    }

    public int height(){
        if (isEmpty()){
            return 0;
        }
        return height(root);
    }
}
