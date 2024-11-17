public class Main {
    public static void main(String[] args) {

        Tree a = new Tree();
        for (int i = 1; i < 100; i++) {
            a.insert(i);
        }
        a.postOrder();
    }
}