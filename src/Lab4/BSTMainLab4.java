package Lab4;

public class BSTMainLab4 {

    public static void main(String args[]){
        BST<Integer> bst = new BST<>();

        System.out.println(bst);

        for (int i = 0; i < 10; i++) {
            System.out.println(bst.insert(i));
            System.out.println(bst);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(bst.insert(i));
        }

        System.out.println(bst);
        System.out.println("\n");
        for (int i = 0; i < 10; i++) {
            System.out.println(bst.delete(i));
            System.out.println(bst);
        }

        BST<Integer> bst2 = new BST<>();


        System.out.println("\nand now a more traditional binary tree\n");

        bst2.insert(3);
        bst2.insert(1);
        bst2.insert(0);
        bst2.insert(2);
        bst2.insert(5);
        bst2.insert(4);
        bst2.insert(6);
        System.out.println(bst2);
        System.out.println("");

        for (int i = 0; i < 7; i++) {
            System.out.println(bst2.delete(i));
            System.out.println(bst2);
        }

        System.out.println("\nand now another messed up tree but yeeting everything in reverse\n");

        BST<Integer> bst3 = new BST<>();
        for (int i = 0; i < 10; i++) {
            bst3.insert(i);
        }
        System.out.println(bst3);
        for (int i = 9; i > -1 ; i--) {
            bst3.delete(i);
            System.out.println(bst3);
        }

    }
}
