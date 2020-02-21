package lab5;

import java.util.Random;

public class testingDeletionDepthUpdate {

    public static void main(String args[]) {

        Random rand = new Random();

        BST bst = makeRandomTree(rand);

        System.out.println(bst.getDepth());

        removeStuffFromTree(rand,bst);

        System.out.println(bst.getDepth());

    }

    public static BST makeRandomTree(Random rand){
        BST randomTree = new BST();
        for (int i = 0; i < 1000; i++) {
            randomTree.insert(rand.nextInt(10000));
        }
        return randomTree;
    }

    public static void removeStuffFromTree(Random rand, BST tree){
        int deletions = 0;
        int i = 0;
        while (deletions < 10 || i < 10000) {
            if (tree.delete(i)){
                deletions++;
            }
            i++;
        }
        System.out.println(deletions);
    }
}
