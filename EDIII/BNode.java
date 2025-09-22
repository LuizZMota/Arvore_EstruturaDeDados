package EDIII;

public class BNode{
    private BNode right;
    private BNode left;
    private BNode parent;
    private int data;

    public BNode(int data){
        this.data = data;
    }

    public BNode(int data, BNode parent){
        this.data = data;
        this.parent = parent;
    }

    public BNode(){
        this(0);
    }

    public BNode getRight() {
        return right;
    }

    public void setRight(BNode right) {
        this.right = right;
    }

    public BNode getLeft() {
        return left;
    }

    public void setLeft(BNode left) {
        this.left = left;
    }

    public BNode getParent() {
        return parent;
    }

    public void setParent(BNode parent) {
        this.parent = parent;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public boolean isRoot(){
        return this.parent == null;
    }

    public boolean isLeaf(){
        if(this.right == null && this.left == null) {
            return true;
        }
        return false;
    }

    public int getDegree(){
        if (this.isLeaf()){
            return 0;
        }

        int count = 0;
        if(this.getLeft() !=null){
            count++;
        }
        if (this.getRight() != null){
            count++;
        }
        
        return count;
    }
    
    public int getLevel(){
        if (this.getParent()==null){
            return 0;
        }
        return 1 + this.getParent().getLevel();
    }

    public int getHeight(){
        if(isLeaf()){
            return 0;
        }
        int dir;
        int esq;
        if (this.getLeft()== null){
            return esq=0;
        } else{
            esq = this.getLeft().getHeight();
        }
        if (this.getRight() == null){
            return dir=0;
        } else {
            dir = this.getRight().getHeight();
        }
        return 1 + Math.max(esq,dir);
    }
}
