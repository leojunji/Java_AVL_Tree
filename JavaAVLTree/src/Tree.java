import errors.TreeIsNull;
import errors.ValueDuplicated;
import errors.ValueNonAvailable;

public class Tree implements AVL {

    private Node root;

    public Tree() {
        this.root = null;
    }

    private String show(int data) {
        return ("(" + data + ")");
    }

    public void showCell(Node node) {
        if(node!=null) this.printCell(node);
    }


    @Override
    public void insert(int data){

        try {
           this.toInsertAVL(this.root,data);
        } catch (ValueDuplicated e) {
            System.out.println(show(data) + "Value was not inserted: " + e.getMessage());
        }

    }

    /**
     * @param root is modified during the recursion
     * @param data the new_value
     * @throws ValueDuplicated if the new_value already exists in tree
     */
    private void toInsertAVL(Node root, int data) throws ValueDuplicated{

        Node new_value = new Node(data);

        if(this.root ==null) this.root = new_value;


        else if(root.getInfo() == data)  throw new ValueDuplicated();


        else if(data < root.getInfo()) {
            if(root.getLeft() == null ) root.setLeft(new_value);
            else {
                toInsertAVL(root.getLeft(), data);
                return;
            }
        }


        else if(data > root.getInfo()) {
            if(root.getRight() == null) root.setRight(new_value);
            else {
                toInsertAVL(root.getRight(), data);
                return;
            }
        }


        this.toBalance(new_value);

    }

    /**
     * @param node is balanced if his factor isn't between -1 or 1
     */
    private void toBalance(Node node) {
        if(node==null) return;
        int fator = this.isFactor(node);

        if ( fator == 2 ) {
            if (this.isFactor(node.getLeft())>0) {
                toRightRotation(node);
            }else {
                toDoubleRightRotation(node) ;}
        }
        else if (fator == -2 ) {
            if ( this.isFactor(node.getRight())<0 ) {
                toLeftRotation(node);
            } else {
                toDoubleLeftRotation(node); }
        }


        this.toBalance(this.isAntecedent(this.root, node));

    }

    /**
     * @param father goes to the right of his left_child
     * @return the left_child
     */
    private Node toRightRotation(Node father) {

        Node left_child = father.getLeft();

        father.setLeft(left_child.getRight());

        left_child.setRight(father);

        if (father == this.root) {
            this.root = left_child;
        } else {
            Node grandFather = this.isAntecedent(this.root, father);
            if (grandFather.getLeft() == father) {
                grandFather.setLeft(left_child);
            } else {
                grandFather.setRight(left_child);
            }
        }

        return left_child;
    }


    /**
     * @param father goes to the left of his right_child
     * @return the right_child
     */
    private Node toLeftRotation(Node father) {

        Node right_child = father.getRight();

        father.setRight(right_child.getLeft());

        right_child.setLeft(father);

        if (father == this.root) {
            this.root = right_child;
        } else {
            Node grandFather = this.isAntecedent(this.root, father);
            if (grandFather.getLeft() == father) {
                grandFather.setLeft(right_child);
            } else {
                grandFather.setRight(right_child);
            }
        }

        return right_child;
    }

    /**
     * @param node to be cauculated
     * @return the node factor(leftHeight - rightHeight)
     */
    private int isFactor(Node node) {
        return this.isHeight(node.getLeft()) - this.isHeight(node.getRight());
    }

    /**
     * @param node is pre-considered the right or left child. That is why he adds +1 when returning the height
     * @return the height of the node
     */
    private int isHeight(Node node) {
        if (node == null) {
            return -1;
        }
        int leftHeight = isHeight(node.getLeft());
        int rightHeight = isHeight(node.getRight());

        if (leftHeight > rightHeight) {
            return 1 + leftHeight;
        } else {
            return 1 + rightHeight;
        }
    }

