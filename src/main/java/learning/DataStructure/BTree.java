package learning.DataStructure;

public class BTree {

    public static void main(String[] args) {
        BST bst = new BST(null);

        bst.insertData("Kaka");
        bst.insertData("NKaka");
        bst.insertData("AKaka");

        bst.preOrder();
    }
}
