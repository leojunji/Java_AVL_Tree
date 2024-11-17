public class Node {
    private int info;
    private Node right;
    private Node left;

    public Node(int info) {
        this.info = info;
        this.right = null;
        this.left = null;
    }

    @Override
    public String toString() {
        return "Node" +
                "= " + info +
                "[" + (left != null ? left.info : "null") +
                ", " +(right != null ? right.info : "null") +
                ']';
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }


}