    /**
     * @param father is the antecedent Node
     * @param child the consequent Node
     * @return the antecedent Node(AKA father)
     */
    private Node isAntecedent(Node father, Node child) {

        if(child==null || father==child) return null;

        else if(child.getInfo() < father.getInfo()) {
            return father.getLeft() == child ? father :
                    isAntecedent(father.getLeft(), child);
        }


        else if(child.getInfo() > father.getInfo()) {
            return father.getRight() == child ? father :
                    isAntecedent(father.getRight(), child);
        }

        return father;
    }

    private Node toDoubleRightRotation(Node beginner) {
        beginner.setLeft(toLeftRotation(beginner.getLeft()));
        return toRightRotation(beginner);
    }



    private Node toDoubleLeftRotation(Node beginner) {
        beginner.setRight(toRightRotation(beginner.getRight()));
        return toLeftRotation(beginner);
    }

    @Override
    public void remove(int removedValue) {

        try {
            Node node = this.searchData(this.root, removedValue);
            this.toRemove(node);
        } catch (ValueNonAvailable e) {
            System.out.println(show(removedValue) +"Value was not removed: " + e.getMessage());
        }


    }

    /**
     * @param removedNode to be removed
     */
    private void toRemove(Node removedNode) {
        Node new_node;
        Node father = this.isAntecedent(this.root, removedNode);
        if(removedNode.getLeft()!=null & removedNode.getRight()!=null) {
            Node biggerLeftDescendent = this.maiorEsquerda(removedNode.getLeft());
            new_node = new Node(biggerLeftDescendent.getInfo());
            new_node.setLeft(removedNode.getLeft());
            new_node.setRight(removedNode.getRight());
            this.toRemove(biggerLeftDescendent);
        } else {
            new_node = removedNode.getLeft() != null ?
                    removedNode.getLeft() : removedNode.getRight();
        }
        if(father!=null) {
            if(father.getLeft()==removedNode) father.setLeft(new_node);
            else father.setRight(new_node);
            this.toBalance(father);
        }else {
            this.root = new_node;
            this.toBalance(this.root);
        }

    }

    private Node maiorEsquerda(Node noEsquerdo) {
        return noEsquerdo.getRight() == null ? noEsquerdo : maiorEsquerda(noEsquerdo.getRight());
    }

    @Override
    public Node find(int data) {
        try {
             return this.searchData(this.root, data);
        } catch (ValueNonAvailable e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * @param root is modified during the recursion
     * @param data to be searched
     * @return the data
     * @throws ValueNonAvailable if the value isn't available
     */
    private Node searchData(Node root, int data) throws ValueNonAvailable {

        if(root==null) throw new ValueNonAvailable();

        if(root.getInfo() == data) return root;

        else if(data < root.getInfo()) {
            return searchData(root.getLeft(), data);
        }


        else if(data > root.getInfo()) {
            return searchData(root.getRight(), data);
        }

        return null;
    }

    @Override
    public void preOrder() {
        try {
            preOrder(root);
        } catch (TreeIsNull e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void inOrder() {

        try {
            inOrder(root);
        } catch (TreeIsNull e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void postOrder() {

        try {
            postOrder(root);
        } catch (TreeIsNull e) {
            System.out.println(e.getMessage());
        }
    }

    private void preOrder(Node node) throws TreeIsNull {
        treeState();
        this.printCell(node);
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

    private void inOrder(Node node) throws TreeIsNull {
        treeState();
        inOrder(node.getLeft());
        this.printCell(node);
        inOrder(node.getRight());
    }

    private void postOrder(Node node) throws TreeIsNull {
        treeState();
        if (node == null) return;
        postOrder(node.getLeft());
        postOrder(node.getRight());
        this.printCell(node);
    }



    private void printCell(Node cell) {
        System.out.println(cell + " Factor: " + this.isFactor(cell));
    }

    private void treeState() throws TreeIsNull {
        if(this.root==null) throw new TreeIsNull();
    }
}
