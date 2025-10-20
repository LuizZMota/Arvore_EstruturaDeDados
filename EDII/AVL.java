package EDII;

public class AVL extends BST{

public AVLTreeRec(BTNode root){
    super(root);
}

//O parametro "no" é a raiz da subarvore que precisa ser balanceada
public BTNode rotateRight(BTNode no){
    boolean ehraiz = (no == getRoot()) ? true : false;

    BNode esq = no.getLeft();
    BNode temp = esq.getRight();

    no.setLeft(temp);
    if(temp != null) temp.setParent(no);

    esq.setRight(no);
    no.setParent(esq);

    updateBalance(no);

    if(ehraiz){
    setRoot(esq);
    }

    return esq;
}

public BNode rotateLeft(BNode no){
    boolean ehraiz = (no == getRoot()) ? true : false;

    BNode dir = no.getRight();
    BNode temp = dir.getLeft();

    no.setRight(temp);
    if(temp != null) temp.setParent(no);

    dir.setLeft(no);
    no.setParent(dir);

    updateBalance(no);


    if(ehraiz){
        setRoot(dir);
    }
    return dir;
}

public BNode rotateLeftRight(BNode no){
    no.setLeft(rotateLeft(no.getLeft()));
    return rotateRight(no);
}

public BNode rotateRightLeft(BNode no){
    no.setRight(rotateRight(no.getRight()));
    return rotateLeft(no);
}

public int getHeight(BNode no){
    if(no == null){
        return 0;
    }

    return 1 + Math.max(getHeight(no.getRight()), getHeight(no.getLeft()));
}

public int getBalance(BNode no){ //Pega o fator de balanceamento
    return getHeight(no.getLeft()) - getHeight(no.getRight());
}

public void updateBalance(BNode no){ //Atualiza o fator de Balanceamento
    no.setFB(getBalance(no));
}
