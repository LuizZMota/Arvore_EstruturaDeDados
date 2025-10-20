package EDIII;

public class BinaryTree {
    private BNode root;
    
    public BinaryTree(BNode root){
        this.root= root;
    }
    public BinaryTree(){
        this(null);
    }
    public BNode getRoot() {
        return root;
    }
    public void setRoot(BNode root) {
        this.root = root;
    }

    public int getDegree(){
        return getDegreeHelper(root);
    }

    public int getDegreeHelper(BNode node){
        if (node == null){
            return 0;
        }
        int left=0;
        int right=0;
        int currentDegree=0;
        if (node.getRight()!=null){
            currentDegree++;
        }
        if (node.getRight()!=null){
            currentDegree++;
        }

        left = getDegreeHelper(node.getLeft());
        right = getDegreeHelper(node.getRight());

        return 1 + Math.max(currentDegree, (Math.max(left, right)));

    }

    public boolean isEmpty(){
        if (getRoot()==null){
            return true;
        }
        return false;
    }

    public int getHeight(){
        if (isEmpty()){
            return 0;
        }
        return getRoot().getHeight() + 1;
    }

    public boolean search(int data){
        BNode atual;
        atual = root;
        while(atual!=null){
            if(data == atual.getData()){
                return true;
            } else if(data<atual.getData()){
                atual = atual.getleft();
            } else if(data>atual.getData()){
                atual = atual.getRight();
            } 
        }
        return false;
    }

    public String inOrderTraversal(){
        return inOrderTraversalHelper(getRoot());
    }

    public String inOrderTraversalHelper(BNode node){
        if (isEmpty()){
            return "";
        }


        StringBuilder sb = new StringBuilder();

        sb.append(inOrderTraversalHelper(node.getLeft()));
        sb.append(node.getData()).append("");
        sb.append(inOrderTraversalHelper(node.getRight()));

        return sb.toString();
    }

    public String preOrderTraversal(){
        return preOrderTraversalHelper(getRoot());
    }

    public String preOrderTraversalHelper(BNode node){
        if (isEmpty()){
            return null;
        }

        StringBuilder sb = new StringBuilder();

        sb.append(node.getData()).append("");
        sb.append(preOrderTraversalHelper(node.getLeft()));
        sb.append(preOrderTraversalHelper(node.getRight()));

        return sb.toString();
    }

    public String posOrderTraversal(){
        return posOrderTraversalHelper(getRoot());
    }

    public String posOrderTraversalHelper(BNode node){
        if (isEmpty()){
            return null;
        }

        StringBuilder sb = new StringBuilder();

        sb.append(posOrderTraversalHelper(node.getLeft()));
        sb.append(posOrderTraversalHelper(node.getRight()));
        sb.append(node.getData()).append("");

        return sb.toString();
    }

    public BNode parenteses(BNode node){
        if(node == null){
            return;
        }


    }

    public BNode search(BNode node, int data){
        if (node == null){
            return null;
        } else if(data == node.getData()){
            return node;
        }    else if(data<node.getData()){
            return search(node.getLeft(), data);
        } else {
            return search(node.getRight(), data);
        }
    }


    public void insert(int data){
        this.setRoot(insertHelper(getRoot(), null, data));
    }

    public BNode insertHelper(BNode node, BNode parent, int data){
        if (node == null){
            BNode newNode = new BNode(data);
            newNode.setParent(parent);
            return newNode;
        } else if(data<node.getData()){
            node.setLeft(insertHelper(node.getLeft(), node, data));
        } else if(data>node.getData()){
            node.setRight(insertHelper(node.getRight(), node, data));
        } else {
            return node;
        }
        return node;
    }

    public BNode remover(BNode node, int data){
        if(node == null){
            return null;
        } else if (data<node.getData()){
            node.setLeft(remover(node.getLeft(), data));
        } else if(data>node.getData()){
            node.setRight(remover(node.getRight(), data));
        } else {
            if (node.getLeft()==null){
                return node.getRight();
            } else if(node.getRight()==null){
                return node.getLeft();
            } else {
                BNode temp = findMin(node.getRight());
                node.setData(temp.getData());
                node.setRight(remover(node.getRight(), temp.getData()));
            }
        }
        return node;
    }

    public BNode findMin(BNode node){
        while(node != null){
            node = node.getLeft();
        }
        return node;
    }
    

    public Node remover(BNode node, int data){
        if (node == null){
            return null;
        } else if(data<node.getData()){
            node.setLeft(remover(node.getLeft(), data));
        } else if(data>node.getData()){
            node.setRight(remover(node.getRight(), data));
        } else {
            if (node.getRight == null){
                return node.getLeft();
            } else if (node.getLeft()==null){
                return node.getRight();
            } else {
                BNode temp = findMin(node.getRight());
                node.setData(temp.getData);
                node.setRight(remover(node.getRight, temp.getData()));
            }
        }
        return node;
    }

    public BNode search(BNode node, int data){
        if (node ==null){
            return null;
        } else if(data==node.getData()){
            return node;
        } else if(data<node.getData()){
            return search(node.getleft(), data);
        } else {
            return search(node.getRight(), data);
        }
    }

    public BNode insert(int data){
        return this.setRoot(insertHelper(root, data, null));
    }
    public BNode insertHelper(BNode node, int data, BNode parent){
        if (node)
    }
    @Override
	public String toString() {
		return "BinaryTree - isEmpty(): " + isEmpty()
				+ ", getDegree(): " + getDegree()
				+ ", getHeight(): " + getHeight()
				+ ", root => { " + root + " }";				
	}
}
