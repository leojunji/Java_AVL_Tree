public interface AVL {

    /**
     * @param data to be insert in AVLtree
     */
    void  insert(int data);

    /**
     * @param removedValue to be searched and removed from AVLtree
     */
    void remove(int removedValue);

    /**
     * @param data to be searched
     * @return the node
     */
    Node find(int data);
    /**
     * (Left -> Right -> Root)
     */
    void postOrder();
    /**
     *  (Root -> Left -> Right)
     */
    void preOrder();
    /**
     * (Left -> Root -> Right)
     */
    void inOrder();
}
