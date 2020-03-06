package Lab5;

public class BSTMainLab5Ex1 {

    public static void main(String args[]){
        BST bst = new BST();

        System.out.println(bst);
        System.out.println(bst.getDepth());

        for (int i = 0; i < 10; i++) {
            bst.insert(i);
        }
        System.out.println(bst);
        System.out.println(bst.getDepth());

        System.out.println("\n\nA more traditional binary search tree\n");

        BST bst2 = new BST();
        bst2.insert(3);
        bst2.insert(1);
        bst2.insert(0);
        bst2.insert(2);
        bst2.insert(5);
        bst2.insert(4);
        bst2.insert(6);
        System.out.println(bst2);
        System.out.println("");

        System.out.println(bst2.delete(1));
        System.out.println(bst2);
        System.out.println("");

        System.out.println(bst2.delete(5));
        System.out.println(bst2);
        System.out.println("");

        bst2.delete(6);
        bst2.delete(0);
        System.out.println(bst2);

    }
}
