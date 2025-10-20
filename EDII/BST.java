package EDII;

public class BST extends BinaryTree{
    public BST(BTNode root){
        super(root);
    }

    public BST(){
        this(null);
    }

    public BTNode search(BTNode node, int data){
        if (node == null){
            return null;
        } else if (node.getData() == data){
            return node;
        } else if(data<node.getData()){
            return search(node.getLeft(), data);
        } else {
            return search(node.getRight(), data);
        }
    }

    public void insert(int data) {
        this.setRoot(insertHelper(getRoot(), null, data));
    }   

    public BTNode insertHelper(BTNode node, BTNode parent, int data){
        if (node ==null){
            BTNode newNode = new BTNode(data);
            newNode.setParent(parent);
            return newNode;
        } else if(node.getData()>data){
            node.setLeft(insertHelper(node.getLeft(), node, data));
        } else if(node.getData()<data){
            node.setRight(insertHelper(node.getLeft(), node, data));
        }
        return node;
    }

    public void clearAll(){
        this.setRoot(clearAllHelper(getRoot()));
    }

    public void clearAllHelper(BNode node){
        if(node == null){
            return;
        }
        node.setLeft(clearAllHelper(node.getleft()));
        

    }







    public void clearall(){
        this.setRoot(clearAllHelper(getRoot()));
    }

    private BTNode clearAllHelper(BTNode node){
        if (node == null){
            return null;
        }
        node.setLeft(clearAllHelper(node.getLeft()));
        node.setRight(clearAllHelper(node.getRight()));
        node.setParent(null);
        node.setLeft(null);
        node.setRight(null);

        return null;
    }

    public BTNode remover(BTNode node, int data){
        if (node == null){
            return null;
        } else if (data<node.getData()){
            node.setLeft(remove(node.getLeft(), data));
        } else if (data>node.getData()){
            node.setRight(remove(node.getRight(), data));
        } else {
            if(node.getRight()==null){
                return node.getLeft();
            } else if(node.getLeft()==null){
                return node.getRight();
            } else {
                BTNode temp = findMinn(node.getRight());
                node.setData(temp.getData());
                node.setRight(remove(node.getRight(), temp.getData()));
            
            }
            
        }
        return node;
        
    }

    public BTNode findMinn(BTNode node){
        while(node.getLeft() !=null){
            node = node.getLeft();
        }
        return node;
    }





















    public BTNode remove(BTNode node, int data){
        if (node == null){
            return null;
        } else if (data<node.getData()){
            node.setLeft(remove(node.getLeft(), data));
        } else if(data>node.getData()){
            node.setRight(remove(node.getRight(), data));
        } else{
            if(node.getLeft() == null){
                return node.getRight();
            } else if (node.getRight() == null){
                return node.getLeft();
            }

            BTNode temp = findMin(node.getRight());
            node.setData(temp.getData());

            node.setRight(remove(node.getRight(), temp.getData()));
        }

        return node;
        
    }

    public void clear(){
        this.setRoot(null);
    }

    public BTNode findMin(BTNode node){
        while (node.getLeft()!=null){
            node = node.getLeft();
        }
        return node;
    }

    public BTNode findMax(BTNode node){
        while (node.getRight()!=null){
            node = node.getRight();
        }
        return node;
    }

    
    

}
