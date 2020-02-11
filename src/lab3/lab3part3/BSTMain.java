package lab3.lab3part3;

public class BSTMain {

    public static void main(String args[]){
        BST bst = new BST();

        System.out.println(bst);
        System.out.println(bst.numEvens());

        for (int i = 0; i < 10; i++) {
            bst.insert(i);
            System.out.println(bst);

            System.out.println(bst.numEvens());
        }
    }
}
